package com.newjumper.spacedustry;

import com.newjumper.spacedustry.capabilities.IGasStorage;
import com.newjumper.spacedustry.content.SpacedustryBlocks;
import com.newjumper.spacedustry.content.SpacedustryItems;
import com.newjumper.spacedustry.content.SpacedustryMenuTypes;
import com.newjumper.spacedustry.content.block.entity.SpacedustryBlockEntities;
import com.newjumper.spacedustry.content.screen.ConstructorScreen;
import com.newjumper.spacedustry.content.screen.GasCondenserScreen;
import com.newjumper.spacedustry.content.screen.ManufacturerScreen;
import com.newjumper.spacedustry.datagen.assets.ENLanguageProvider;
import com.newjumper.spacedustry.datagen.assets.SpacedustryBlockStateProvider;
import com.newjumper.spacedustry.datagen.assets.SpacedustryItemModelProvider;
import com.newjumper.spacedustry.datagen.data.SpacedustryAdvancements;
import com.newjumper.spacedustry.datagen.data.SpacedustryLootTables;
import com.newjumper.spacedustry.datagen.data.SpacedustryRecipeProvider;
import com.newjumper.spacedustry.datagen.data.SpacedustryRegistriesGenerator;
import com.newjumper.spacedustry.datagen.data.tags.SpacedustryBiomeTagsProvider;
import com.newjumper.spacedustry.datagen.data.tags.SpacedustryBlockTagsProvider;
import com.newjumper.spacedustry.datagen.data.tags.SpacedustryItemTagsProvider;
import com.newjumper.spacedustry.recipe.ConstructingRecipe;
import com.newjumper.spacedustry.recipe.ManufacturingRecipe;
import com.newjumper.spacedustry.recipe.SpacedustryRecipes;
import com.newjumper.spacedustry.util.SpacedustryCreativeTab;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.List;

@SuppressWarnings("unused")
@Mod(Spacedustry.MOD_ID)
public class Spacedustry {
    public static final String MOD_ID = "spacedustry";

    public Spacedustry() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SpacedustryCreativeTab.CREATIVE_TABS.register(eventBus);
        SpacedustryBlocks.BLOCKS.register(eventBus);
        SpacedustryItems.ITEMS.register(eventBus);
        SpacedustryBlockEntities.BLOCK_ENTITIES.register(eventBus);
        SpacedustryMenuTypes.MENUS.register(eventBus);
        SpacedustryRecipes.RECIPE_SERIALIZERS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(SpacedustryCreativeTab::buildCreativeTab);
        eventBus.addListener(this::generateData);
        eventBus.addListener(this::registerCapabilities);
        eventBus.addListener(this::registerRecipeTypes);
    }

    public void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new SpacedustryBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new SpacedustryItemModelProvider(packOutput, fileHelper));

        // data
        SpacedustryBlockTagsProvider blockTags = new SpacedustryBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new SpacedustryItemTagsProvider(packOutput, event.getLookupProvider(), blockTags, fileHelper));
        generator.addProvider(event.includeServer(), new SpacedustryBiomeTagsProvider(packOutput, event.getLookupProvider(), fileHelper));

        generator.addProvider(event.includeServer(), new ForgeAdvancementProvider(packOutput, event.getLookupProvider(), fileHelper, List.of(new SpacedustryAdvancements())));
        generator.addProvider(event.includeServer(), new SpacedustryRegistriesGenerator(packOutput, event.getLookupProvider()));
        generator.addProvider(event.includeServer(), new SpacedustryLootTables(packOutput));
        generator.addProvider(event.includeServer(), new SpacedustryRecipeProvider(packOutput));
    }

    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(IGasStorage.class);
    }

    public void registerRecipeTypes(final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(MOD_ID, "constructing"), ConstructingRecipe.Type.INSTANCE);
            helper.register(new ResourceLocation(MOD_ID, "manufacturing"), ManufacturingRecipe.Type.INSTANCE);
        });
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class SpacedustryClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            MenuScreens.register(SpacedustryMenuTypes.CONSTRUCTOR_MENU.get(), ConstructorScreen::new);
            MenuScreens.register(SpacedustryMenuTypes.GAS_CONDENSER_MENU.get(), GasCondenserScreen::new);
            MenuScreens.register(SpacedustryMenuTypes.MANUFACTURER_MENU.get(), ManufacturerScreen::new);
        }
    }
}
