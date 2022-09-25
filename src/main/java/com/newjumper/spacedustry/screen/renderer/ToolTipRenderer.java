package com.newjumper.spacedustry.screen.renderer;

import com.newjumper.spacedustry.capabilities.GasStorage;
import com.newjumper.spacedustry.capabilities.IGasStorage;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ToolTipRenderer<M> extends GuiComponent {
    private final M material;

    public ToolTipRenderer(M material) {
        this.material = material;
    }

    public List<Component> getToolTip() {
        if(material instanceof IGasStorage) return List.of(Component.literal(((GasStorage) material).getGasType().getFormula() + " - " + ((GasStorage) material).getGasStored() + " mb"));
        return null;
    }
}
