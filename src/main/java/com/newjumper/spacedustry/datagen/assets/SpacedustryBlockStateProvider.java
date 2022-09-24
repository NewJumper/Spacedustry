package com.newjumper.spacedustry.datagen.assets;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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
        simpleBlock(SpacedustryBlocks.MOLYBDENITE_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get());
        simpleBlock(SpacedustryBlocks.NICKEL_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get());
        simpleBlock(SpacedustryBlocks.SILICON_ORE.get());
        simpleBlock(SpacedustryBlocks.TUNGSTEN_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

        simpleBlock(SpacedustryBlocks.SALT_BLOCK.get());

        horizontalBlock(SpacedustryBlocks.CONSTRUCTOR.get(), blockLoc(SpacedustryBlocks.CONSTRUCTOR, "side"), blockLoc(SpacedustryBlocks.CONSTRUCTOR, "front"), blockLoc(SpacedustryBlocks.CONSTRUCTOR, "top"));
        simpleBlock(SpacedustryBlocks.GAS_CONDENSER.get());
        simpleBlock(SpacedustryBlocks.MANUFACTURER.get());
        simpleBlock(SpacedustryBlocks.ROCKET_ASSEMBLER.get());
    }

    private ResourceLocation blockLoc(RegistryObject<Block> block, String suffix) {
        return modLoc("block/" + block.getId().getPath() + "_" + suffix);
    }
}
