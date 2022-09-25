package com.newjumper.spacedustry.capabilities;

public interface IGasStorage {
    int insertGas(int insert);

    int extractGas(int extract);

    boolean setGas(int set);

    int getGasStored();

    int getGasCapacity();

    GasTypes getGasType();
}
