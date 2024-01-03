package com.newjumper.spacedustry.integration;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.SpacedustryBlocks;
import com.newjumper.spacedustry.recipe.ConstructingRecipe;
import com.newjumper.spacedustry.recipe.ManufacturingRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class SpacedustryJEI implements IModPlugin {
    private final RecipeType<ConstructingRecipe> CONSTRUCTING = RecipeType.create(Spacedustry.MOD_ID, "constructing", ConstructingRecipe.class);
    private final RecipeType<ManufacturingRecipe> MANUFACTURING = RecipeType.create(Spacedustry.MOD_ID, "manufacturing", ManufacturingRecipe.class);

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(Spacedustry.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();

        registration.addRecipeCategories(new ConstructingCategory(guiHelper, 250), new ManufacturingCategory(guiHelper, 250));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipes = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<ConstructingRecipe> constructingRecipes = recipes.getAllRecipesFor(ConstructingRecipe.Type.INSTANCE);
        List<ManufacturingRecipe> manufacturingRecipes = recipes.getAllRecipesFor(ManufacturingRecipe.Type.INSTANCE);

        registration.addRecipes(CONSTRUCTING, constructingRecipes);
        registration.addRecipes(MANUFACTURING, manufacturingRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(SpacedustryBlocks.CONSTRUCTOR.get()), CONSTRUCTING);
        registration.addRecipeCatalyst(new ItemStack(SpacedustryBlocks.MANUFACTURER.get()), MANUFACTURING);
    }
}
