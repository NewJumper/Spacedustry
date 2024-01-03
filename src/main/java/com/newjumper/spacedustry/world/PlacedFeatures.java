package com.newjumper.spacedustry.world;

import com.newjumper.spacedustry.Spacedustry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PlacedFeatures {
    public static final ResourceKey<PlacedFeature> ORE_ALUMINUM_UPPER = createKey("ore_aluminum_upper");
    public static final ResourceKey<PlacedFeature> ORE_ALUMINUM_LOWER = createKey("ore_aluminum_lower");
    public static final ResourceKey<PlacedFeature> ORE_LITHIUM = createKey("ore_lithium");
    public static final ResourceKey<PlacedFeature> ORE_MOLYBDENITE = createKey("ore_molybdenite");
    public static final ResourceKey<PlacedFeature> ORE_NICKEL = createKey("ore_nickel");
    public static final ResourceKey<PlacedFeature> ORE_SILICON = createKey("ore_silicon");
    public static final ResourceKey<PlacedFeature> ORE_TUNGSTEN = createKey("ore_tungsten");
    public static final ResourceKey<PlacedFeature> ORE_TUNGSTEN_BURIED = createKey("ore_tungsten_buried");

    public static final ResourceKey<PlacedFeature> ORE_SALT = createKey("ore_salt");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, ORE_ALUMINUM_UPPER, features.getOrThrow(ConfiguredFeatures.ORE_ALUMINUM_UPPER), countPlacement(14, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(64), VerticalAnchor.aboveBottom(256))));
        PlacementUtils.register(context, ORE_ALUMINUM_LOWER, features.getOrThrow(ConfiguredFeatures.ORE_ALUMINUM_LOWER), countPlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-72), VerticalAnchor.aboveBottom(72))));
        PlacementUtils.register(context, ORE_LITHIUM, features.getOrThrow(ConfiguredFeatures.ORE_LITHIUM), countPlacement(12, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60), VerticalAnchor.aboveBottom(86))));
        PlacementUtils.register(context, ORE_MOLYBDENITE, features.getOrThrow(ConfiguredFeatures.ORE_MOLYBDENITE), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-14), VerticalAnchor.aboveBottom(80))));
        PlacementUtils.register(context, ORE_NICKEL, features.getOrThrow(ConfiguredFeatures.ORE_NICKEL), countPlacement(10, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(40), VerticalAnchor.aboveBottom(124))));
        PlacementUtils.register(context, ORE_SILICON, features.getOrThrow(ConfiguredFeatures.ORE_SILICON), countPlacement(8, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(72), VerticalAnchor.absolute(136))));
        PlacementUtils.register(context, ORE_TUNGSTEN, features.getOrThrow(ConfiguredFeatures.ORE_TUNGSTEN), countPlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(64))));
        PlacementUtils.register(context, ORE_TUNGSTEN_BURIED, features.getOrThrow(ConfiguredFeatures.ORE_TUNGSTEN_BURIED), countPlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(64))));

        PlacementUtils.register(context, ORE_SALT, features.getOrThrow(ConfiguredFeatures.ORE_SALT), countPlacement(28, HeightRangePlacement.uniform(VerticalAnchor.absolute(46), VerticalAnchor.top())));
    }

    private static List<PlacementModifier> countPlacement(int attempts, PlacementModifier heightRange) {
        return List.of(CountPlacement.of(attempts), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Spacedustry.MOD_ID, name));
    }
}
