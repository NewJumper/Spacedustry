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

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTags(SpacedustryTags.Blocks.ORES_ALUMINUM, SpacedustryTags.Blocks.ORES_LITHIUM, SpacedustryTags.Blocks.ORES_TUNGSTEN);
        tag(BlockTags.NEEDS_STONE_TOOL).addTag(SpacedustryTags.Blocks.ORES_ALUMINUM);
        tag(BlockTags.NEEDS_IRON_TOOL).addTag(SpacedustryTags.Blocks.ORES_LITHIUM);
        tag(BlockTags.NEEDS_DIAMOND_TOOL).addTag(SpacedustryTags.Blocks.ORES_TUNGSTEN);

        tag(Tags.Blocks.ORES).addTags(SpacedustryTags.Blocks.ORES_ALUMINUM, SpacedustryTags.Blocks.ORES_LITHIUM, SpacedustryTags.Blocks.ORES_TUNGSTEN);
        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(SpacedustryBlocks.ALUMINUM_ORE.get(), SpacedustryBlocks.LITHIUM_ORE.get(), SpacedustryBlocks.TUNGSTEN_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

        tag(SpacedustryTags.Blocks.ORES_ALUMINUM).add(SpacedustryBlocks.ALUMINUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        tag(SpacedustryTags.Blocks.ORES_LITHIUM).add(SpacedustryBlocks.LITHIUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get());
        tag(SpacedustryTags.Blocks.ORES_TUNGSTEN).add(SpacedustryBlocks.TUNGSTEN_ORE.get(), SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
    }
}
