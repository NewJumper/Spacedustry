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
    public static final RegistryObject<Item> MOLYBDENITE = ITEMS.register("molybdenite", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> RAW_NICKEL = ITEMS.register("raw_nickel", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> RAW_SILICON = ITEMS.register("raw_silicon", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> SILICON = ITEMS.register("silicon", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));

    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> BURLAM_ALLOY = ITEMS.register("burlam_alloy", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> COBALT_ALLOY = ITEMS.register("cobalt_alloy", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> DURALUMIN_ALLOY = ITEMS.register("duralumin_alloy", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> STEEL_ALLOY = ITEMS.register("steel_alloy", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
    public static final RegistryObject<Item> SUPER_ALLOY = ITEMS.register("super_alloy", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));

    public static final RegistryObject<Item> GAS_CONTAINER = ITEMS.register("gas_container", () -> new Item(new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY).stacksTo(1)));
}
