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

    public static final RegistryObject<PlacedFeature> ORE_ALUMINUM_UPPER = PLACED_FEATURES.register("ore_aluminum_upper", () -> new PlacedFeature(ConfiguredFeatures.ORE_ALUMINUM_UPPER.getHolder().get(), commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(64), VerticalAnchor.aboveBottom(256)))));
    public static final RegistryObject<PlacedFeature> ORE_ALUMINUM_LOWER = PLACED_FEATURES.register("ore_aluminum_lower", () -> new PlacedFeature(ConfiguredFeatures.ORE_ALUMINUM_LOWER.getHolder().get(), commonOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-72), VerticalAnchor.aboveBottom(72)))));
    public static final RegistryObject<PlacedFeature> ORE_LITHIUM = PLACED_FEATURES.register("ore_lithium", () -> new PlacedFeature(ConfiguredFeatures.ORE_LITHIUM.getHolder().get(), commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60), VerticalAnchor.aboveBottom(86)))));
    public static final RegistryObject<PlacedFeature> ORE_MOLYBDENITE = PLACED_FEATURES.register("ore_molybdenite", () -> new PlacedFeature(ConfiguredFeatures.ORE_MOLYBDENITE.getHolder().get(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-14), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<PlacedFeature> ORE_NICKEL = PLACED_FEATURES.register("ore_nickel", () -> new PlacedFeature(ConfiguredFeatures.ORE_NICKEL.getHolder().get(), commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(40), VerticalAnchor.aboveBottom(124)))));
    public static final RegistryObject<PlacedFeature> ORE_SILICON = PLACED_FEATURES.register("ore_silicon", () -> new PlacedFeature(ConfiguredFeatures.ORE_SILICON.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(72), VerticalAnchor.absolute(136)))));
    public static final RegistryObject<PlacedFeature> ORE_TUNGSTEN = PLACED_FEATURES.register("ore_tungsten", () -> new PlacedFeature(ConfiguredFeatures.ORE_TUNGSTEN.getHolder().get(), commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(64)))));
    public static final RegistryObject<PlacedFeature> ORE_TUNGSTEN_BURIED = PLACED_FEATURES.register("ore_tungsten_buried", () -> new PlacedFeature(ConfiguredFeatures.ORE_TUNGSTEN_BURIED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(64)))));

    public static final RegistryObject<PlacedFeature> ORE_SALT = PLACED_FEATURES.register("ore_salt", () -> new PlacedFeature(ConfiguredFeatures.ORE_SALT.getHolder().get(), commonOrePlacement(28, HeightRangePlacement.uniform(VerticalAnchor.absolute(46), VerticalAnchor.top()))));

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier range) {
        return List.of(count, InSquarePlacement.spread(), range, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier range) {
        return orePlacement(CountPlacement.of(count), range);
    }
}
