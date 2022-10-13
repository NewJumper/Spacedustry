package com.newjumper.spacedustry.datagen.assets;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SpacedustryItemModelProvider extends ItemModelProvider {
    private final ModelFile GENERATED = getExistingFile(mcLoc("item/generated"));

    public SpacedustryItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Spacedustry.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        blockModel(SpacedustryBlocks.DEBRIS_ROCKS);
        blockModel(SpacedustryBlocks.SPACE_STONE);

        blockModel(SpacedustryBlocks.MOON_STONE);
        blockModel(SpacedustryBlocks.COBBLED_MOON_STONE);
        blockModel(SpacedustryBlocks.MOON_STONE_BRICKS);
        blockModel(SpacedustryBlocks.GLAZED_ROCK);

        blockModel(SpacedustryBlocks.ALUMINUM_ORE);
        blockModel(SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE);
        blockModel(SpacedustryBlocks.RAW_ALUMINUM_BLOCK);
        blockModel(SpacedustryBlocks.ALUMINUM_BLOCK);
        blockModel(SpacedustryBlocks.LITHIUM_ORE);
        blockModel(SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE);
        blockModel(SpacedustryBlocks.RAW_LITHIUM_BLOCK);
        blockModel(SpacedustryBlocks.LITHIUM_BLOCK);
        blockModel(SpacedustryBlocks.MOLYBDENITE_ORE);
        blockModel(SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE);
        blockModel(SpacedustryBlocks.RAW_MOLYBDENITE_BLOCK);
        blockModel(SpacedustryBlocks.MOLYBDENUM_BLOCK);
        blockModel(SpacedustryBlocks.NICKEL_ORE);
        blockModel(SpacedustryBlocks.DEEPSLATE_NICKEL_ORE);
        blockModel(SpacedustryBlocks.RAW_NICKEL_BLOCK);
        blockModel(SpacedustryBlocks.NICKEL_BLOCK);
        blockModel(SpacedustryBlocks.SILICON_ORE);
        blockModel(SpacedustryBlocks.RAW_SILICON_BLOCK);
        blockModel(SpacedustryBlocks.SILICON_BLOCK);
        blockModel(SpacedustryBlocks.TUNGSTEN_ORE);
        blockModel(SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE);
        blockModel(SpacedustryBlocks.RAW_TUNGSTEN_BLOCK);
        blockModel(SpacedustryBlocks.TUNGSTEN_BLOCK);

        blockModel(SpacedustryBlocks.SALT_BLOCK);

        blockModel(SpacedustryBlocks.CONSTRUCTOR);
        blockModel(SpacedustryBlocks.GAS_CONDENSER);
        blockModel(SpacedustryBlocks.MANUFACTURER);
        blockModel(SpacedustryBlocks.ROCKET_ASSEMBLER);

        itemModel(SpacedustryItems.RAW_ALUMINUM, GENERATED);
        itemModel(SpacedustryItems.ALUMINUM_INGOT, GENERATED);
        itemModel(SpacedustryItems.RAW_LITHIUM, GENERATED);
        itemModel(SpacedustryItems.LITHIUM_INGOT, GENERATED);
        itemModel(SpacedustryItems.MOLYBDENITE, GENERATED);
        itemModel(SpacedustryItems.MOLYBDENUM_INGOT, GENERATED);
        itemModel(SpacedustryItems.RAW_NICKEL, GENERATED);
        itemModel(SpacedustryItems.NICKEL_INGOT, GENERATED);
        itemModel(SpacedustryItems.RAW_SILICON, GENERATED);
        itemModel(SpacedustryItems.SILICON, GENERATED);
        itemModel(SpacedustryItems.RAW_TUNGSTEN, GENERATED);
        itemModel(SpacedustryItems.TUNGSTEN_INGOT, GENERATED);

        itemModel(SpacedustryItems.SALT, GENERATED);
        itemModel(SpacedustryItems.BULNITE_ALLOY, GENERATED);
        itemModel(SpacedustryItems.COBALT_ALLOY, GENERATED);
        itemModel(SpacedustryItems.DURALUMIN_ALLOY, GENERATED);
        itemModel(SpacedustryItems.STEEL_ALLOY, GENERATED);
        itemModel(SpacedustryItems.SUPER_ALLOY, GENERATED);

        itemModel(SpacedustryItems.COMPOSITE_BUILDER, GENERATED);
        itemModel(SpacedustryItems.AEROGRADE_PLATE, GENERATED);
        itemModel(SpacedustryItems.BULNITE_PLATE, GENERATED);

        itemModel(SpacedustryItems.GAS_CONTAINER, GENERATED);
    }

    public void blockModel(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void itemModel(RegistryObject<Item> item, ModelFile parent) {
        getBuilder(item.getId().getPath()).parent(parent).texture("layer0", "item/" + item.getId().getPath());
    }
}
