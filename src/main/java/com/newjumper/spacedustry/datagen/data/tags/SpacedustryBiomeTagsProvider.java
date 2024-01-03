package com.newjumper.spacedustry.datagen.data.tags;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.util.SpacedustryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SpacedustryBiomeTagsProvider extends BiomeTagsProvider {
    public SpacedustryBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, ExistingFileHelper existingFileHelper) {
        super(output, lookup, Spacedustry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(SpacedustryTags.Biomes.IS_SALTY).add(Biomes.STONY_PEAKS, Biomes.STONY_SHORE);
    }
}
