package com.newjumper.spacedustry.datagen.assets;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.SpacedustryBlocks;
import com.newjumper.spacedustry.content.SpacedustryItems;
import com.newjumper.spacedustry.content.block.entity.SpacedustryBlockEntities;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ENLanguageProvider extends LanguageProvider {
    public ENLanguageProvider(PackOutput output) {
        super(output, Spacedustry.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        SpacedustryBlocks.BLOCKS.getEntries().forEach(block -> add(block, "block"));
        SpacedustryItems.ITEMS.getEntries().stream().filter(item -> !(item.get() instanceof BlockItem)).forEach(item -> add(item, "item"));
        SpacedustryBlockEntities.BLOCK_ENTITIES.getEntries().forEach(container -> add(container, "container"));

        add("advancements." + Spacedustry.MOD_ID + ".root.title", "Spacedustry");
        add("advancements." + Spacedustry.MOD_ID + ".root.description", "New materials, new technology");
        add("advancements." + Spacedustry.MOD_ID + ".forge_alloy.title", "Forger");
        add("advancements." + Spacedustry.MOD_ID + ".forge_alloy.description", "Construct an alloy using a Constructor");

        add("itemGroup." + Spacedustry.MOD_ID, "Spacedustry");
    }

    private void add(RegistryObject<?> entry, String prefix) {
        String key = entry.getId().getPath();
        add(prefix + "." + Spacedustry.MOD_ID + "." + key, convertToName(key));
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
