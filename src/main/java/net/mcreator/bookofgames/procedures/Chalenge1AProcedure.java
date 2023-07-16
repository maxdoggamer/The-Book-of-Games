package net.mcreator.bookofgames.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.bookofgames.network.BookOfGamesModVariables;
import net.mcreator.bookofgames.BookOfGamesMod;

public class Chalenge1AProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "A";
			entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ChalengeType = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("You start to fell sick..."), true);
		if (entity instanceof Player _player)
			_player.getFoodData().setSaturation(0);
		BookOfGamesMod.queueServerWork(600, () -> {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 6000, 1, false, false));
			BookOfGamesMod.queueServerWork(600, () -> {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4800, 1, false, false));
				BookOfGamesMod.queueServerWork(600, () -> {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 3600, 1, false, false));
					BookOfGamesMod.queueServerWork(600, () -> {
						if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 2400, 1, false, false));
						BookOfGamesMod.queueServerWork(600, () -> {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1200, 1, false, false));
							BookOfGamesMod.queueServerWork(1100, () -> {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.WEAKNESS) : false) && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false)
										&& (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.HUNGER) : false) && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.CONFUSION) : false)
										&& (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.BLINDNESS) : false)) {
									{
										double _setval = 2;
										entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Chalenge = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal("You start to fell better"), true);
									{
										String _setval = "";
										entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChalengeType = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal("Don't try drinking milk, it will get worse"), true);
									BookOfGamesMod.queueServerWork(600, () -> {
										if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 6000, 3, false, false));
										BookOfGamesMod.queueServerWork(600, () -> {
											if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4800, 3, false, false));
											BookOfGamesMod.queueServerWork(600, () -> {
												if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 3600, 3, false, false));
												BookOfGamesMod.queueServerWork(600, () -> {
													if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 2400, 3, false, false));
													BookOfGamesMod.queueServerWork(600, () -> {
														if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1200, 3, false, false));
														BookOfGamesMod.queueServerWork(1100, () -> {
															{
																double _setval = 2;
																entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.Chalenge = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															if (entity instanceof Player _player && !_player.level.isClientSide())
																_player.displayClientMessage(Component.literal("You start to fell better"), true);
															{
																String _setval = "";
																entity.getCapability(BookOfGamesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.ChalengeType = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
														});
													});
												});
											});
										});
									});
								}
							});
						});
					});
				});
			});
		});
	}
}
