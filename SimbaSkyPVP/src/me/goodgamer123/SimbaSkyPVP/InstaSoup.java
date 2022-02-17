package me.goodgamer123.SimbaSkyPVP;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class InstaSoup implements Listener {

	@EventHandler
    public void playerInteract(PlayerInteractEvent e) {
		if (e.getPlayer().getItemInHand().getType().equals(Material.MUSHROOM_SOUP) && e.getPlayer().getFoodLevel() != 20) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_PLING, 1, 7);
			new BukkitRunnable() { 
				@Override
				public void run() {
					e.getPlayer().setItemInHand(new ItemStack(Material.AIR));
				}
			}.runTaskLater(MainClass.getPlugin(MainClass.class), 3);
			e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel() + 6);
		}
	}
	
}
