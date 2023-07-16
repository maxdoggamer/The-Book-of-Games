
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bookofgames.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.bookofgames.item.BookOfOddsItem;
import net.mcreator.bookofgames.item.BookOfGamesOpenItem;
import net.mcreator.bookofgames.BookOfGamesMod;

public class BookOfGamesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BookOfGamesMod.MODID);
	public static final RegistryObject<Item> BOOK_OF_GAMES = REGISTRY.register("book_of_games", () -> new BookOfOddsItem());
	public static final RegistryObject<Item> BOOK_OF_GAMES_OPEN = REGISTRY.register("book_of_games_open", () -> new BookOfGamesOpenItem());
}
