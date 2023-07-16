package net.mcreator.bookofgames.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.bookofgames.network.BookOfGamesModVariables;
import net.mcreator.bookofgames.init.BookOfGamesModItems;

public class BookOfOddsRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(BookOfGamesModItems.BOOK_OF_GAMES.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("YOU HAVE SEALED YOUR DESTINY, FROM HERE YOU CANT GO BACK"), true);
		{
			boolean _setval = true;
			entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BookOpened = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(BookOfGamesModItems.BOOK_OF_GAMES_OPEN.get());
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
