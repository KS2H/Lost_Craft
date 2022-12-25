package com.sehwen.lostcraft.Listener;

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
	public void onPotion(PlayerInteractEvent event){
		Player player = event.getPlayer();
		double maxHealth = Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getDefaultValue();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		if(action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR){
			if(item == null) return;
			if(item.getType() == Material.APPLE){
				if(player.getHealth() == maxHealth){
					player.sendMessage("체력이 이미 가득 차있습니다");
				}else{
					player.sendMessage("사과(을)를 사용했습니다 ");
					item.setAmount(item.getAmount() - 1);
					player.getInventory().setItemInMainHand(item);
					if(player.getHealth() + 6 >= maxHealth){
						player.setHealth(maxHealth);
					}else{
						player.setHealth(player.getHealth() + 6);
					}
				}

			}

		} else if (item.getType() == Material.BLAZE_ROD) {
			Entity entity = player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.FIREBALL);
			entity.setVelocity(player.getLocation().getDirection().multiply(5));
			player.playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH,1.0f, 1.0f);
		}
	}
}
