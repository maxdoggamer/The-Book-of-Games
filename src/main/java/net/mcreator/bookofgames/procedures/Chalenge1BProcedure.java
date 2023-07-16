package net.mcreator.bookofgames.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.bookofgames.network.BookOfGamesModVariables;
import net.mcreator.bookofgames.BookOfGamesMod;

public class Chalenge1BProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "B";
			entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ChalengeType = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("Don't explode, \"HERO\""), true);
		BookOfGamesMod.queueServerWork(100, () -> {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Try killing 10 of these hahaha"), true);
			while ((entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BookOfGamesModVariables.PlayerVariables())).progress < 10) {
				BookOfGamesMod.queueServerWork(200, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new Creeper(EntityType.CREEPER, _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new Creeper(EntityType.CREEPER, _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new Creeper(EntityType.CREEPER, _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				});
			}
			if ((entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BookOfGamesModVariables.PlayerVariables())).progress > 9) {
				{
					String _setval = "";
					entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChalengeType = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 2;
					entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Chalenge = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.progress = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		});
	}
}
