package com.newjumper.spacedustry.block;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.item.SpacedustryItems;
import com.newjumper.spacedustry.util.SpacedustryCreative;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SpacedustryBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Spacedustry.MOD_ID);

    public static final RegistryObject<Block> ALUMINUM_ORE = register("aluminum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_ALUMINUM_ORE = register("deepslate_aluminum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LITHIUM_ORE = register("lithium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_LITHIUM_ORE = register("deepslate_lithium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TUNGSTEN_ORE = register("tungsten_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f, 3.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = register("deepslate_tungsten_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5.5f, 3.5f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> pBlock) {
        RegistryObject<T> block = BLOCKS.register(name, pBlock);
        SpacedustryItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(SpacedustryCreative.SPACEDUSTRY)));
        return block;
    }
}
