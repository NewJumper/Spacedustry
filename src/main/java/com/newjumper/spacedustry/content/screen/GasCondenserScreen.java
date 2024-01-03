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

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GasCondenserScreen extends AbstractContainerScreen<GasCondenserMenu> {
    public static final ResourceLocation GUI = new ResourceLocation(Spacedustry.MOD_ID, "textures/gui/container/gas_condenser.png");

    public GasCondenserScreen(GasCondenserMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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
    protected void renderLabels(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        super.renderLabels(pGuiGraphics, pMouseX, pMouseY);

        if(isHovering(70, 23, 24, 44, pMouseX, pMouseY)) {
            Component tooltip = Component.literal((menu.blockEntity.hydrogenStorage).getGasType().getFormula() + " - " + (menu.blockEntity.hydrogenStorage).getGasStored() + " mb");
            pGuiGraphics.renderTooltip(this.font, List.of(tooltip), Optional.empty(), pMouseX - this.leftPos, pMouseY - this.topPos);
        }
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, GUI);
        int x = this.leftPos;
        int y = this.topPos;

        pGuiGraphics.blit(GUI, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.blockEntity.canCondense()) {
            int frame = (int) (Objects.requireNonNull(menu.blockEntity.getLevel()).getGameTime() / 4) % 6;
            pGuiGraphics.blit(GUI, x + 45, y + 19, 176 + 13 * frame, 0, 13, 24);
        }

        if(menu.drawGas() > 0) pGuiGraphics.blit(GUI, x + 70, y + 67 - this.menu.drawGas(), 184, 68 - this.menu.drawGas(), 24, this.menu.drawGas());
    }
}
