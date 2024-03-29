package com.newjumper.spacedustry.datagen.assets;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.SpacedustryBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SpacedustryBlockStateProvider extends BlockStateProvider {
    public SpacedustryBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Spacedustry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(SpacedustryBlocks.DEBRIS_ROCKS.get());
        simpleBlock(SpacedustryBlocks.SPACE_STONE.get());

        simpleBlock(SpacedustryBlocks.MOON_STONE.get());
        simpleBlock(SpacedustryBlocks.COBBLED_MOON_STONE.get());
        simpleBlock(SpacedustryBlocks.MOON_STONE_BRICKS.get());
        simpleBlock(SpacedustryBlocks.GLAZED_ROCK.get());

        simpleBlock(SpacedustryBlocks.ALUMINUM_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        simpleBlock(SpacedustryBlocks.RAW_ALUMINUM_BLOCK.get());
        simpleBlock(SpacedustryBlocks.ALUMINUM_BLOCK.get());
        simpleBlock(SpacedustryBlocks.LITHIUM_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get());
        simpleBlock(SpacedustryBlocks.RAW_LITHIUM_BLOCK.get());
        simpleBlock(SpacedustryBlocks.LITHIUM_BLOCK.get());
        simpleBlock(SpacedustryBlocks.MOLYBDENITE_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get());
        simpleBlock(SpacedustryBlocks.RAW_MOLYBDENITE_BLOCK.get());
        simpleBlock(SpacedustryBlocks.MOLYBDENUM_BLOCK.get());
        simpleBlock(SpacedustryBlocks.NICKEL_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get());
        simpleBlock(SpacedustryBlocks.RAW_NICKEL_BLOCK.get());
        simpleBlock(SpacedustryBlocks.NICKEL_BLOCK.get());
        simpleBlock(SpacedustryBlocks.SILICON_ORE.get());
        simpleBlock(SpacedustryBlocks.RAW_SILICON_BLOCK.get());
        simpleBlock(SpacedustryBlocks.SILICON_BLOCK.get());
        simpleBlock(SpacedustryBlocks.TUNGSTEN_ORE.get());
        simpleBlock(SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
        simpleBlock(SpacedustryBlocks.RAW_TUNGSTEN_BLOCK.get());
        simpleBlock(SpacedustryBlocks.TUNGSTEN_BLOCK.get());

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
