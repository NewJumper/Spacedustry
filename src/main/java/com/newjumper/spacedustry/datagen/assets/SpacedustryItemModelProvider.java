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
        blockModel(SpacedustryBlocks.ALUMINUM_ORE);
        blockModel(SpacedustryBlocks.LITHIUM_ORE);
        blockModel(SpacedustryBlocks.TUNGSTEN_ORE);

        itemModel(SpacedustryItems.RAW_ALUMINUM, GENERATED);
        itemModel(SpacedustryItems.ALUMINUM_INGOT, GENERATED);
        itemModel(SpacedustryItems.RAW_LITHIUM, GENERATED);
        itemModel(SpacedustryItems.LITHIUM_INGOT, GENERATED);
        itemModel(SpacedustryItems.RAW_TUNGSTEN, GENERATED);
        itemModel(SpacedustryItems.TUNGSTEN_INGOT, GENERATED);
    }

    public void blockModel(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void itemModel(RegistryObject<Item> item, ModelFile parent) {
        getBuilder(item.getId().getPath()).parent(parent).texture("layer0", "item/" + item.getId().getPath());
    }
}
