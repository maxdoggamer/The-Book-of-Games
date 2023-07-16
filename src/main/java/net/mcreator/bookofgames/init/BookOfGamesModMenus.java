
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bookofgames.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.bookofgames.world.inventory.BookopenMenu;
import net.mcreator.bookofgames.BookOfGamesMod;

public class BookOfGamesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BookOfGamesMod.MODID);
	public static final RegistryObject<MenuType<BookopenMenu>> BOOKOPEN = REGISTRY.register("bookopen", () -> IForgeMenuType.create(BookopenMenu::new));
}
