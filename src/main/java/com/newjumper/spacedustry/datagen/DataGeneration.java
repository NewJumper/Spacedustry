package com.newjumper.spacedustry.datagen;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.datagen.assets.ENLanguageProvider;
import com.newjumper.spacedustry.datagen.assets.SpacedustryBlockStateProvider;
import com.newjumper.spacedustry.datagen.assets.SpacedustryItemModelProvider;
import com.newjumper.spacedustry.datagen.data.SpacedustryAdvancementProvider;
import com.newjumper.spacedustry.datagen.data.SpacedustryLootTables;
import com.newjumper.spacedustry.datagen.data.recipes.CraftingRecipeProvider;
import com.newjumper.spacedustry.datagen.data.recipes.MachiningRecipeProvider;
import com.newjumper.spacedustry.datagen.data.recipes.SmeltingRecipeProvider;
import com.newjumper.spacedustry.datagen.data.recipes.StonecuttingRecipeProvider;
import com.newjumper.spacedustry.datagen.data.tags.SpacedustryBiomeTagsProvider;
import com.newjumper.spacedustry.datagen.data.tags.SpacedustryBlockTagsProvider;
import com.newjumper.spacedustry.datagen.data.tags.SpacedustryItemTagsProvider;
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
        generator.addProvider(event.includeServer(), new CraftingRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new SmeltingRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new StonecuttingRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new MachiningRecipeProvider(generator));

        SpacedustryBlockTagsProvider blockTags = new SpacedustryBlockTagsProvider(generator, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new SpacedustryItemTagsProvider(generator, blockTags, fileHelper));
        generator.addProvider(event.includeServer(), new SpacedustryBiomeTagsProvider(generator, fileHelper));

        generator.addProvider(event.includeServer(), new SpacedustryAdvancementProvider(generator, fileHelper));
        generator.addProvider(event.includeServer(), new SpacedustryLootTables(generator));
    }
}
