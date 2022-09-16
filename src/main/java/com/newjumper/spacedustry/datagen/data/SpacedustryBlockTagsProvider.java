package com.newjumper.spacedustry.datagen.data;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.util.SpacedustryTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SpacedustryBlockTagsProvider extends BlockTagsProvider {
    public SpacedustryBlockTagsProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Spacedustry.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(SpacedustryBlocks.ALUMINUM_ORE.get(), SpacedustryBlocks.LITHIUM_ORE.get(), SpacedustryBlocks.TUNGSTEN_ORE.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(SpacedustryBlocks.ALUMINUM_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(SpacedustryBlocks.LITHIUM_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(SpacedustryBlocks.TUNGSTEN_ORE.get());

        tag(Tags.Blocks.ORES).add(SpacedustryBlocks.ALUMINUM_ORE.get(), SpacedustryBlocks.LITHIUM_ORE.get(), SpacedustryBlocks.TUNGSTEN_ORE.get());

        tag(SpacedustryTags.Blocks.ORES_ALUMINUM).add(SpacedustryBlocks.ALUMINUM_ORE.get());
        tag(SpacedustryTags.Blocks.ORES_LITHIUM).add(SpacedustryBlocks.LITHIUM_ORE.get());
        tag(SpacedustryTags.Blocks.ORES_TUNGSTEN).add(SpacedustryBlocks.TUNGSTEN_ORE.get());
    }
}
