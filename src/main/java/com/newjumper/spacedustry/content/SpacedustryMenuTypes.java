package com.newjumper.spacedustry.content;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.content.screen.ConstructorMenu;
import com.newjumper.spacedustry.content.screen.GasCondenserMenu;
import com.newjumper.spacedustry.content.screen.ManufacturerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SpacedustryMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Spacedustry.MOD_ID);

    public static final RegistryObject<MenuType<ConstructorMenu>> CONSTRUCTOR_MENU = MENUS.register("constructor_menu", () -> IForgeMenuType.create(ConstructorMenu::new));
    public static final RegistryObject<MenuType<GasCondenserMenu>> GAS_CONDENSER_MENU = MENUS.register("gas_condenser_menu", () -> IForgeMenuType.create(GasCondenserMenu::new));
    public static final RegistryObject<MenuType<ManufacturerMenu>> MANUFACTURER_MENU = MENUS.register("manufacturer_menu", () -> IForgeMenuType.create(ManufacturerMenu::new));
}
