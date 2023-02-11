package com.newjumper.spacedustry.block.entity;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.capabilities.GasStorage;
import com.newjumper.spacedustry.capabilities.GasTypes;
import com.newjumper.spacedustry.capabilities.IGasStorage;
import com.newjumper.spacedustry.capabilities.SpacedustryCapabilities;
import com.newjumper.spacedustry.screen.GasCondenserMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

@SuppressWarnings("NullableProblems")
public class GasCondenserBlockEntity extends BlockEntity implements MenuProvider {
    private final LazyOptional<IItemHandler> lazyItemHandler;
    private final LazyOptional<IGasStorage> lazyHydrogenStorage;
    public final ItemStackHandler itemHandler;
    public final GasStorage hydrogenStorage;

    public GasCondenserBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(SpacedustryBlockEntities.GAS_CONDENSER.get(), pPos, pBlockState);

        this.itemHandler = new ItemStackHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }
        };
        this.hydrogenStorage = new GasStorage(GasTypes.HYDROGEN, 1000) {
            @Override
            protected void onGasChanged() {
                setChanged();
            }
        };

        this.lazyItemHandler = LazyOptional.of(() -> itemHandler);
        this.lazyHydrogenStorage = LazyOptional.of(() -> hydrogenStorage);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container." + Spacedustry.MOD_ID + "." + SpacedustryBlocks.GAS_CONDENSER.getId().getPath());
    }

    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new GasCondenserMenu(pContainerId, pPlayerInventory, this);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.put("gas", hydrogenStorage.serializeNBT());
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        hydrogenStorage.deserializeNBT(pTag.getCompound("gas"));
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) return lazyItemHandler.cast();
        if(cap == SpacedustryCapabilities.GAS) return lazyHydrogenStorage.cast();

        return super.getCapability(cap);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyHydrogenStorage.invalidate();
    }

    public void dropContents() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, GasCondenserBlockEntity blockEntity) {
        if(blockEntity.canCondense()) blockEntity.hydrogenStorage.insertGas(1);

        setChanged(level, pos, state);
    }

    public boolean canCondense() {
        return this.hydrogenStorage.getGasStored() < this.hydrogenStorage.getGasCapacity() && this.itemHandler.getStackInSlot(0).is(Blocks.PACKED_ICE.asItem());
    }
}
