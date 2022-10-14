package com.newjumper.spacedustry.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class ManufacturingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;
    private final float experience;
    private final int time;

    public ManufacturingRecipe(ResourceLocation pId, NonNullList<Ingredient> pIngredients, ItemStack pResult, float pExperience, int pTime) {
        this.id = pId;
        this.ingredients = pIngredients;
        this.result = pResult;
        this.experience = pExperience;
        this.time = pTime;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return (ingredients.get(0).test(pContainer.getItem(1)) && ingredients.get(1).test(pContainer.getItem(2))) ||
               (ingredients.get(1).test(pContainer.getItem(1)) && ingredients.get(0).test(pContainer.getItem(2)));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public ItemStack getResultItem() {
        return result.copy();
    }

    public float getExperience() {
        return experience;
    }

    public int getTime() {
        return time;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SpacedustryRecipes.MANUFACTURING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ManufacturingRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<ManufacturingRecipe> {
        private Type() {}
        public static final ManufacturingRecipe.Type INSTANCE = new ManufacturingRecipe.Type();
    }

    public static class Serializer implements RecipeSerializer<ManufacturingRecipe> {
        @Override
        public ManufacturingRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            JsonArray input = GsonHelper.getAsJsonArray(pJson, "ingredients");
            NonNullList<Ingredient> ingredients = NonNullList.withSize(2, Ingredient.EMPTY);
            for(int i = 0; i < ingredients.size(); i++) {
                ingredients.set(i, Ingredient.fromJson(input.get(i)));
            }
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));
            float experience = GsonHelper.getAsFloat(pJson, "experience", 0);
            int time = GsonHelper.getAsInt(pJson, "time", 250);

            return new ManufacturingRecipe(pId, ingredients, result, experience, time);
        }

        @Override
        public ManufacturingRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
            ingredients.replaceAll(ignored -> Ingredient.fromNetwork(pBuffer));
            ItemStack result = pBuffer.readItem();
            float experience = pBuffer.readFloat();
            int time = pBuffer.readVarInt();

            return new ManufacturingRecipe(pId, ingredients, result, experience, time);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ManufacturingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());
            for(Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }
            pBuffer.writeItem(pRecipe.getResultItem());
            pBuffer.writeFloat(pRecipe.getExperience());
            pBuffer.writeVarInt(pRecipe.getTime());
        }
    }
}
