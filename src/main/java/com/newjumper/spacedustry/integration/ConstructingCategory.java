package com.newjumper.spacedustry.integration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.vertex.PoseStack;
import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.recipe.ConstructingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ConstructingCategory implements IRecipeCategory<ConstructingRecipe> {
    public final static ResourceLocation TEXTURE = new ResourceLocation(Spacedustry.MOD_ID, "textures/gui/container/constructor.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final LoadingCache<Integer, IDrawableAnimated> progress;
    private final int time;

    public ConstructingCategory(IGuiHelper guiHelper, int time) {
        this.background = guiHelper.createDrawable(TEXTURE, 68, 16, 91, 54);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(SpacedustryBlocks.CONSTRUCTOR.get()));

        this.progress = CacheBuilder.newBuilder().maximumSize(30).build(new CacheLoader<>() {
            @Override
            public IDrawableAnimated load(Integer time) {
                return guiHelper.drawableBuilder(TEXTURE, 176, 0, 29, 28).buildAnimated(time, IDrawableAnimated.StartDirection.LEFT, false);
            }
        });
        this.time = time;
    }

    @Override
    public RecipeType<ConstructingRecipe> getRecipeType() {
        return RecipeType.create(Spacedustry.MOD_ID, "constructing", ConstructingRecipe.class);
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container." + Spacedustry.MOD_ID + "." + SpacedustryBlocks.CONSTRUCTOR.getId().getPath());
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ConstructingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 7).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 31).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 68, 19).addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(ConstructingRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        this.progress.getUnchecked((time - 10) / 3).draw(stack, 24, 14);

        Font fontRenderer = Minecraft.getInstance().font;
        int stringWidth = fontRenderer.width(time / 20 + "s");
        fontRenderer.draw(stack, time / 20 + "s", background.getWidth() - stringWidth, background.getHeight() - 9, 0xff808080);
    }
}
