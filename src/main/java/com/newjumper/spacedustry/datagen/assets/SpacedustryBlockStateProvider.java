package com.newjumper.spacedustry.datagen.assets;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SpacedustryBlockStateProvider extends BlockStateProvider {
    public SpacedustryBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Spacedustry.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(SpacedustryBlocks.ALUMINUM_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        simpleBlock(SpacedustryBlocks.LITHIUM_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get());
        simpleBlock(SpacedustryBlocks.TUNGSTEN_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
    }
}
