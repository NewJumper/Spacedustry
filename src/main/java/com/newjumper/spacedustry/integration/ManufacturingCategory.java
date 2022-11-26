package com.newjumper.spacedustry.integration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.vertex.PoseStack;
import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import com.newjumper.spacedustry.item.SpacedustryItems;
import com.newjumper.spacedustry.recipe.ManufacturingRecipe;
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
import net.minecraft.world.item.crafting.Ingredient;

public class ManufacturingCategory implements IRecipeCategory<ManufacturingRecipe> {
    public final static ResourceLocation TEXTURE = new ResourceLocation(Spacedustry.MOD_ID, "textures/gui/container/manufacturer.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final LoadingCache<Integer, IDrawableAnimated> progress;
    private final LoadingCache<Integer, IDrawableAnimated> power;
    private final int time;

    public ManufacturingCategory(IGuiHelper guiHelper, int time) {
        this.background = guiHelper.createDrawable(TEXTURE, 52, 17, 107, 53);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(SpacedustryBlocks.MANUFACTURER.get()));

        this.progress = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<>() {
            @Override
            public IDrawableAnimated load(Integer time) {
                return guiHelper.drawableBuilder(TEXTURE, 176, 0, 24, 17).buildAnimated(time, IDrawableAnimated.StartDirection.LEFT, false);
            }
        });
        this.power = CacheBuilder.newBuilder().maximumSize(10).build(new CacheLoader<>() {
            @Override
            public IDrawableAnimated load(Integer time) {
                return guiHelper.drawableBuilder(TEXTURE, 176, 17, 16, 9).buildAnimated(time, IDrawableAnimated.StartDirection.TOP, true);
            }
        });
        this.time = time;
    }

    @Override
    public RecipeType<ManufacturingRecipe> getRecipeType() {
        return RecipeType.create(Spacedustry.MOD_ID, "manufacturing", ManufacturingRecipe.class);
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container." + Spacedustry.MOD_ID + "." + SpacedustryBlocks.MANUFACTURER.getId().getPath());
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
    public void setRecipe(IRecipeLayoutBuilder builder, ManufacturingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 12, 33).addIngredients(Ingredient.of(SpacedustryItems.COMPOSITE_BUILDER.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 3).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 23, 3).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 84, 18).addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(ManufacturingRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        this.progress.getUnchecked((time - 10) / 3).draw(stack, 46, 17);
        this.power.getUnchecked((time - 10) / 4).draw(stack, 12, 21);

        Font fontRenderer = Minecraft.getInstance().font;
        int stringWidth = fontRenderer.width(time / 20 + "s");
        fontRenderer.draw(stack, time / 20 + "s", background.getWidth() - stringWidth, background.getHeight() - 9, 0xff808080);
    }
}
