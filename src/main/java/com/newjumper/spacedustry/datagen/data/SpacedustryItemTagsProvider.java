package com.newjumper.spacedustry.datagen.data;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.item.SpacedustryItems;
import com.newjumper.spacedustry.util.SpacedustryTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SpacedustryItemTagsProvider extends ItemTagsProvider {
    public SpacedustryItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTags, ExistingFileHelper exFileHelper) {
        super(gen, blockTags, Spacedustry.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        copy(SpacedustryTags.Blocks.ORES_ALUMINUM, SpacedustryTags.Items.ORES_ALUMINUM);
        copy(SpacedustryTags.Blocks.ORES_LITHIUM, SpacedustryTags.Items.ORES_LITHIUM);
        copy(SpacedustryTags.Blocks.ORES_TUNGSTEN, SpacedustryTags.Items.ORES_TUNGSTEN);

        tag(SpacedustryTags.Items.RAW_ALUMINUM).add(SpacedustryItems.RAW_ALUMINUM.get());
        tag(SpacedustryTags.Items.RAW_LITHIUM).add(SpacedustryItems.RAW_LITHIUM.get());
        tag(SpacedustryTags.Items.RAW_TUNGSTEN).add(SpacedustryItems.RAW_TUNGSTEN.get());

        tag(SpacedustryTags.Items.INGOTS_ALUMINUM).add(SpacedustryItems.ALUMINUM_INGOT.get());
        tag(SpacedustryTags.Items.INGOTS_LITHIUM).add(SpacedustryItems.LITHIUM_INGOT.get());
        tag(SpacedustryTags.Items.INGOTS_TUNGSTEN).add(SpacedustryItems.TUNGSTEN_INGOT.get());
    }
}
