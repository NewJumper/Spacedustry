package com.newjumper.spacedustry.world;

import com.newjumper.spacedustry.Spacedustry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

public class PlanetDimensions {
    public static final ResourceKey<Level> MOON_LEVEL = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(Spacedustry.MOD_ID, "the_moon"));
    public static final ResourceKey<DimensionType> MOON = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(Spacedustry.MOD_ID, "the_moon"));

    public static void bootstrap(BootstapContext<DimensionType> context) {
        context.register(MOON, new DimensionType(OptionalLong.empty(), true, false, false, true, 1, true, false, 0, 256, 256, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0f, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
    }
}
