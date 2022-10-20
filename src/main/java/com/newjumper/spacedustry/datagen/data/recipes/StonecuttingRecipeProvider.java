package com.newjumper.spacedustry.datagen.data.recipes;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class StonecuttingRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public StonecuttingRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        resultFromBase(SpacedustryBlocks.MOON_STONE_BRICKS.get(), SpacedustryBlocks.COBBLED_MOON_STONE.get(), consumer);
    }

    private void resultFromBase(ItemLike result, ItemLike base, Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(base), result, 1).unlockedBy(getHasName(base), has(base)).save(consumer, new ResourceLocation(Spacedustry.MOD_ID, getConversionRecipeName(result, base) + "_stonecutting"));
    }

    @NotNull
    @Override
    public String getName() {
        return "Stonecutting Recipes";
    }
}
