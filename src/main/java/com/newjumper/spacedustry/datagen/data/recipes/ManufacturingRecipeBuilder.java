package com.newjumper.spacedustry.datagen.data.recipes;

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
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("NullableProblems")
public class ManufacturingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final int count;
    private final float experience;
    private final int time;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public ManufacturingRecipeBuilder(ItemLike result, int count) {
        this(result, count, 0);
    }

    public ManufacturingRecipeBuilder(ItemLike result, int count, float experience) {
        this(result, count, experience, 250);
    }

    public ManufacturingRecipeBuilder(ItemLike result, int count, float experience, int time) {
        this.result = result.asItem();
        this.count = count;
        this.experience = experience;
        this.time = time;
    }

    public ManufacturingRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(tag, 1);
    }

    public ManufacturingRecipeBuilder requires(TagKey<Item> tag, int quantity) {
        for(int i = 0; i < quantity; i++) {
            this.ingredients.add(Ingredient.of(tag));
        }
        return this;
    }

    public ManufacturingRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }

    public ManufacturingRecipeBuilder requires(ItemLike item, int quantity) {
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
    public RecipeBuilder group(String pGroupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer) {
        this.save(consumer, new ResourceLocation(Spacedustry.MOD_ID, ForgeRegistries.ITEMS.getKey(result).getPath() + "_manufacturing"));
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation recipeId) {
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);
        consumer.accept(new ManufacturingRecipeBuilder.Result(recipeId, this.result, this.ingredients, this.count, this.experience, this.time, this.advancement, recipeId.withPrefix("recipes/" + RecipeCategory.MISC.getFolderName() + "/")));
        System.out.println(result.getDescriptionId());
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final List<Ingredient> ingredients;
        private final int count;
        private final float experience;
        private final int time;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, Item result, List<Ingredient> ingredients, int count, float experience, int time, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.result = result;
            this.ingredients = ingredients;
            this.count = count;
            this.experience = experience;
            this.time = time;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            JsonArray jsonarray = new JsonArray();
            for(Ingredient ingredient : this.ingredients) {
                jsonarray.add(ingredient.toJson());
            }

            pJson.add("ingredients", jsonarray);
            JsonObject resultJson = new JsonObject();
            resultJson.addProperty("item", String.valueOf(ForgeRegistries.ITEMS.getKey(result)));

            pJson.add("result", resultJson);
            if(count > 1) resultJson.addProperty("count", count);

            if(experience != 0) pJson.addProperty("experience", experience);
            if(time != 250) pJson.addProperty("time", time);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return SpacedustryRecipes.MANUFACTURING.get();
        }

        @Override
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
