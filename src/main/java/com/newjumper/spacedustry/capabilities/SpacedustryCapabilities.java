package com.newjumper.spacedustry.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class SpacedustryCapabilities {
    public static final Capability<IGasStorage> GAS = CapabilityManager.get(new CapabilityToken<>() {});
}
