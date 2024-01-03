package com.newjumper.spacedustry.datagen.data;

import com.newjumper.spacedustry.content.SpacedustryBlocks;
import com.newjumper.spacedustry.content.SpacedustryItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpacedustryBlockLoot extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.PIGLIN_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(Collectors.toSet());

    protected SpacedustryBlockLoot() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(SpacedustryBlocks.DEBRIS_ROCKS.get());
        this.dropSelf(SpacedustryBlocks.SPACE_STONE.get());

        this.add(SpacedustryBlocks.MOON_STONE.get(), block -> createSingleItemTableWithSilkTouch(block, SpacedustryBlocks.COBBLED_MOON_STONE.get()));
        this.dropSelf(SpacedustryBlocks.COBBLED_MOON_STONE.get());
        this.dropSelf(SpacedustryBlocks.MOON_STONE_BRICKS.get());
        this.dropSelf(SpacedustryBlocks.GLAZED_ROCK.get());

        this.add(SpacedustryBlocks.ALUMINUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_ALUMINUM.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_ALUMINUM.get()));
        this.dropSelf(SpacedustryBlocks.RAW_ALUMINUM_BLOCK.get());
        this.dropSelf(SpacedustryBlocks.ALUMINUM_BLOCK.get());
        this.add(SpacedustryBlocks.LITHIUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_LITHIUM.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_LITHIUM.get()));
        this.dropSelf(SpacedustryBlocks.RAW_LITHIUM_BLOCK.get());
        this.dropSelf(SpacedustryBlocks.LITHIUM_BLOCK.get());
        this.add(SpacedustryBlocks.MOLYBDENITE_ORE.get(), block -> createOreDrop(block, SpacedustryItems.MOLYBDENITE.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get(), block -> createOreDrop(block, SpacedustryItems.MOLYBDENITE.get()));
        this.dropSelf(SpacedustryBlocks.RAW_MOLYBDENITE_BLOCK.get());
        this.dropSelf(SpacedustryBlocks.MOLYBDENUM_BLOCK.get());
        this.add(SpacedustryBlocks.NICKEL_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_NICKEL.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_NICKEL.get()));
        this.dropSelf(SpacedustryBlocks.RAW_NICKEL_BLOCK.get());
        this.dropSelf(SpacedustryBlocks.NICKEL_BLOCK.get());
        this.add(SpacedustryBlocks.SILICON_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_SILICON.get()));
        this.dropSelf(SpacedustryBlocks.RAW_SILICON_BLOCK.get());
        this.dropSelf(SpacedustryBlocks.SILICON_BLOCK.get());
        this.add(SpacedustryBlocks.TUNGSTEN_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_TUNGSTEN.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_TUNGSTEN.get()));
        this.dropSelf(SpacedustryBlocks.RAW_TUNGSTEN_BLOCK.get());
        this.dropSelf(SpacedustryBlocks.TUNGSTEN_BLOCK.get());

        this.add(SpacedustryBlocks.SALT_BLOCK.get(), block -> createSingleItemTableWithSilkTouch(block, SpacedustryItems.SALT.get(), ConstantValue.exactly(4)));

        this.dropSelf(SpacedustryBlocks.CONSTRUCTOR.get());
        this.dropSelf(SpacedustryBlocks.GAS_CONDENSER.get());
        this.dropSelf(SpacedustryBlocks.MANUFACTURER.get());
        this.dropSelf(SpacedustryBlocks.ROCKET_ASSEMBLER.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return SpacedustryBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
