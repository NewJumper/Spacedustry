package com.newjumper.spacedustry.screen;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.block.entity.GasCondenserBlockEntity;
import com.newjumper.spacedustry.capabilities.SpacedustryCapabilities;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class GasCondenserMenu extends AbstractContainerMenu {
    private static final int INV_SLOTS = 36;
    private static final int MENU_SLOTS = 2;
    public final GasCondenserBlockEntity blockEntity;
    private final Level level;

    public GasCondenserMenu(int containerId, Inventory inventory, FriendlyByteBuf buffer) {
        this(containerId, inventory, inventory.player.level.getBlockEntity(buffer.readBlockPos()));
    }

    public GasCondenserMenu(int pContainerId, Inventory pInventory, BlockEntity pBlockEntity) {
        super(SpacedustryMenuTypes.GAS_CONDENSER_MENU.get(), pContainerId);
        this.blockEntity = (GasCondenserBlockEntity) pBlockEntity;
        this.level = pInventory.player.level;

        checkContainerSize(pInventory, MENU_SLOTS);
        addInventorySlots(pInventory);
        saveData();

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(itemHandler -> {
            addSlot(new SlotItemHandler(itemHandler, 0, 137, 25));
            addSlot(new SlotItemHandler(itemHandler, 1, 137, 49));
        });
    }

    private void addInventorySlots(Inventory inventory) {
        for(int i = 0; i < 9; i++) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 142));
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }

    private void saveData() {
        addDataSlot(new DataSlot() {
            @Override
            public int get() {
                return getGas() & 0xffff;
            }

            @Override
            public void set(int pValue) {
                blockEntity.getCapability(SpacedustryCapabilities.GAS).ifPresent(gasStorage -> {
                    int heatStored = gasStorage.getGasStored() & 0xffff0000;
                    gasStorage.setGas(heatStored + (pValue & 0xffff));
                });
            }
        });
        addDataSlot(new DataSlot() {
            @Override
            public int get() {
                return (getGas() >> 16) & 0xffff;
            }

            @Override
            public void set(int pValue) {
                blockEntity.getCapability(SpacedustryCapabilities.GAS).ifPresent(gasStorage -> {
                    int heatStored = gasStorage.getGasStored() & 0x0000ffff;
                    gasStorage.setGas(heatStored | (pValue << 16));
                });
            }
        });
    }

    @NotNull
    @Override
    public ItemStack quickMoveStack(@NotNull Player pPlayer, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if(!sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceItem = sourceSlot.getItem();
        if(pIndex < INV_SLOTS) {
            if(!moveItemStackTo(sourceItem, INV_SLOTS, INV_SLOTS + MENU_SLOTS, false)) return ItemStack.EMPTY;
        } else if(pIndex < INV_SLOTS + MENU_SLOTS) {
            if(!moveItemStackTo(sourceItem, 0, INV_SLOTS, false)) return ItemStack.EMPTY;
        } else return ItemStack.EMPTY;

        if(sourceItem.getCount() == 0) sourceSlot.set(ItemStack.EMPTY);
        else sourceSlot.setChanged();

        sourceSlot.onTake(pPlayer, sourceItem);
        return sourceItem;
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, SpacedustryBlocks.GAS_CONDENSER.get());
    }

    public int getGas() {
        return this.blockEntity.hydrogenStorage.getGasStored();
    }

    public int drawGas() {
        return getGas() == 0 ? 0 : Math.max((int) (getGas() / (double) blockEntity.hydrogenStorage.getGasCapacity() * 44), 1);
    }
}
