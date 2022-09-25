package com.newjumper.spacedustry.datagen.data.tags;

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
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(SpacedustryBlocks.CONSTRUCTOR.get(), SpacedustryBlocks.GAS_CONDENSER.get(), SpacedustryBlocks.MANUFACTURER.get(), SpacedustryBlocks.ROCKET_ASSEMBLER.get())
                .addTags(SpacedustryTags.Blocks.ORES_ALUMINUM, SpacedustryTags.Blocks.ORES_LITHIUM, SpacedustryTags.Blocks.ORES_MOLYBDENUM, SpacedustryTags.Blocks.ORES_NICKEL, SpacedustryTags.Blocks.ORES_SILICON, SpacedustryTags.Blocks.ORES_TUNGSTEN,
                        SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_ALUMINUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_LITHIUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_MOLYBDENUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_NICKEL, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_SILICON, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_TUNGSTEN,
                        SpacedustryTags.Blocks.STORAGE_BLOCKS_ALUMINUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_LITHIUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_MOLYBDENUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_NICKEL, SpacedustryTags.Blocks.STORAGE_BLOCKS_SILICON, SpacedustryTags.Blocks.STORAGE_BLOCKS_TUNGSTEN);
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(SpacedustryBlocks.SALT_BLOCK.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(SpacedustryBlocks.CONSTRUCTOR.get(), SpacedustryBlocks.GAS_CONDENSER.get()).addTags(SpacedustryTags.Blocks.ORES_ALUMINUM, SpacedustryTags.Blocks.ORES_SILICON, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_ALUMINUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_ALUMINUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_SILICON, SpacedustryTags.Blocks.STORAGE_BLOCKS_SILICON);
        tag(BlockTags.NEEDS_IRON_TOOL).add(SpacedustryBlocks.MANUFACTURER.get(), SpacedustryBlocks.ROCKET_ASSEMBLER.get()).addTags(SpacedustryTags.Blocks.ORES_LITHIUM, SpacedustryTags.Blocks.ORES_MOLYBDENUM, SpacedustryTags.Blocks.ORES_NICKEL, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_LITHIUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_LITHIUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_MOLYBDENUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_MOLYBDENUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_NICKEL, SpacedustryTags.Blocks.STORAGE_BLOCKS_NICKEL);
        tag(BlockTags.NEEDS_DIAMOND_TOOL).addTags(SpacedustryTags.Blocks.ORES_TUNGSTEN, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_TUNGSTEN, SpacedustryTags.Blocks.STORAGE_BLOCKS_TUNGSTEN);

        tag(Tags.Blocks.ORES).addTags(SpacedustryTags.Blocks.ORES_ALUMINUM, SpacedustryTags.Blocks.ORES_LITHIUM, SpacedustryTags.Blocks.ORES_MOLYBDENUM, SpacedustryTags.Blocks.ORES_NICKEL, SpacedustryTags.Blocks.ORES_SILICON, SpacedustryTags.Blocks.ORES_TUNGSTEN);
        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(SpacedustryBlocks.ALUMINUM_ORE.get(), SpacedustryBlocks.LITHIUM_ORE.get(), SpacedustryBlocks.MOLYBDENITE_ORE.get(), SpacedustryBlocks.NICKEL_ORE.get(), SpacedustryBlocks.SILICON_ORE.get(), SpacedustryBlocks.TUNGSTEN_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get(), SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get(), SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTags(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_ALUMINUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_LITHIUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_MOLYBDENUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_NICKEL, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_SILICON, SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_TUNGSTEN,
                SpacedustryTags.Blocks.STORAGE_BLOCKS_ALUMINUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_LITHIUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_MOLYBDENUM, SpacedustryTags.Blocks.STORAGE_BLOCKS_NICKEL, SpacedustryTags.Blocks.STORAGE_BLOCKS_SILICON, SpacedustryTags.Blocks.STORAGE_BLOCKS_TUNGSTEN);

        tag(SpacedustryTags.Blocks.ORES_ALUMINUM).add(SpacedustryBlocks.ALUMINUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        tag(SpacedustryTags.Blocks.ORES_LITHIUM).add(SpacedustryBlocks.LITHIUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get());
        tag(SpacedustryTags.Blocks.ORES_MOLYBDENUM).add(SpacedustryBlocks.MOLYBDENITE_ORE.get(), SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get());
        tag(SpacedustryTags.Blocks.ORES_NICKEL).add(SpacedustryBlocks.NICKEL_ORE.get(), SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get());
        tag(SpacedustryTags.Blocks.ORES_SILICON).add(SpacedustryBlocks.SILICON_ORE.get());
        tag(SpacedustryTags.Blocks.ORES_TUNGSTEN).add(SpacedustryBlocks.TUNGSTEN_ORE.get(), SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_ALUMINUM).add(SpacedustryBlocks.RAW_ALUMINUM_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_LITHIUM).add(SpacedustryBlocks.RAW_LITHIUM_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_MOLYBDENUM).add(SpacedustryBlocks.RAW_MOLYBDENITE_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_NICKEL).add(SpacedustryBlocks.RAW_NICKEL_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_SILICON).add(SpacedustryBlocks.RAW_SILICON_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_TUNGSTEN).add(SpacedustryBlocks.RAW_TUNGSTEN_BLOCK.get());

        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_ALUMINUM).add(SpacedustryBlocks.ALUMINUM_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_LITHIUM).add(SpacedustryBlocks.LITHIUM_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_MOLYBDENUM).add(SpacedustryBlocks.MOLYBDENUM_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_NICKEL).add(SpacedustryBlocks.NICKEL_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_SILICON).add(SpacedustryBlocks.SILICON_BLOCK.get());
        tag(SpacedustryTags.Blocks.STORAGE_BLOCKS_TUNGSTEN).add(SpacedustryBlocks.TUNGSTEN_BLOCK.get());
    }
}
