package com.newjumper.spacedustry.datagen.data;

import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class SmeltingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public SmeltingRecipesProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(SpacedustryBlocks.ALUMINUM_ORE.get()), SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, 200, "aluminum_ingot");
        oreSmelting(consumer, List.of(SpacedustryBlocks.LITHIUM_ORE.get()), SpacedustryItems.LITHIUM_INGOT.get(), 3f, 200, "lithium_ingot");
        oreSmelting(consumer, List.of(SpacedustryBlocks.TUNGSTEN_ORE.get()), SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, 200, "tungsten_ingot");

        oreBlasting(consumer, List.of(SpacedustryBlocks.ALUMINUM_ORE.get()), SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, 100, "aluminum_ingot");
        oreBlasting(consumer, List.of(SpacedustryBlocks.LITHIUM_ORE.get()), SpacedustryItems.LITHIUM_INGOT.get(), 3f, 100, "lithium_ingot");
        oreBlasting(consumer, List.of(SpacedustryBlocks.TUNGSTEN_ORE.get()), SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, 100, "tungsten_ingot");
    }

    @NotNull
    @Override
    public String getName() {
        return "Smelting Recipes";
    }
}
