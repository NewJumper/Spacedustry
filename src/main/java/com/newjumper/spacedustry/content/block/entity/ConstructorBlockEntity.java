package com.newjumper.spacedustry.content.block.entity;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.SpacedustryBlocks;
import com.newjumper.spacedustry.content.screen.ConstructorMenu;
import com.newjumper.spacedustry.recipe.ConstructingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import java.util.Optional;

@SuppressWarnings("NullableProblems")
public class ConstructorBlockEntity extends BlockEntity implements MenuProvider {
    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int pIndex) {
            return switch (pIndex) {
                case 0 -> ConstructorBlockEntity.this.fuel;
                case 1 -> ConstructorBlockEntity.this.maxFuel;
                case 2 -> ConstructorBlockEntity.this.progress;
                case 3 -> ConstructorBlockEntity.this.maxProgress;
                default -> 0;
            };
        }

        @Override
        public void set(int pIndex, int pValue) {
            switch (pIndex) {
                case 0 -> ConstructorBlockEntity.this.fuel = pValue;
                case 1 -> ConstructorBlockEntity.this.maxFuel = pValue;
                case 2 -> ConstructorBlockEntity.this.progress = pValue;
                case 3 -> ConstructorBlockEntity.this.maxProgress = pValue;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };
    private final LazyOptional<IItemHandler> lazyItemHandler;
    public final ItemStackHandler itemHandler;
    private int fuel;
    private int maxFuel;
    private int progress;
    private int maxProgress;

    public ConstructorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(SpacedustryBlockEntities.CONSTRUCTOR.get(), pPos, pBlockState);

        this.itemHandler = new ItemStackHandler(4) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }
        };

        this.lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container." + Spacedustry.MOD_ID + "." + SpacedustryBlocks.CONSTRUCTOR.getId().getPath());
    }

    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ConstructorMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("fuel", this.fuel);
        pTag.putInt("maxFuel", this.maxFuel);
        pTag.putInt("progress", this.progress);
        pTag.putInt("maxProgress", this.maxProgress);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        this.fuel = pTag.getInt("fuel");
        this.maxFuel = pTag.getInt("maxFuel");
        this.progress = pTag.getInt("progress");
        this.maxProgress = pTag.getInt("maxProgress");
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) return lazyItemHandler.cast();

        return super.getCapability(cap);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void dropContents() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ConstructorBlockEntity blockEntity) {
        SimpleContainer container = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for(int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            container.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<ConstructingRecipe> recipe = level.getRecipeManager().getRecipeFor(ConstructingRecipe.Type.INSTANCE, container, level);
        recipe.ifPresent(constructingRecipe -> blockEntity.maxProgress = constructingRecipe.getTime());

        if(blockEntity.isActive()) blockEntity.fuel--;

        if(canConstruct(level, container, recipe) && !blockEntity.isActive()) {
            double constant = blockEntity.getFuelCapacity(blockEntity.itemHandler.getStackInSlot(0)) / 200.0;
            blockEntity.maxFuel = (int) (blockEntity.maxProgress * constant);
            blockEntity.fuel = blockEntity.maxFuel;
            blockEntity.itemHandler.extractItem(0, 1, false);
        }

        if(canConstruct(level, container, recipe) && blockEntity.isActive()) {
            blockEntity.progress++;
            if(blockEntity.progress == blockEntity.maxProgress) {
                blockEntity.itemHandler.extractItem(1,1, false);
                blockEntity.itemHandler.extractItem(2,1, false);
                blockEntity.itemHandler.setStackInSlot(3, new ItemStack(recipe.get().getResultItem(level.registryAccess()).getItem(), blockEntity.itemHandler.getStackInSlot(3).getCount() + recipe.get().getResultItem(level.registryAccess()).getCount()));

                blockEntity.progress = 0;
            }
        }

        if(blockEntity.itemHandler.getStackInSlot(1).isEmpty() || blockEntity.itemHandler.getStackInSlot(2).isEmpty()) blockEntity.progress = 0;
        setChanged(level, pos, state);
    }

    private static boolean canConstruct(Level level, SimpleContainer container, Optional<ConstructingRecipe> recipe) {
        int output = container.getContainerSize() - 1;
        return recipe.isPresent() && (container.getItem(output).getItem() == recipe.get().getResultItem(level.registryAccess()).getItem() || container.getItem(output).isEmpty()) && (container.getItem(output).getCount() < container.getItem(output).getMaxStackSize());
    }

    private boolean isActive() {
        return this.fuel > 0;
    }

    private int getFuelCapacity(ItemStack stack) {
        return stack.isEmpty() ? 0 : ForgeHooks.getBurnTime(stack, null);
    }
}
