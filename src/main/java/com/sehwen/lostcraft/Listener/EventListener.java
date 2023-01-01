package com.sehwen.lostcraft.Listener;

import com.sehwen.lostcraft.Skills.SpikeSkill;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class EventListener implements Listener {
	@EventHandler
	public void onSkill(PlayerInteractEvent event) {
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
					if (player.getHealth() + 6 >= maxHealth) {
						player.setHealth(maxHealth);
					} else {
						player.setHealth(player.getHealth() + 6);
					}
				}

			}
			else if (item.getType() == Material.BLAZE_ROD) {
				Entity entity = player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.FIREBALL);
				entity.setVelocity(player.getLocation().getDirection().multiply(5));
				player.playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1.0f, 1.0f);
			}
			else if (item.getType() == Material.NETHERITE_SWORD) {
				player.sendMessage("가라 가시몬");
				SpikeSkill spikeSkill = new SpikeSkill(player.getLocation());
				spikeSkill.setCloseTimer(10);
				spikeSkill.setOwner(player);
				spikeSkill.spawn();
			}
		}
	}

	@EventHandler
	public void onChat(PlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		if (message.equals("나에게 힘을 주어라 블레이즈!")) {
			ItemStack item = new ItemStack(Material.BLAZE_ROD);
			ItemMeta itemMeta = item.getItemMeta();
			itemMeta.displayName(Component.text("쓸데없이 큰 지팡이"));
			item.setItemMeta(itemMeta);
			player.getInventory().addItem(item);
			player.sendMessage("허락한다");
		}

	}
}
