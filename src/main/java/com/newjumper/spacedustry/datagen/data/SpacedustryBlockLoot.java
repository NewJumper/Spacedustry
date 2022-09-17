package com.newjumper.spacedustry.datagen.data;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class SpacedustryBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
        this.add(SpacedustryBlocks.ALUMINUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_ALUMINUM.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_ALUMINUM.get()));
        this.add(SpacedustryBlocks.LITHIUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_LITHIUM.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_LITHIUM.get()));
        this.add(SpacedustryBlocks.TUNGSTEN_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_TUNGSTEN.get()));
        this.add(SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), block -> createOreDrop(block, SpacedustryItems.RAW_TUNGSTEN.get()));
    }

    @NotNull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SpacedustryBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
