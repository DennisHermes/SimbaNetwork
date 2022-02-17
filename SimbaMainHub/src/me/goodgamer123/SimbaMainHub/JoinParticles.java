package me.goodgamer123.SimbaMainHub;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinParticles implements Listener {

	@EventHandler
	public void OnJoin(PlayerJoinEvent e) {
		
		new BukkitRunnable() { 
			@Override
			public void run() {
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
				e.getPlayer().getWorld().spigot().playEffect(e.getPlayer().getLocation().add(0, 1, 0), Effect.WITCH_MAGIC, 0, 0, 0, 0, 0, 1, 10, 1);
				e.getPlayer().getWorld().spigot().playEffect(e.getPlayer().getLocation().add(0, 1, 0), Effect.FIREWORKS_SPARK, 0, 0, 0, 0, 0, 1, 10, 1);
				e.getPlayer().getWorld().spigot().playEffect(e.getPlayer().getLocation().add(0, 1, 0), Effect.FLAME, 0, 0, 0, 0, 0, 1, 10, 1);
				e.getPlayer().getWorld().spigot().playEffect(e.getPlayer().getLocation().add(0, 1, 0), Effect.MAGIC_CRIT, 0, 0, 0, 0, 0, 1, 10, 1);
			}
		}.runTaskLater(MainClass.getPlugin(MainClass.class), 10);
	}
	
}
