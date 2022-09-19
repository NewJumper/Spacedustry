package com.newjumper.spacedustry.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.newjumper.spacedustry.Spacedustry;
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
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void renderBg(@NotNull PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, GUI);
        int x = this.leftPos;
        int y = this.topPos;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
    }
}