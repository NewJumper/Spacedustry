package com.newjumper.spacedustry;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import com.newjumper.spacedustry.world.ConfiguredFeatures;
import com.newjumper.spacedustry.world.PlacedFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Spacedustry.MOD_ID)
public class Spacedustry {
    public static final String MOD_ID = "spacedustry";

    public Spacedustry() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SpacedustryBlocks.BLOCKS.register(eventBus);
        ConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        PlacedFeatures.PLACED_FEATURES.register(eventBus);
        SpacedustryItems.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
