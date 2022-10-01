package com.newjumper.spacedustry.block;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.item.SpacedustryItems;
import com.newjumper.spacedustry.util.SpacedustryCreative;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SpacedustryBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Spacedustry.MOD_ID);

    public static final RegistryObject<Block> DEBRIS_ROCKS = register("debris_rocks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f, 15f)));
    public static final RegistryObject<Block> SPACE_STONE = register("space_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f, 60f)));

    public static final RegistryObject<Block> MOON_STONE = register("moon_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f, 4f)));
    public static final RegistryObject<Block> COBBLED_MOON_STONE = register("cobbled_moon_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f, 5f)));
    public static final RegistryObject<Block> GLAZED_ROCK = register("glazed_rock", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f, 6)));

    public static final RegistryObject<Block> ALUMINUM_ORE = register("aluminum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_ALUMINUM_ORE = register("deepslate_aluminum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_ALUMINUM_BLOCK = register("raw_aluminum_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_BLOCK = register("aluminum_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LITHIUM_ORE = register("lithium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_LITHIUM_ORE = register("deepslate_lithium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_LITHIUM_BLOCK = register("raw_lithium_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LITHIUM_BLOCK = register("lithium_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOLYBDENITE_ORE = register("molybdenite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f, 3.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_MOLYBDENITE_ORE = register("deepslate_molybdenite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5.5f, 3.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_MOLYBDENITE_BLOCK = register("raw_molybdenite_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5.5f, 7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOLYBDENUM_BLOCK = register("molybdenum_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5.5f, 7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_ORE = register("nickel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_NICKEL_ORE = register("deepslate_nickel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_NICKEL_BLOCK = register("raw_nickel_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_BLOCK = register("nickel_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SILICON_ORE = register("silicon_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_SILICON_BLOCK = register("raw_silicon_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SILICON_BLOCK = register("silicon_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TUNGSTEN_ORE = register("tungsten_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = register("deepslate_tungsten_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5.5f, 5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK = register("raw_tungsten_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f, 8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = register("tungsten_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f, 13f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SALT_BLOCK = register("salt_block", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6f).sound(SoundType.GRAVEL)));

    public static final RegistryObject<Block> CONSTRUCTOR = register("constructor", () -> new ConstructorBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(3.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GAS_CONDENSER = register("gas_condenser", () -> new GasCondenserBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(3.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MANUFACTURER = register("manufacturer", () -> new ManufacturerBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ROCKET_ASSEMBLER = register("rocket_assembler", () -> new RocketAssemblerBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(4f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> pBlock) {
        RegistryObject<T> block = BLOCKS.register(name, pBlock);
        SpacedustryItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
        return block;
    }
}
