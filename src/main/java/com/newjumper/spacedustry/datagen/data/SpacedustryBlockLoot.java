package com.newjumper.spacedustry.datagen.data;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class SpacedustryBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(SpacedustryBlocks.ALUMINUM_ORE.get());
        this.dropSelf(SpacedustryBlocks.LITHIUM_ORE.get());
        this.dropSelf(SpacedustryBlocks.TUNGSTEN_ORE.get());
    }

    @NotNull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SpacedustryBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
