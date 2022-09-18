package com.newjumper.spacedustry.util;

import com.newjumper.spacedustry.Spacedustry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class SpacedustryTags {
    public static class Blocks {
        public static final TagKey<Block> ORES_ALUMINUM = forgeTag("ores/aluminum");
        public static final TagKey<Block> ORES_LITHIUM = forgeTag("ores/lithium");
        public static final TagKey<Block> ORES_MOLYBDENUM = forgeTag("ores/molybdenum");
        public static final TagKey<Block> ORES_NICKEL = forgeTag("ores/nickel");
        public static final TagKey<Block> ORES_SILICON = forgeTag("ores/silicon");
        public static final TagKey<Block> ORES_TUNGSTEN = forgeTag("ores/tungsten");

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ORES_ALUMINUM = forgeTag("ores/aluminum");
        public static final TagKey<Item> ORES_LITHIUM = forgeTag("ores/lithium");
        public static final TagKey<Item> ORES_MOLYBDENUM = forgeTag("ores/molybdenum");
        public static final TagKey<Item> ORES_NICKEL = forgeTag("ores/nickel");
        public static final TagKey<Item> ORES_SILICON = forgeTag("ores/silicon");
        public static final TagKey<Item> ORES_TUNGSTEN = forgeTag("ores/tungsten");

        public static final TagKey<Item> RAW_ALUMINUM = forgeTag("raw_materials/aluminum");
        public static final TagKey<Item> RAW_LITHIUM = forgeTag("raw_materials/lithium");
        public static final TagKey<Item> RAW_MOLYBDENUM = forgeTag("raw_materials/molybdenum");
        public static final TagKey<Item> RAW_NICKEL = forgeTag("raw_materials/nickel");
        public static final TagKey<Item> RAW_SILICON = forgeTag("raw_materials/silicon");
        public static final TagKey<Item> RAW_TUNGSTEN = forgeTag("raw_materials/tungsten");

        public static final TagKey<Item> INGOTS_ALUMINUM = forgeTag("ingots/aluminum");
        public static final TagKey<Item> INGOTS_LITHIUM = forgeTag("ingots/lithium");
        public static final TagKey<Item> INGOTS_MOLYBDENUM = forgeTag("ingots/molybdenum");
        public static final TagKey<Item> INGOTS_NICKEL = forgeTag("ingots/nickel");
        public static final TagKey<Item> INGOTS_SILICON = forgeTag("ingots/silicon");
        public static final TagKey<Item> INGOTS_TUNGSTEN = forgeTag("ingots/tungsten");

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> IS_SALTY = tag("is_salty");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Spacedustry.MOD_ID, name));
        }
    }
}
