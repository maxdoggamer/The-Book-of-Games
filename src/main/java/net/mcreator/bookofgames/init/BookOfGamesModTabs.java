
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bookofgames.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class BookOfGamesModTabs {
	public static CreativeModeTab TAB_THE_BOOK_OF_GAMES;

	public static void load() {
		TAB_THE_BOOK_OF_GAMES = new CreativeModeTab("tabthe_book_of_games") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(BookOfGamesModItems.BOOK_OF_GAMES.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
