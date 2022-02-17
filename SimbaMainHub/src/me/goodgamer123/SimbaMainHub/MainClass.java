package me.goodgamer123.SimbaMainHub;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MainClass extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void OnJoin(PlayerJoinEvent e) {

		new BukkitRunnable() { 
			@Override
			public void run() {
		    	Vector viewDir = e.getPlayer().getLocation().getDirection().normalize();
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.WITCH_MAGIC, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FIREWORKS_SPARK, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.MAGIC_CRIT, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.WITCH_MAGIC, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FIREWORKS_SPARK, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.MAGIC_CRIT, null);
			}
		}.runTaskLater(MainClass.getPlugin(MainClass.class), 5);
		new BukkitRunnable() { 
			@Override
			public void run() {
		    	Vector viewDir = e.getPlayer().getLocation().getDirection().normalize();
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.WITCH_MAGIC, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FIREWORKS_SPARK, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.MAGIC_CRIT, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.WITCH_MAGIC, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FIREWORKS_SPARK, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.MAGIC_CRIT, null);
			}
		}.runTaskLater(MainClass.getPlugin(MainClass.class), 10);
		new BukkitRunnable() { 
			@Override
			public void run() {
		    	Vector viewDir = e.getPlayer().getLocation().getDirection().normalize();
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.WITCH_MAGIC, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FIREWORKS_SPARK, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.MAGIC_CRIT, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.WITCH_MAGIC, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FIREWORKS_SPARK, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.MAGIC_CRIT, null);
			}
		}.runTaskLater(MainClass.getPlugin(MainClass.class), 15);
		new BukkitRunnable() { 
			@Override
			public void run() {
		    	Vector viewDir = e.getPlayer().getLocation().getDirection().normalize();
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.WITCH_MAGIC, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FIREWORKS_SPARK, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.MAGIC_CRIT, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.WITCH_MAGIC, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FIREWORKS_SPARK, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		    	e.getPlayer().playEffect(e.getPlayer().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.MAGIC_CRIT, null);
			}
		}.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
	}
}


