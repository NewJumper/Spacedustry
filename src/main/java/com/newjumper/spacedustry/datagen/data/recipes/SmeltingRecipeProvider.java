package com.newjumper.spacedustry.datagen.data.recipes;

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

public class SmeltingRecipeProvider extends RecipeProvider implements IConditionBuilder {
    protected final ImmutableList<ItemLike> ALUMINUM_ORES = ImmutableList.of(SpacedustryBlocks.ALUMINUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_ALUMINUM_ORE.get());
    protected final ImmutableList<ItemLike> LITHIUM_ORES = ImmutableList.of(SpacedustryBlocks.LITHIUM_ORE.get(), SpacedustryBlocks.DEEPSLATE_LITHIUM_ORE.get());
    protected final ImmutableList<ItemLike> MOLYBDENITE_ORES = ImmutableList.of(SpacedustryBlocks.MOLYBDENITE_ORE.get(), SpacedustryBlocks.DEEPSLATE_MOLYBDENITE_ORE.get());
    protected final ImmutableList<ItemLike> NICKEL_ORES = ImmutableList.of(SpacedustryBlocks.NICKEL_ORE.get(), SpacedustryBlocks.DEEPSLATE_NICKEL_ORE.get());
    protected final ImmutableList<ItemLike> SILICON_ORES = ImmutableList.of(SpacedustryBlocks.SILICON_ORE.get());
    protected final ImmutableList<ItemLike> TUNGSTEN_ORES = ImmutableList.of(SpacedustryBlocks.TUNGSTEN_ORE.get(), SpacedustryBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

    public SmeltingRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, ALUMINUM_ORES, SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, 200, "aluminum_ingot");
        oreSmelting(consumer, LITHIUM_ORES, SpacedustryItems.LITHIUM_INGOT.get(), 3f, 200, "lithium_ingot");
        oreSmelting(consumer, MOLYBDENITE_ORES, SpacedustryItems.MOLYBDENUM_INGOT.get(), 3f, 200, "molybdenum_ingot");
        oreSmelting(consumer, NICKEL_ORES, SpacedustryItems.NICKEL_INGOT.get(), 3f, 200, "nickel_ingot");
        oreSmelting(consumer, SILICON_ORES, SpacedustryItems.SILICON.get(), 3f, 200, "silicon");
        oreSmelting(consumer, TUNGSTEN_ORES, SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, 200, "tungsten_ingot");

        oreBlasting(consumer, ALUMINUM_ORES, SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, 100, "aluminum_ingot");
        oreBlasting(consumer, LITHIUM_ORES, SpacedustryItems.LITHIUM_INGOT.get(), 3f, 100, "lithium_ingot");
        oreBlasting(consumer, MOLYBDENITE_ORES, SpacedustryItems.MOLYBDENUM_INGOT.get(), 3f, 100, "molybdenum_ingot");
        oreBlasting(consumer, NICKEL_ORES, SpacedustryItems.NICKEL_INGOT.get(), 3f, 100, "nickel_ingot");
        oreBlasting(consumer, SILICON_ORES, SpacedustryItems.SILICON.get(), 3f, 100, "silicon");
        oreBlasting(consumer, TUNGSTEN_ORES, SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, 100, "tungsten_ingot");
    }

    @NotNull
    @Override
    public String getName() {
        return "Smelting Recipes";
    }
}
