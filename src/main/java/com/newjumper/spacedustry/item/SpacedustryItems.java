package com.newjumper.spacedustry.item;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.util.SpacedustryCreative;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SpacedustryItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Spacedustry.MOD_ID);

    public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> RAW_LITHIUM = ITEMS.register("raw_lithium", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
}
