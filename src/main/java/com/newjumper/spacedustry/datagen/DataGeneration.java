package com.newjumper.spacedustry.datagen;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.datagen.assets.ENLanguageProvider;
import com.newjumper.spacedustry.datagen.assets.SpacedustryBlockStateProvider;
import com.newjumper.spacedustry.datagen.assets.SpacedustryItemModelProvider;
import com.newjumper.spacedustry.datagen.data.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Spacedustry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new ENLanguageProvider(generator));
        generator.addProvider(event.includeClient(), new SpacedustryBlockStateProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new SpacedustryItemModelProvider(generator, fileHelper));

        // data
        generator.addProvider(event.includeServer(), new CraftingRecipesProvider(generator));
        generator.addProvider(event.includeServer(), new SmeltingRecipesProvider(generator));
        generator.addProvider(event.includeServer(), new SpacedustryLootTables(generator));
        SpacedustryBlockTagsProvider blockTags = new SpacedustryBlockTagsProvider(generator, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new SpacedustryItemTagsProvider(generator, blockTags, fileHelper));
    }
}
