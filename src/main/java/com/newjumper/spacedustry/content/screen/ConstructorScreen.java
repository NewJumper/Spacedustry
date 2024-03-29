package com.newjumper.spacedustry.content.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.newjumper.spacedustry.Spacedustry;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class ConstructorScreen extends AbstractContainerScreen<ConstructorMenu> {
    public static final ResourceLocation GUI = new ResourceLocation(Spacedustry.MOD_ID, "textures/gui/container/constructor.png");

    public ConstructorScreen(ConstructorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, GUI);
        int x = this.leftPos;
        int y = this.topPos;

        pGuiGraphics.blit(GUI, x, y, 0, 0, imageWidth, imageHeight);
        if(menu.drawFuel() > -1) pGuiGraphics.blit(GUI, x + 27, y + 25 + menu.drawFuel(), 176, 28 + menu.drawFuel(), 14, 14 - menu.drawFuel());
        if(menu.drawProgress() > 0) pGuiGraphics.blit(GUI, x + 92, y + 30, 176, 0, menu.drawProgress(), 28);
    }
}
