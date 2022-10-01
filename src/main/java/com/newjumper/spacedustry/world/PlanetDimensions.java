package com.newjumper.spacedustry.world;

import com.newjumper.spacedustry.Spacedustry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;

public class PlanetDimensions {
    public static final ResourceKey<DimensionType> MOON = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(Spacedustry.MOD_ID, "the_moon"));
}
