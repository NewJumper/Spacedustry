package com.newjumper.spacedustry.block.entity;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import com.newjumper.spacedustry.recipe.ManufacturingRecipe;
import com.newjumper.spacedustry.screen.ManufacturerMenu;
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
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import java.util.Optional;

@SuppressWarnings("NullableProblems")
public class ManufacturerBlockEntity extends BlockEntity implements MenuProvider {
    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int pIndex) {
            return switch (pIndex) {
                case 0 -> ManufacturerBlockEntity.this.power;
                case 1 -> ManufacturerBlockEntity.this.progress;
                case 2 -> ManufacturerBlockEntity.this.maxProgress;
                default -> 0;
            };
        }

        @Override
        public void set(int pIndex, int pValue) {
            switch (pIndex) {
                case 0 -> ManufacturerBlockEntity.this.power = pValue;
                case 1 -> ManufacturerBlockEntity.this.progress = pValue;
                case 2 -> ManufacturerBlockEntity.this.maxProgress = pValue;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    };
    private final LazyOptional<IItemHandler> lazyItemHandler;
    public final ItemStackHandler itemHandler;
    private int power;
    private int progress;
    private int maxProgress;

    public ManufacturerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(SpacedustryBlockEntities.MANUFACTURER.get(), pPos, pBlockState);

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
        return Component.translatable("container." + Spacedustry.MOD_ID + "." + SpacedustryBlocks.MANUFACTURER.getId().getPath());
    }

    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ManufacturerMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("power", this.power);
        pTag.putInt("progress", this.progress);
        pTag.putInt("maxProgress", this.maxProgress);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        this.power = pTag.getInt("power");
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

    public static void tick(Level level, BlockPos pos, BlockState state, ManufacturerBlockEntity blockEntity) {
        SimpleContainer container = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for(int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            container.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<ManufacturingRecipe> recipe = level.getRecipeManager().getRecipeFor(ManufacturingRecipe.Type.INSTANCE, container, level);
        recipe.ifPresent(manufacturingRecipe -> blockEntity.maxProgress = manufacturingRecipe.getTime());

        if(canManufacture(container, recipe) && !blockEntity.isActive()) {
            if(blockEntity.itemHandler.getStackInSlot(0).is(SpacedustryItems.COMPOSITE_BUILDER.get())) {
                blockEntity.itemHandler.extractItem(0, 1, false);
                blockEntity.power = 4;
            }
        }

        if(canManufacture(container, recipe) && blockEntity.isActive()) {
            blockEntity.progress++;
            if(blockEntity.progress == blockEntity.maxProgress) {
                blockEntity.itemHandler.extractItem(1,1, false);
                blockEntity.itemHandler.extractItem(2,1, false);
                blockEntity.itemHandler.setStackInSlot(3, new ItemStack(recipe.get().getResultItem().getItem(), blockEntity.itemHandler.getStackInSlot(3).getCount() + recipe.get().getResultItem().getCount()));

                blockEntity.progress = 0;
                blockEntity.power--;
            }
        }

        if(blockEntity.itemHandler.getStackInSlot(1).isEmpty() || blockEntity.itemHandler.getStackInSlot(2).isEmpty()) blockEntity.progress = 0;
        setChanged(level, pos, state);
    }

    private static boolean canManufacture(SimpleContainer container, Optional<ManufacturingRecipe> recipe) {
        int output = container.getContainerSize() - 1;
        return recipe.isPresent() && (container.getItem(output).getItem() == recipe.get().getResultItem().getItem() || container.getItem(output).isEmpty()) && (container.getItem(output).getCount() < container.getItem(output).getMaxStackSize());
    }

    private boolean isActive() {
        return this.power > 0;
    }
}
