package com.newjumper.spacedustry.datagen.data.recipes;

import com.google.common.collect.ImmutableList;
import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
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
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(SpacedustryBlocks.COBBLED_MOON_STONE.get()), SpacedustryBlocks.MOON_STONE.get().asItem(), 0.2f, 200).unlockedBy("has_cobbled_moon_stone", has(SpacedustryBlocks.COBBLED_MOON_STONE.get())).save(consumer);

        oreSmelting(ALUMINUM_ORES, SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, "aluminum_ingot", consumer);
        oreSmelting(LITHIUM_ORES, SpacedustryItems.LITHIUM_INGOT.get(), 3f, "lithium_ingot", consumer);
        oreSmelting(MOLYBDENITE_ORES, SpacedustryItems.MOLYBDENUM_INGOT.get(), 3f, "molybdenum_ingot", consumer);
        oreSmelting(NICKEL_ORES, SpacedustryItems.NICKEL_INGOT.get(), 3f, "nickel_ingot", consumer);
        oreSmelting(SILICON_ORES, SpacedustryItems.SILICON.get(), 3f, "silicon", consumer);
        oreSmelting(TUNGSTEN_ORES, SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, "tungsten_ingot", consumer);

        oreBlasting(ALUMINUM_ORES, SpacedustryItems.ALUMINUM_INGOT.get(), 2.8f, "aluminum_ingot", consumer);
        oreBlasting(LITHIUM_ORES, SpacedustryItems.LITHIUM_INGOT.get(), 3f, "lithium_ingot", consumer);
        oreBlasting(MOLYBDENITE_ORES, SpacedustryItems.MOLYBDENUM_INGOT.get(), 3f, "molybdenum_ingot", consumer);
        oreBlasting(NICKEL_ORES, SpacedustryItems.NICKEL_INGOT.get(), 3f, "nickel_ingot", consumer);
        oreBlasting(SILICON_ORES, SpacedustryItems.SILICON.get(), 3f, "silicon", consumer);
        oreBlasting(TUNGSTEN_ORES, SpacedustryItems.TUNGSTEN_INGOT.get(), 4f, "tungsten_ingot", consumer);
    }

    private void oreSmelting(List<ItemLike> ingredients, ItemLike result, float experience, String group, Consumer<FinishedRecipe> consumer) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.smelting(Ingredient.of(item), result, experience, 200).group(group).unlockedBy(getHasName(item), has(item)).save(consumer, new ResourceLocation(Spacedustry.MOD_ID, getItemName(result) + "_from_smelting_" + getItemName(item)));
    }

    private void oreBlasting(List<ItemLike> ingredients, ItemLike result, float experience, String group, Consumer<FinishedRecipe> consumer) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.blasting(Ingredient.of(item), result, experience, 100).group(group).unlockedBy(getHasName(item), has(item)).save(consumer, new ResourceLocation(Spacedustry.MOD_ID, getItemName(result) + "_from_blasting_" + getItemName(item)));
    }

    @NotNull
    @Override
    public String getName() {
        return "Smelting Recipes";
    }
}
