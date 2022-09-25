package com.newjumper.spacedustry.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.capabilities.IGasStorage;
import com.newjumper.spacedustry.screen.renderer.ToolTipRenderer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GasCondenserScreen extends AbstractContainerScreen<GasCondenserMenu> {
    public static final ResourceLocation GUI = new ResourceLocation(Spacedustry.MOD_ID, "textures/gui/container/gas_condenser.png");
    private final ToolTipRenderer<IGasStorage> gasToolTip = new ToolTipRenderer<>(menu.blockEntity.hydrogenStorage);

    public GasCondenserScreen(GasCondenserMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderLabels(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY) {
        super.renderLabels(pPoseStack, pMouseX, pMouseY);

        if(isHovering(70, 23, 24, 44, pMouseX, pMouseY)) renderTooltip(pPoseStack, gasToolTip.getToolTip(), Optional.empty(), pMouseX - this.leftPos, pMouseY - this.topPos);
    }

    @Override
    protected void renderBg(@NotNull PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, GUI);
        int x = this.leftPos;
        int y = this.topPos;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        int frame = (int) (menu.blockEntity.getLevel().getGameTime() / 5) % 6;
        this.blit(pPoseStack, x + 45, y + 19, 176 + 13 * frame, 0, 13, 24);

        if(menu.drawGas() > 0) this.blit(pPoseStack, x + 70, y + 67 - this.menu.drawGas(), 184, 68 - this.menu.drawGas(), 24, this.menu.drawGas());
    }
}
