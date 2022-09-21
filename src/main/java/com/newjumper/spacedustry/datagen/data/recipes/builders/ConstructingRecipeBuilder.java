package com.newjumper.spacedustry.datagen.data.recipes.builders;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.recipe.SpacedustryRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class ConstructingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final int count;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final float experience;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public ConstructingRecipeBuilder(ItemLike result, int count) {
        this(result, count, 0);
    }

    public ConstructingRecipeBuilder(ItemLike result, int count, float experience) {
        this.result = result.asItem();
        this.count = count;
        this.experience = experience;
    }

    public ConstructingRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(tag, 1);
    }

    public ConstructingRecipeBuilder requires(TagKey<Item> tag, int quantity) {
        for(int i = 0; i < quantity; i++) {
            this.ingredients.add(Ingredient.of(tag));
        }
        return this;
    }

    public ConstructingRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }

    public ConstructingRecipeBuilder requires(ItemLike item, int quantity) {
        for(int i = 0; i < quantity; i++) {
            this.ingredients.add(Ingredient.of(item));
        }
        return this;
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer) {
        this.save(consumer, new ResourceLocation(Spacedustry.MOD_ID, ForgeRegistries.ITEMS.getKey(result).getPath() + "_constructing"));
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation recipeId) {
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);
        consumer.accept(new ConstructingRecipeBuilder.Result(recipeId, this.result, this.count, this.ingredients, this.experience, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath())));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final List<Ingredient> ingredients;
        private final float experience;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pId, Item pResult, int pCount, List<Ingredient> pIngredients, float pExperience, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
            this.id = pId;
            this.result = pResult;
            this.count = pCount;
            this.ingredients = pIngredients;
            this.experience = pExperience;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            JsonArray jsonarray = new JsonArray();
            for(Ingredient ingredient : this.ingredients) {
                jsonarray.add(ingredient.toJson());
            }

            pJson.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", String.valueOf(ForgeRegistries.ITEMS.getKey(result)));
            if (this.count > 1) {
                jsonobject.addProperty("count", this.count);
            }

            pJson.add("result", jsonobject);
            pJson.addProperty("experience", this.experience);
            pJson.addProperty("time", 200);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return SpacedustryRecipes.CONSTRUCTING.get();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
