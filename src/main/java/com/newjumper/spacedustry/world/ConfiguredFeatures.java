package com.newjumper.spacedustry.world;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.SpacedustryBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ConfiguredFeatures {
    public static final RuleTest STONE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ALUMINUM_UPPER = createKey("ore_aluminum_upper");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ALUMINUM_LOWER = createKey("ore_aluminum_lower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LITHIUM = createKey("ore_lithium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MOLYBDENITE = createKey("ore_molybdenite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NICKEL = createKey("ore_nickel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SILICON = createKey("ore_silicon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TUNGSTEN = createKey("ore_tungsten");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TUNGSTEN_BURIED = createKey("ore_tungsten_buried");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SALT = createKey("ore_salt");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        List<OreConfiguration.TargetBlockState> ALUMINUM_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, SpacedustryBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> LITHIUM_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, SpacedustryBlocks.LITHIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> MOLYBDENITE_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, SpacedustryBlocks.MOLYBDENITE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> NICKEL_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, SpacedustryBlocks.NICKEL_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> SILICON_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, SpacedustryBlocks.SILICON_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> TUNGSTEN_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, SpacedustryBlocks.TUNGSTEN_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState()));

        FeatureUtils.register(context, ORE_ALUMINUM_UPPER, Feature.ORE, new OreConfiguration(ALUMINUM_TARGET_LIST, 9, 0.1f));
        FeatureUtils.register(context, ORE_ALUMINUM_LOWER, Feature.ORE, new OreConfiguration(ALUMINUM_TARGET_LIST, 9));
        FeatureUtils.register(context, ORE_LITHIUM, Feature.ORE, new OreConfiguration(LITHIUM_TARGET_LIST, 8, 0.2f));
        FeatureUtils.register(context, ORE_MOLYBDENITE, Feature.ORE, new OreConfiguration(MOLYBDENITE_TARGET_LIST, 5, 0.4f));
        FeatureUtils.register(context, ORE_NICKEL, Feature.ORE, new OreConfiguration(NICKEL_TARGET_LIST, 9));
        FeatureUtils.register(context, ORE_SILICON, Feature.ORE, new OreConfiguration(SILICON_TARGET_LIST, 8));
        FeatureUtils.register(context, ORE_TUNGSTEN, Feature.ORE, new OreConfiguration(TUNGSTEN_TARGET_LIST, 6));
        FeatureUtils.register(context, ORE_TUNGSTEN_BURIED, Feature.ORE, new OreConfiguration(TUNGSTEN_TARGET_LIST, 7, 0.7f));

        FeatureUtils.register(context, ORE_SALT, Feature.ORE, new OreConfiguration(STONE_REPLACEABLES, SpacedustryBlocks.SALT_BLOCK.get().defaultBlockState(), 24));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Spacedustry.MOD_ID, name));
    }
}
