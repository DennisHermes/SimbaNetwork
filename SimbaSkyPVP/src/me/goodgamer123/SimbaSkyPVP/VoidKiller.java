package me.goodgamer123.SimbaSkyPVP;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class VoidKiller implements Listener {

	ArrayList<String> list = new ArrayList<String>();
	
	@EventHandler
	public void sendMessageOnJoin(PlayerJoinEvent e) {
		new BukkitRunnable() { 
			@Override
			public void run() {
				if (list.contains(e.getPlayer().getName())) {
					e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6SimbaAntiCheat&f>> &cIzasao si sa servera dok si padao u Void i sada si umro!"));
					list.remove(e.getPlayer().getName());
				}
			}
		}.runTaskLater(MainClass.getPlugin(MainClass.class), 5);
	}
	
	@EventHandler
	public void killOnVoid(PlayerQuitEvent e) {
		boolean voidB = true;
		if (e.getPlayer().getLocation().getY() > 0) {
			for (int i = e.getPlayer().getLocation().getBlockY(); i > 0; i--) {
				if (!(new Location(e.getPlayer().getWorld(), e.getPlayer().getLocation().getBlockX(), i, e.getPlayer().getLocation().getBlockZ())).getBlock().getType().equals(Material.AIR)) {
					voidB = false;
					break;
				}
			}
		}
		if (voidB && !e.getPlayer().isOp()) {
			e.getPlayer().setHealth(0);
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6SimbaAntiCheat&f>> &c" + e.getPlayer().getName() + " &7je izasao sa servera dok je padao u Void i sada ce biti ubijen!"));
			list.add(e.getPlayer().getName());
		}
	}
	
	@EventHandler
	public void consumeEvent(PlayerItemConsumeEvent e) {
		if (e.getItem().getType() == Material.GOLDEN_APPLE && e.getItem().getDurability() == 1) {
			boolean voidB = true;
			if (e.getPlayer().getLocation().getY() > 0) {
				for (int i = e.getPlayer().getLocation().getBlockY(); i > 0; i--) {
					if (!(new Location(e.getPlayer().getWorld(), e.getPlayer().getLocation().getBlockX(), i, e.getPlayer().getLocation().getBlockZ())).getBlock().getType().equals(Material.AIR)) {
						voidB = false;
						break;
					}
				}
			}
			if (voidB) {
				e.setCancelled(true);
			}
		}
	}
	
}
