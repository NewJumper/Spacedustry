package com.newjumper.spacedustry.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

@SuppressWarnings("NullableProblems")
public class ConstructingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;
    private final float experience;
    private final int time;

    public ConstructingRecipe(ResourceLocation pId, NonNullList<Ingredient> pIngredients, ItemStack pResult, float pExperience, int pTime) {
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
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return result.copy();
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
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return result;
    }

    public float getExperience() {
        return experience;
    }

    public int getTime() {
        return time;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SpacedustryRecipes.CONSTRUCTING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<ConstructingRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<ConstructingRecipe> {
        @Override
        public ConstructingRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            JsonArray input = GsonHelper.getAsJsonArray(pJson, "ingredients");
            NonNullList<Ingredient> ingredients = NonNullList.withSize(2, Ingredient.EMPTY);
            for(int i = 0; i < ingredients.size(); i++) {
                ingredients.set(i, Ingredient.fromJson(input.get(i)));
            }
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));
            float experience = GsonHelper.getAsFloat(pJson, "experience", 0);
            int time = GsonHelper.getAsInt(pJson, "time", 250);

            return new ConstructingRecipe(pId, ingredients, result, experience, time);
        }

        @Override
        public ConstructingRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
            ingredients.replaceAll(ignored -> Ingredient.fromNetwork(pBuffer));
            ItemStack result = pBuffer.readItem();
            float experience = pBuffer.readFloat();
            int time = pBuffer.readVarInt();

            return new ConstructingRecipe(pId, ingredients, result, experience, time);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ConstructingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());
            for(Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }
            pBuffer.writeItem(pRecipe.result);
            pBuffer.writeFloat(pRecipe.experience);
            pBuffer.writeVarInt(pRecipe.time);
        }
    }
}
