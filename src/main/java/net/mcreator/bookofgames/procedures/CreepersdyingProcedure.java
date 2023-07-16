package net.mcreator.bookofgames.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Entity;

import net.mcreator.bookofgames.network.BookOfGamesModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CreepersdyingProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (((entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BookOfGamesModVariables.PlayerVariables())).ChalengeType).equals("B")) {
			if (sourceentity instanceof Player) {
				if (entity instanceof Creeper) {
					{
						double _setval = (entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BookOfGamesModVariables.PlayerVariables())).progress + 1;
						entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.progress = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
