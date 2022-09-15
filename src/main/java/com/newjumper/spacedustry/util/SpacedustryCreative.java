package com.newjumper.spacedustry.util;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SpacedustryCreative {
    public static final CreativeModeTab SPACEDUSTRY = new CreativeModeTab(Spacedustry.MOD_ID) {
        @NotNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SpacedustryBlocks.LITHIUM_ORE.get());
        }
    };
}
