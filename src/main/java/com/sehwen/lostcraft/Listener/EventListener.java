package com.sehwen.lostcraft.Listener;

import com.sehwen.lostcraft.Skills.*;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class EventListener implements Listener {
	@EventHandler
	public void onSkill(PlayerInteractEvent event) {
		int tick = 20;
		Player player = event.getPlayer();
		double maxHealth = Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getDefaultValue();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
			if (item == null) return;
			if (item.getType() == Material.APPLE) {
				if (player.getHealth() == maxHealth) {
					player.sendMessage("체력이 이미 가득 차있습니다");
				} else {
					player.sendMessage("사과(을)를 사용했습니다 ");
					item.setAmount(item.getAmount() - 1);
					player.getInventory().setItemInMainHand(item);
					player.setHealth(Math.min(player.getHealth() + 6, maxHealth));
				}

			} else if (item.getType() == Material.BLAZE_ROD) {
				Entity entity = player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.FIREBALL);
				entity.setVelocity(player.getLocation().getDirection().multiply(5));
				player.playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
			} else if (item.getType() == Material.NETHERITE_SWORD) {
				if (player.getCooldown(item.getType()) != 0) {
					player.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 1, 1);
				} else {
					player.setCooldown(item.getType(), tick * 2);
					player.sendMessage("가라 가시몬");
					SpikeSkill spikeSkill = new SpikeSkill(player.getLocation());
					spikeSkill.setCloseTick(10);
					spikeSkill.setOwner(player);
					spikeSkill.spawn();
				}
			} else if (item.getType() == Material.IRON_AXE) {
				if (player.getCooldown(item.getType()) != 0) {
					player.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 1, 1);
				} else {
					player.setCooldown(item.getType(), tick * 10);
					player.sendMessage("가라 망치몬");
					SpikeHammerSkill spikehammerskill = new SpikeHammerSkill(player.getLocation());
					spikehammerskill.setCloseTick(2);
					spikehammerskill.setOwner(player);
					spikehammerskill.spawn();
				}
			} else if (item.getType() == Material.IRON_SWORD) {
				if (player.getCooldown(item.getType()) != 0) {
					player.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 1, 1);
				} else {
					player.setCooldown(item.getType(), tick * 5);
					player.sendMessage("지면강타");
					SpikeWideSkill spikewideskill = new SpikeWideSkill(player.getLocation());
					spikewideskill.setCloseTick(17);
					spikewideskill.setOwner(player);
					spikewideskill.spawn();
				}
			} else if (item.getType() == Material.FIRE_CHARGE) {
				if (player.getCooldown(item.getType()) != 0) {
					player.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 1, 1);
				} else {
					player.setCooldown(item.getType(), tick * 60);
					player.sendMessage("드래곤볼!");
					BoomSkill boomSkill = new BoomSkill(player.getLocation().add(0, player.getEyeHeight(), 0));
					boomSkill.setCloseTick(45);
					boomSkill.setOwner(player);
					boomSkill.spawn();
					player.playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
				}
			} else if (item.getType() == Material.DIAMOND_AXE) {
				if (player.getCooldown(item.getType()) != 0) {
					player.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 1, 1);
				} else {
					player.setCooldown(item.getType(), tick * 30);
					player.sendMessage("밥 먹을 시간이네!");
					SharkSkill sharkSkill = new SharkSkill(player.getLocation().add(0, player.getEyeHeight(), 0));
					sharkSkill.setCloseTick(61);
					sharkSkill.setOwner(player);
					sharkSkill.spawn();
				}
			}
		}
	}
}