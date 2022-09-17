package com.newjumper.spacedustry.datagen.data;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipesProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(SpacedustryBlocks.SALT_BLOCK.get()).define('#', SpacedustryItems.SALT.get()).pattern("##").pattern("##").unlockedBy("has_salt", has(SpacedustryItems.SALT.get())).save(consumer);
    }

    @NotNull
    @Override
    public String getName() {
        return "Crafting Recipes";
    }
}
