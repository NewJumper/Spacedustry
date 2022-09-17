package com.newjumper.spacedustry.datagen.data;

import com.google.common.collect.ImmutableList;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class SmeltingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    protected final ImmutableList<ItemLike> ALUMINUM_ORES = ImmutableList.of(SpacedustryBlocks.ALUMINUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get());
    protected final ImmutableList<ItemLike> LITHIUM_ORES = ImmutableList.of(SpacedustryBlocks.LITHIUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get());
    protected final ImmutableList<ItemLike> TUNGSTEN_ORES = ImmutableList.of(SpacedustryBlocks.TUNGSTEN_ORE.get(), SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

    public SmeltingRecipesProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, ALUMINUM_ORES, SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, 200, "aluminum_ingot");
        oreSmelting(consumer, LITHIUM_ORES, SpacedustryItems.LITHIUM_INGOT.get(), 3f, 200, "lithium_ingot");
        oreSmelting(consumer, TUNGSTEN_ORES, SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, 200, "tungsten_ingot");

        oreBlasting(consumer, ALUMINUM_ORES, SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, 100, "aluminum_ingot");
        oreBlasting(consumer, LITHIUM_ORES, SpacedustryItems.LITHIUM_INGOT.get(), 3f, 100, "lithium_ingot");
        oreBlasting(consumer, TUNGSTEN_ORES, SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, 100, "tungsten_ingot");
    }

    @NotNull
    @Override
    public String getName() {
        return "Smelting Recipes";
    }
}
