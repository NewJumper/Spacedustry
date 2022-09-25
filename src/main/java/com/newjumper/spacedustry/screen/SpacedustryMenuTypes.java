package com.newjumper.spacedustry.screen;

import com.newjumper.spacedustry.Spacedustry;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SpacedustryMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Spacedustry.MOD_ID);

    public static final RegistryObject<MenuType<ConstructorMenu>> CONSTRUCTOR_MENU = MENUS.register("constructor_menu", () -> IForgeMenuType.create(ConstructorMenu::new));
    public static final RegistryObject<MenuType<GasCondenserMenu>> GAS_CONDENSER_MENU = MENUS.register("gas_condenser_menu", () -> IForgeMenuType.create(GasCondenserMenu::new));
}
