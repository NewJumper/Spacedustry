package com.newjumper.spacedustry.util;

import com.newjumper.spacedustry.Spacedustry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class SpacedustryTags {
    public static class Blocks {
        public static final TagKey<Block> ORES_ALUMINUM = tag("ores/aluminum");
        public static final TagKey<Block> ORES_LITHIUM = tag("ores/lithium");
        public static final TagKey<Block> ORES_MOLYBDENUM = tag("ores/molybdenum");
        public static final TagKey<Block> ORES_NICKEL = tag("ores/nickel");
        public static final TagKey<Block> ORES_SILICON = tag("ores/silicon");
        public static final TagKey<Block> ORES_TUNGSTEN = tag("ores/tungsten");

        public static final TagKey<Block> STORAGE_BLOCKS_RAW_ALUMINUM = tag("storage_blocks/raw_aluminum");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_LITHIUM = tag("storage_blocks/raw_lithium");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_MOLYBDENUM = tag("storage_blocks/raw_molybdenum");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_NICKEL = tag("storage_blocks/raw_nickel");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_SILICON = tag("storage_blocks/raw_silicon");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_TUNGSTEN = tag("storage_blocks/raw_tungsten");

        public static final TagKey<Block> STORAGE_BLOCKS_ALUMINUM = tag("storage_blocks/aluminum");
        public static final TagKey<Block> STORAGE_BLOCKS_LITHIUM = tag("storage_blocks/lithium");
        public static final TagKey<Block> STORAGE_BLOCKS_MOLYBDENUM = tag("storage_blocks/molybdenum");
        public static final TagKey<Block> STORAGE_BLOCKS_NICKEL = tag("storage_blocks/nickel");
        public static final TagKey<Block> STORAGE_BLOCKS_SILICON = tag("storage_blocks/silicon");
        public static final TagKey<Block> STORAGE_BLOCKS_TUNGSTEN = tag("storage_blocks/tungsten");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ORES_ALUMINUM = tag("ores/aluminum");
        public static final TagKey<Item> ORES_LITHIUM = tag("ores/lithium");
        public static final TagKey<Item> ORES_MOLYBDENUM = tag("ores/molybdenum");
        public static final TagKey<Item> ORES_NICKEL = tag("ores/nickel");
        public static final TagKey<Item> ORES_SILICON = tag("ores/silicon");
        public static final TagKey<Item> ORES_TUNGSTEN = tag("ores/tungsten");

        public static final TagKey<Item> STORAGE_BLOCKS_RAW_ALUMINUM = tag("storage_blocks/raw_aluminum");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_LITHIUM = tag("storage_blocks/raw_lithium");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_MOLYBDENUM = tag("storage_blocks/raw_molybdenum");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_NICKEL = tag("storage_blocks/raw_nickel");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_SILICON = tag("storage_blocks/raw_silicon");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_TUNGSTEN = tag("storage_blocks/raw_tungsten");

        public static final TagKey<Item> STORAGE_BLOCKS_ALUMINUM = tag("storage_blocks/aluminum");
        public static final TagKey<Item> STORAGE_BLOCKS_LITHIUM = tag("storage_blocks/lithium");
        public static final TagKey<Item> STORAGE_BLOCKS_MOLYBDENUM = tag("storage_blocks/molybdenum");
        public static final TagKey<Item> STORAGE_BLOCKS_NICKEL = tag("storage_blocks/nickel");
        public static final TagKey<Item> STORAGE_BLOCKS_SILICON = tag("storage_blocks/silicon");
        public static final TagKey<Item> STORAGE_BLOCKS_TUNGSTEN = tag("storage_blocks/tungsten");

        public static final TagKey<Item> RAW_ALUMINUM = tag("raw_materials/aluminum");
        public static final TagKey<Item> RAW_LITHIUM = tag("raw_materials/lithium");
        public static final TagKey<Item> RAW_MOLYBDENUM = tag("raw_materials/molybdenum");
        public static final TagKey<Item> RAW_NICKEL = tag("raw_materials/nickel");
        public static final TagKey<Item> RAW_SILICON = tag("raw_materials/silicon");
        public static final TagKey<Item> RAW_TUNGSTEN = tag("raw_materials/tungsten");

        public static final TagKey<Item> INGOTS_ALUMINUM = tag("ingots/aluminum");
        public static final TagKey<Item> INGOTS_LITHIUM = tag("ingots/lithium");
        public static final TagKey<Item> INGOTS_MOLYBDENUM = tag("ingots/molybdenum");
        public static final TagKey<Item> INGOTS_NICKEL = tag("ingots/nickel");
        public static final TagKey<Item> INGOTS_SILICON = tag("ingots/silicon");
        public static final TagKey<Item> INGOTS_TUNGSTEN = tag("ingots/tungsten");

        public static final TagKey<Item> INGOTS_COBALT = tag("ingots/cobalt");
        public static final TagKey<Item> INGOTS_STEEL = tag("ingots/steel");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> IS_SALTY = TagKey.create(ForgeRegistries.Keys.BIOMES, new ResourceLocation(Spacedustry.MOD_ID, "is_salty"));
    }
}
