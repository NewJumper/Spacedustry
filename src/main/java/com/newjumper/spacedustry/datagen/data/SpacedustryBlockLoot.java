package com.newjumper.spacedustry.datagen.data;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class SpacedustryBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
        this.add(SpacedustryBlocks.ALUMINUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_ALUMINUM.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_ALUMINUM.get()));
        this.add(SpacedustryBlocks.LITHIUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_LITHIUM.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_LITHIUM.get()));
        this.add(SpacedustryBlocks.MOLYBDENITE_ORE.get(), block -> createOreDrop(block, SpacedustryItems.MOLYBDENITE.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get(), block -> createOreDrop(block, SpacedustryItems.MOLYBDENITE.get()));
        this.add(SpacedustryBlocks.NICKEL_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_NICKEL.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_NICKEL.get()));
        this.add(SpacedustryBlocks.SILICON_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_SILICON.get()));
        this.add(SpacedustryBlocks.TUNGSTEN_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_TUNGSTEN.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_TUNGSTEN.get()));

        this.add(SpacedustryBlocks.SALT_BLOCK.get(), block -> createSingleItemTableWithSilkTouch(block, SpacedustryItems.SALT.get(), ConstantValue.exactly(4)));
    }

    @NotNull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SpacedustryBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
