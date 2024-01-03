package com.newjumper.spacedustry.datagen.data.tags;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.SpacedustryItems;
import com.newjumper.spacedustry.util.SpacedustryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SpacedustryItemTagsProvider extends ItemTagsProvider {
    public SpacedustryItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, TagsProvider<Block> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookup, blockTags.contentsGetter(), Spacedustry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
        copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        copy(SpacedustryTags.Blocks.ORES_ALUMINUM, SpacedustryTags.Items.ORES_ALUMINUM);
        copy(SpacedustryTags.Blocks.ORES_LITHIUM, SpacedustryTags.Items.ORES_LITHIUM);
        copy(SpacedustryTags.Blocks.ORES_MOLYBDENUM, SpacedustryTags.Items.ORES_MOLYBDENUM);
        copy(SpacedustryTags.Blocks.ORES_NICKEL, SpacedustryTags.Items.ORES_NICKEL);
        copy(SpacedustryTags.Blocks.ORES_SILICON, SpacedustryTags.Items.ORES_SILICON);
        copy(SpacedustryTags.Blocks.ORES_TUNGSTEN, SpacedustryTags.Items.ORES_TUNGSTEN);

        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_ALUMINUM, SpacedustryTags.Items.STORAGE_BLOCKS_RAW_ALUMINUM);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_LITHIUM, SpacedustryTags.Items.STORAGE_BLOCKS_RAW_LITHIUM);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_MOLYBDENUM, SpacedustryTags.Items.STORAGE_BLOCKS_RAW_MOLYBDENUM);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_NICKEL, SpacedustryTags.Items.STORAGE_BLOCKS_RAW_NICKEL);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_SILICON, SpacedustryTags.Items.STORAGE_BLOCKS_RAW_SILICON);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_RAW_TUNGSTEN, SpacedustryTags.Items.STORAGE_BLOCKS_RAW_TUNGSTEN);

        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_ALUMINUM, SpacedustryTags.Items.STORAGE_BLOCKS_ALUMINUM);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_LITHIUM, SpacedustryTags.Items.STORAGE_BLOCKS_LITHIUM);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_MOLYBDENUM, SpacedustryTags.Items.STORAGE_BLOCKS_MOLYBDENUM);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_NICKEL, SpacedustryTags.Items.STORAGE_BLOCKS_NICKEL);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_SILICON, SpacedustryTags.Items.STORAGE_BLOCKS_SILICON);
        copy(SpacedustryTags.Blocks.STORAGE_BLOCKS_TUNGSTEN, SpacedustryTags.Items.STORAGE_BLOCKS_TUNGSTEN);

        tag(Tags.Items.INGOTS).add(SpacedustryItems.ALUMINUM_INGOT.get(), SpacedustryItems.LITHIUM_INGOT.get(), SpacedustryItems.MOLYBDENUM_INGOT.get(), SpacedustryItems.NICKEL_INGOT.get(), SpacedustryItems.SILICON.get(), SpacedustryItems.TUNGSTEN_INGOT.get());
        tag(Tags.Items.RAW_MATERIALS).add(SpacedustryItems.RAW_ALUMINUM.get(), SpacedustryItems.RAW_LITHIUM.get(), SpacedustryItems.MOLYBDENITE.get(), SpacedustryItems.RAW_NICKEL.get(), SpacedustryItems.RAW_SILICON.get(), SpacedustryItems.RAW_TUNGSTEN.get());

        tag(SpacedustryTags.Items.RAW_ALUMINUM).add(SpacedustryItems.RAW_ALUMINUM.get());
        tag(SpacedustryTags.Items.RAW_LITHIUM).add(SpacedustryItems.RAW_LITHIUM.get());
        tag(SpacedustryTags.Items.RAW_MOLYBDENUM).add(SpacedustryItems.MOLYBDENITE.get());
        tag(SpacedustryTags.Items.RAW_NICKEL).add(SpacedustryItems.RAW_NICKEL.get());
        tag(SpacedustryTags.Items.RAW_SILICON).add(SpacedustryItems.RAW_SILICON.get());
        tag(SpacedustryTags.Items.RAW_TUNGSTEN).add(SpacedustryItems.RAW_TUNGSTEN.get());

        tag(SpacedustryTags.Items.INGOTS_ALUMINUM).add(SpacedustryItems.ALUMINUM_INGOT.get());
        tag(SpacedustryTags.Items.INGOTS_LITHIUM).add(SpacedustryItems.LITHIUM_INGOT.get());
        tag(SpacedustryTags.Items.INGOTS_MOLYBDENUM).add(SpacedustryItems.MOLYBDENUM_INGOT.get());
        tag(SpacedustryTags.Items.INGOTS_NICKEL).add(SpacedustryItems.NICKEL_INGOT.get());
        tag(SpacedustryTags.Items.INGOTS_SILICON).add(SpacedustryItems.SILICON.get());
        tag(SpacedustryTags.Items.INGOTS_TUNGSTEN).add(SpacedustryItems.TUNGSTEN_INGOT.get());

        tag(SpacedustryTags.Items.INGOTS_COBALT).add(SpacedustryItems.COBALT_ALLOY.get());
        tag(SpacedustryTags.Items.INGOTS_STEEL).add(SpacedustryItems.STEEL_ALLOY.get());
    }
}
