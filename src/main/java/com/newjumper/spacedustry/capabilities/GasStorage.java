package com.newjumper.spacedustry.capabilities;

import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;

public class GasStorage implements IGasStorage, INBTSerializable<Tag> {
    protected GasTypes type;
    protected int gas;
    protected int capacity;

    public GasStorage(GasTypes type, int capacity) {
        this(type, 0, capacity);
    }

    public GasStorage(GasTypes type, int gas, int capacity) {
        this.type = type;
        this.gas = gas;
        this.capacity = capacity;
    }

    @Override
    public int insertGas(int insert) {
        return gas += Math.min(insert, capacity - gas);
    }

    @Override
    public int extractGas(int extract) {
        gas -= extract;
        if(gas < 0) gas = 0;
        return gas;
    }

    @Override
    public boolean setGas(int set) {
        if(set > capacity) {
            gas = capacity;
            return false;
        }

        gas = set;
        return true;
    }

    @Override
    public int getGasStored() {
        return gas;
    }

    @Override
    public int getGasCapacity() {
        return capacity;
    }

    @Override
    public GasTypes getGasType() {
        return type;
    }

    @Override
    public Tag serializeNBT() {
        return IntTag.valueOf(this.getGasStored());
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        if(!(nbt instanceof IntTag intNbt)) throw new IllegalArgumentException("Cannot deserialize to an instance that isn't the default implementation");
        this.gas = intNbt.getAsInt();
    }

    protected void onGasChanged() {}
}
