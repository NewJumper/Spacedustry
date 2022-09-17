package com.newjumper.spacedustry.datagen.assets;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ENLanguageProvider extends LanguageProvider {
    public ENLanguageProvider(DataGenerator gen) {
        super(gen, Spacedustry.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        SpacedustryBlocks.BLOCKS.getEntries().forEach(this::addBlock);
        SpacedustryItems.ITEMS.getEntries().forEach(this::addItem);

        add("itemGroup.spacedustry", "Spacedustry");
    }

    private void addBlock(RegistryObject<Block> block) {
        String key = block.getId().getPath();
        add("block.spacedustry." + key, convertToName(key));
    }

    private void addItem(RegistryObject<Item> block) {
        String key = block.getId().getPath();
        add("item.spacedustry." + key, convertToName(key));
    }

    private String convertToName(String key) {
        StringBuilder builder = new StringBuilder(key.substring(0, 1).toUpperCase() + key.substring(1));
        for(int i = 1; i < builder.length(); i++) {
            if(builder.charAt(i) == '_') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, " " + Character.toUpperCase(builder.charAt(i)));
            }
        }

        String name = builder.toString();
        if(name.contains(" Block")) name = "Block of " + name.substring(0, name.indexOf(" Block"));

        return name;
    }
}
