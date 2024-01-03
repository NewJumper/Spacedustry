package com.newjumper.spacedustry.datagen.data;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.SpacedustryItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

@SuppressWarnings("NullableProblems")
public class SpacedustryAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        String id = "advancements." + Spacedustry.MOD_ID + ".";

        Advancement root = Advancement.Builder.advancement().display(SpacedustryItems.RAW_ALUMINUM.get(), Component.translatable(id + "root.title"), Component.translatable(id + "root.description"), new ResourceLocation(Spacedustry.MOD_ID, "textures/gui/advancements/root.png"), FrameType.TASK, false, false, false)
                .addCriterion("aluminum", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.RAW_ALUMINUM.get()))
                .addCriterion("lithium", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.RAW_LITHIUM.get()))
                .addCriterion("molybdenite", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.MOLYBDENITE.get()))
                .addCriterion("nickel", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.RAW_NICKEL.get()))
                .addCriterion("silicon", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.RAW_SILICON.get()))
                .addCriterion("tungsten", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.RAW_TUNGSTEN.get()))
                .requirements(RequirementsStrategy.OR).save(saver, path("root"), existingFileHelper);

        Advancement.Builder.advancement().parent(root).display(SpacedustryItems.STEEL_ALLOY.get(), Component.translatable(id + "forge_alloy.title"), Component.translatable(id + "forge_alloy.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("bulnite", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.BULNITE_ALLOY.get()))
                .addCriterion("cobalt", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.COBALT_ALLOY.get()))
                .addCriterion("duralumin", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.DURALUMIN_ALLOY.get()))
                .addCriterion("steel", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.STEEL_ALLOY.get()))
                .addCriterion("super", InventoryChangeTrigger.TriggerInstance.hasItems(SpacedustryItems.SUPER_ALLOY.get()))
                .requirements(RequirementsStrategy.OR).save(saver, path("forge_alloy"), existingFileHelper);
    }

    private ResourceLocation path(String name) {
        return new ResourceLocation(Spacedustry.MOD_ID, "main/" + name);
    }
}
