package me.goodgamer123.SimbaSkyPVP;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MainClass extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
    public void playerInteract(PlayerInteractEvent e) {
		new BukkitRunnable() { 
			@Override
			public void run() {
				if (e.getPlayer().getItemInHand().getType().equals(Material.MUSHROOM_SOUP) && e.getPlayer().getFoodLevel() != 20) {
					e.getPlayer().setItemInHand(new ItemStack(Material.AIR));
					e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel() + 6);
				}
			}
		}.runTaskLater(MainClass.getPlugin(MainClass.class), 3);
	}
}


