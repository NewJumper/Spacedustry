package com.newjumper.spacedustry.world;

import com.google.common.base.Suppliers;
import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

import static net.minecraft.data.worldgen.features.OreFeatures.STONE_ORE_REPLACEABLES;

public class ConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Spacedustry.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> ALUMINUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, SpacedustryBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> LITHIUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, SpacedustryBlocks.LITHIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> MOLYBDENITE_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, SpacedustryBlocks.MOLYBDENITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NICKEL_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, SpacedustryBlocks.NICKEL_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> SILICON_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, SpacedustryBlocks.SILICON_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> TUNGSTEN_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, SpacedustryBlocks.TUNGSTEN_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_ALUMINUM_UPPER = CONFIGURED_FEATURES.register("ore_aluminum_upper", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ALUMINUM_TARGET_LIST.get(), 9, 0.1f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_ALUMINUM_LOWER = CONFIGURED_FEATURES.register("ore_aluminum_lower", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ALUMINUM_TARGET_LIST.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_LITHIUM = CONFIGURED_FEATURES.register("ore_lithium", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LITHIUM_TARGET_LIST.get(), 8, 0.2f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_MOLYBDENITE = CONFIGURED_FEATURES.register("ore_molybdenite", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(MOLYBDENITE_TARGET_LIST.get(), 5, 0.4f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_NICKEL = CONFIGURED_FEATURES.register("ore_nickel", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NICKEL_TARGET_LIST.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SILICON = CONFIGURED_FEATURES.register("ore_silicon", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SILICON_TARGET_LIST.get(), 8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_TUNGSTEN = CONFIGURED_FEATURES.register("ore_tungsten", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TUNGSTEN_TARGET_LIST.get(), 6)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_TUNGSTEN_BURIED = CONFIGURED_FEATURES.register("ore_tungsten_buried", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TUNGSTEN_TARGET_LIST.get(), 7, 0.7f)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SALT = CONFIGURED_FEATURES.register("ore_salt", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(STONE_ORE_REPLACEABLES, SpacedustryBlocks.SALT_BLOCK.get().defaultBlockState(), 24)));
}
