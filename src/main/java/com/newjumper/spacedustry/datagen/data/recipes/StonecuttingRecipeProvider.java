package com.newjumper.spacedustry.datagen.data.recipes;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class StonecuttingRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public StonecuttingRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        stonecutterResultFromBase(consumer, SpacedustryBlocks.MOON_STONE_BRICKS.get(), SpacedustryBlocks.COBBLED_MOON_STONE.get());
    }

    @NotNull
    @Override
    public String getName() {
        return "Stonecutting Recipes";
    }
}
