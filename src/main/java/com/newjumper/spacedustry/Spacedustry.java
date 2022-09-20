package com.newjumper.spacedustry;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.block.entity.SpacedustryBlockEntities;
import com.newjumper.spacedustry.item.SpacedustryItems;
import com.newjumper.spacedustry.recipe.ConstructingRecipe;
import com.newjumper.spacedustry.recipe.SpacedustryRecipes;
import com.newjumper.spacedustry.screen.ConstructorScreen;
import com.newjumper.spacedustry.screen.SpacedustryMenuTypes;
import com.newjumper.spacedustry.world.ConfiguredFeatures;
import com.newjumper.spacedustry.world.PlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Spacedustry.MOD_ID)
public class Spacedustry {
    public static final String MOD_ID = "spacedustry";

    public Spacedustry() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SpacedustryBlocks.BLOCKS.register(eventBus);
        ConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        PlacedFeatures.PLACED_FEATURES.register(eventBus);
        SpacedustryItems.ITEMS.register(eventBus);
        SpacedustryBlockEntities.BLOCK_ENTITIES.register(eventBus);
        SpacedustryMenuTypes.MENUS.register(eventBus);
        SpacedustryRecipes.RECIPE_SERIALIZERS.register(eventBus);

        eventBus.addListener(this::registerRecipeTypes);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void registerRecipeTypes(final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(MOD_ID, "constructing"), ConstructingRecipe.Type.INSTANCE);
        });
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class SpacedustryClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            MenuScreens.register(SpacedustryMenuTypes.CONSTRUCTOR_MENU.get(), ConstructorScreen::new);
        }
    }
}
