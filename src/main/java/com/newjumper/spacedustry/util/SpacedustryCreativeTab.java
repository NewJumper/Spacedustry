package com.newjumper.spacedustry.util;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.SpacedustryBlocks;
import com.newjumper.spacedustry.content.SpacedustryItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SpacedustryCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Spacedustry.MOD_ID);
    public static final RegistryObject<CreativeModeTab> SPACEDUSTRY = CREATIVE_TABS.register(Spacedustry.MOD_ID, () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + Spacedustry.MOD_ID)).icon(() -> new ItemStack(SpacedustryBlocks.LITHIUM_ORE.get())).build());

    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == SPACEDUSTRY.get()) {
            SpacedustryBlocks.BLOCKS.getEntries().forEach(event::accept);
            SpacedustryItems.ITEMS.getEntries().forEach(event::accept);
        }
    }
}
