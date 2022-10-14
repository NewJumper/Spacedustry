package com.newjumper.spacedustry.datagen.data.recipes;

import com.newjumper.spacedustry.datagen.data.recipes.builders.ConstructingRecipeBuilder;
import com.newjumper.spacedustry.datagen.data.recipes.builders.ManufacturingRecipeBuilder;
import com.newjumper.spacedustry.item.SpacedustryItems;
import com.newjumper.spacedustry.util.SpacedustryTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class MachiningRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public MachiningRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        new ConstructingRecipeBuilder(SpacedustryItems.BULNITE_ALLOY.get(), 1)
                .requires(SpacedustryTags.Items.INGOTS_ALUMINUM).requires(SpacedustryTags.Items.INGOTS_LITHIUM)
                .unlockedBy("has_aluminum", has(SpacedustryTags.Items.INGOTS_ALUMINUM)).unlockedBy("has_lithium", has(SpacedustryTags.Items.INGOTS_LITHIUM)).save(consumer);

        new ConstructingRecipeBuilder(SpacedustryItems.COBALT_ALLOY.get(), 1)
                .requires(Tags.Items.INGOTS_COPPER).requires(SpacedustryTags.Items.INGOTS_NICKEL)
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).unlockedBy("has_nickel", has(SpacedustryTags.Items.INGOTS_NICKEL)).save(consumer);

        new ConstructingRecipeBuilder(SpacedustryItems.DURALUMIN_ALLOY.get(), 1)
                .requires(SpacedustryTags.Items.INGOTS_ALUMINUM).requires(Tags.Items.INGOTS_COPPER)
                .unlockedBy("has_aluminum", has(SpacedustryTags.Items.INGOTS_ALUMINUM)).unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).save(consumer);

        new ConstructingRecipeBuilder(SpacedustryItems.STEEL_ALLOY.get(), 1)
                .requires(Items.COAL).requires(Tags.Items.INGOTS_IRON)
                .unlockedBy("has_coal", has(Items.COAL)).unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);

        new ConstructingRecipeBuilder(SpacedustryItems.SUPER_ALLOY.get(), 1)
                .requires(SpacedustryTags.Items.INGOTS_MOLYBDENUM).requires(SpacedustryTags.Items.INGOTS_NICKEL)
                .unlockedBy("has_molybdenum", has(SpacedustryTags.Items.INGOTS_MOLYBDENUM)).unlockedBy("has_nickel", has(SpacedustryTags.Items.ORES_NICKEL)).save(consumer);


        new ManufacturingRecipeBuilder(SpacedustryItems.BULNITE_PLATE.get(), 1)
                .requires(SpacedustryItems.BULNITE_ALLOY.get(), 2)
                .unlockedBy("has_bulnite", has(SpacedustryItems.BULNITE_ALLOY.get())).save(consumer);

        new ManufacturingRecipeBuilder(SpacedustryItems.AEROGRADE_PLATE.get(), 1)
                .requires(SpacedustryItems.STEEL_ALLOY.get()).requires(SpacedustryItems.DURALUMIN_ALLOY.get())
                .unlockedBy("has_steel", has(SpacedustryItems.STEEL_ALLOY.get())).unlockedBy("has_duralumin", has(SpacedustryItems.DURALUMIN_ALLOY.get())).save(consumer);
    }

    @NotNull
    @Override
    public String getName() {
        return "Constructing Recipes";
    }
}
