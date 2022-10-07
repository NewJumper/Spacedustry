package com.newjumper.spacedustry.recipe;

import com.newjumper.spacedustry.Spacedustry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SpacedustryRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Spacedustry.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ConstructingRecipe>> CONSTRUCTING = RECIPE_SERIALIZERS.register("constructing", ConstructingRecipe.Serializer::new);
    public static final RegistryObject<RecipeSerializer<ManufacturingRecipe>> MANUFACTURING = RECIPE_SERIALIZERS.register("manufacturing", ManufacturingRecipe.Serializer::new);
}
