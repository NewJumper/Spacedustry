package com.newjumper.spacedustry.world;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.util.SpacedustryTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeModifiers {
    public static final ResourceKey<BiomeModifier> ALUMINUM_UPPER = createKey("aluminum_upper");
    public static final ResourceKey<BiomeModifier> ALUMINUM_LOWER = createKey("aluminum_lower");
    public static final ResourceKey<BiomeModifier> LITHIUM = createKey("lithium");
    public static final ResourceKey<BiomeModifier> MOLYBDENITE = createKey("molybdenite");
    public static final ResourceKey<BiomeModifier> NICKEL = createKey("nickel");
    public static final ResourceKey<BiomeModifier> SILICON = createKey("silicon");
    public static final ResourceKey<BiomeModifier> TUNGSTEN = createKey("tungsten");
    public static final ResourceKey<BiomeModifier> TUNGSTEN_BURIED = createKey("tungsten_buried");

    public static final ResourceKey<BiomeModifier> SALT = createKey("salt");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(ALUMINUM_UPPER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ALUMINUM_UPPER)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ALUMINUM_LOWER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ALUMINUM_LOWER)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(LITHIUM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.LITHIUM)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(MOLYBDENITE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.MOLYBDENITE)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(NICKEL, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.NICKEL)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(SILICON, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.SILICON)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(TUNGSTEN, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.TUNGSTEN)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(TUNGSTEN_BURIED, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.TUNGSTEN_BURIED)), GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(SALT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(SpacedustryTags.Biomes.IS_SALTY), HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.SALT)), GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    public static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Spacedustry.MOD_ID, name));
    }
}
