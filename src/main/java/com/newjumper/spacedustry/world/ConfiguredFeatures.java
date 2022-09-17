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

public class ConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Spacedustry.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> ALUMINUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, SpacedustryBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> LITHIUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, SpacedustryBlocks.LITHIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> TUNGSTEN_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, SpacedustryBlocks.TUNGSTEN_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_ALUMINUM = CONFIGURED_FEATURES.register("ore_aluminum", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ALUMINUM_TARGET_LIST.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_LITHIUM = CONFIGURED_FEATURES.register("ore_lithium", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LITHIUM_TARGET_LIST.get(), 8, 0.2f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_TUNGSTEN = CONFIGURED_FEATURES.register("ore_tungsten", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TUNGSTEN_TARGET_LIST.get(), 6)));
}
