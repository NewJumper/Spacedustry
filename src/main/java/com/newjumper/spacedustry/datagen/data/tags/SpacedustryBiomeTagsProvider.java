package com.newjumper.spacedustry.datagen.data.tags;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.util.SpacedustryTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SpacedustryBiomeTagsProvider extends BiomeTagsProvider {
    public SpacedustryBiomeTagsProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Spacedustry.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        tag(SpacedustryTags.Biomes.IS_SALTY).add(Biomes.STONY_PEAKS, Biomes.STONY_SHORE);
    }
}
