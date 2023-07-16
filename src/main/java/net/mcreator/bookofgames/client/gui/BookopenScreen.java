package net.mcreator.bookofgames.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.bookofgames.world.inventory.BookopenMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BookopenScreen extends AbstractContainerScreen<BookopenMenu> {
	private final static HashMap<String, Object> guistate = BookopenMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_monsters;
	Button button_chalenges;
	Button button_trapsspecial;
	Button button_traders_events_and_blessings;
	Button button_exclusive_rewards;

	public BookopenScreen(BookopenMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 347;
		this.imageHeight = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("book_of_games:textures/screens/bookopen.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/bookopenpage.png"));
		this.blit(ms, this.leftPos + -38, this.topPos + -92, 0, 0, 420, 420, 420, 420);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/postit.png"));
		this.blit(ms, this.leftPos + -10, this.topPos + 16, 0, 0, 128, 128, 128, 128);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/blooddrops.png"));
		this.blit(ms, this.leftPos + 134, this.topPos + 103, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/postit.png"));
		this.blit(ms, this.leftPos + 186, this.topPos + 20, 0, 0, 128, 128, 128, 128);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/postit.png"));
		this.blit(ms, this.leftPos + 80, this.topPos + 158, 0, 0, 64, 64, 64, 64);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/blooddrops.png"));
		this.blit(ms, this.leftPos + 124, this.topPos + 193, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/blooddrops.png"));
		this.blit(ms, this.leftPos + 122, this.topPos + 188, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/smallpostitblue.png"));
		this.blit(ms, this.leftPos + 316, this.topPos + 29, 0, 0, 64, 16, 64, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/smallpistitred.png"));
		this.blit(ms, this.leftPos + 315, this.topPos + 199, 0, 0, 64, 16, 64, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/smallpostitgreen.png"));
		this.blit(ms, this.leftPos + 315, this.topPos + 161, 0, 0, 64, 16, 64, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/smallpostitorange.png"));
		this.blit(ms, this.leftPos + 316, this.topPos + 72, 0, 0, 64, 16, 64, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("book_of_games:textures/screens/smallpostityellow.png"));
		this.blit(ms, this.leftPos + 316, this.topPos + 113, 0, 0, 64, 16, 64, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_ok_i_need_to_tell_you"), -5, 19, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_that_if_youre_reading"), -5, 29, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_this_so_im_probably_dead"), -11, 37, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_now_that_you_started"), -3, 46, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_reading_this_book_you"), -7, 55, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_must_end_it_and_all_its"), -10, 64, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_chalenges_its_dangers"), -8, 74, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_i_glued_some"), 82, 160, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_post_its"), 81, 169, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_to_help_you"), 82, 179, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_on_this_so"), 81, 189, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_dangerous"), 80, 196, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_adventure"), 80, 204, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_now_you_must_decide"), 191, 31, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_what_to_see_now"), 190, 38, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_just_dont_throw_this"), 189, 47, -3407872);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_book_away_it_is_your"), 190, 56, -3407872);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_only_chance_otherwise"), 190, 69, -3407872);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_they_will_never_stop"), 190, 78, -3407872);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_coming"), 222, 89, -65536);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_caution_and_good_luck"), 190, 101, -10092544);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_may_the_gods_be_with_you"), 188, 111, -39424);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_i_have_written_some_tips"), -8, 85, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_on_post_its_and_glued"), -9, 95, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_over_the_pages_of_the"), -10, 105, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_book_sorry_but_i_think"), -9, 116, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_you_arent_going_to_read"), -8, 123, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_the_story"), -10, 131, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.book_of_games.bookopen.label_you_are_the_story"), 1, 146, -65536);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_monsters = new Button(this.leftPos + 315, this.topPos + 81, 67, 20, Component.translatable("gui.book_of_games.bookopen.button_monsters"), e -> {
		});
		guistate.put("button:button_monsters", button_monsters);
		this.addRenderableWidget(button_monsters);
		button_chalenges = new Button(this.leftPos + 312, this.topPos + 39, 72, 20, Component.translatable("gui.book_of_games.bookopen.button_chalenges"), e -> {
		});
		guistate.put("button:button_chalenges", button_chalenges);
		this.addRenderableWidget(button_chalenges);
		button_trapsspecial = new Button(this.leftPos + 289, this.topPos + 124, 93, 20, Component.translatable("gui.book_of_games.bookopen.button_trapsspecial"), e -> {
		});
		guistate.put("button:button_trapsspecial", button_trapsspecial);
		this.addRenderableWidget(button_trapsspecial);
		button_traders_events_and_blessings = new Button(this.leftPos + 206, this.topPos + 172, 176, 20, Component.translatable("gui.book_of_games.bookopen.button_traders_events_and_blessings"), e -> {
		});
		guistate.put("button:button_traders_events_and_blessings", button_traders_events_and_blessings);
		this.addRenderableWidget(button_traders_events_and_blessings);
		button_exclusive_rewards = new Button(this.leftPos + 265, this.topPos + 208, 114, 20, Component.translatable("gui.book_of_games.bookopen.button_exclusive_rewards"), e -> {
		});
		guistate.put("button:button_exclusive_rewards", button_exclusive_rewards);
		this.addRenderableWidget(button_exclusive_rewards);
	}
}
