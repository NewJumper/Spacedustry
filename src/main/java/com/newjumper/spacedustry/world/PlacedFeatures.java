package com.newjumper.spacedustry.world;

import com.newjumper.spacedustry.Spacedustry;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class PlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Spacedustry.MOD_ID);

    public static final RegistryObject<PlacedFeature> ORE_ALUMINUM = PLACED_FEATURES.register("ore_aluminum", () -> new PlacedFeature(ConfiguredFeatures.ORE_ALUMINUM.getHolder().get(), commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
    public static final RegistryObject<PlacedFeature> ORE_LITHIUM = PLACED_FEATURES.register("ore_lithium", () -> new PlacedFeature(ConfiguredFeatures.ORE_LITHIUM.getHolder().get(), commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));
    public static final RegistryObject<PlacedFeature> ORE_TUNGSTEN = PLACED_FEATURES.register("ore_tungsten", () -> new PlacedFeature(ConfiguredFeatures.ORE_TUNGSTEN.getHolder().get(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier range) {
        return List.of(count, InSquarePlacement.spread(), range, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier range) {
        return orePlacement(CountPlacement.of(count), range);
    }
}
