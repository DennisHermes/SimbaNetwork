package me.goodgamer123.SimbaKitPVP;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class ProjectileTrails implements Listener {

private Map<Projectile, BukkitTask> tasks = new HashMap<>();
	
	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent e) {
	    if (e.getEntity().getShooter() instanceof Player ) {
	    	if (e.getEntity() instanceof Egg) {
		        tasks.put(e.getEntity(), new BukkitRunnable() {
		            @Override
		            public void run() {
		            	Vector viewDir = ((Player) e.getEntity().getShooter()).getLocation().getDirection().normalize();
		            	((Player) e.getEntity().getShooter()).playEffect(e.getEntity().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.COLOURED_DUST, null);
		            	((Player) e.getEntity().getShooter()).playEffect(e.getEntity().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.COLOURED_DUST, null);
		            	((Player) e.getEntity().getShooter()).playEffect(e.getEntity().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.COLOURED_DUST, null);
		            }
		        }.runTaskTimer(MainClass.getPlugin(MainClass.class), 0L, 1L));
		        for (Entity p : e.getEntity().getNearbyEntities(5, 5, 5)) {
	    			if (p instanceof Player) ((Player) p).playSound(p.getLocation(), Sound.NOTE_STICKS, 5, 1);
	    		}
	    	} else if (e.getEntity() instanceof Arrow) {
	    		tasks.put(e.getEntity(), new BukkitRunnable() {
		            @Override
		            public void run() {
		            	Vector viewDir = ((Player) e.getEntity().getShooter()).getLocation().getDirection().normalize();
		            	((Player) e.getEntity().getShooter()).playEffect(e.getEntity().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		            	((Player) e.getEntity().getShooter()).playEffect(e.getEntity().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		            	((Player) e.getEntity().getShooter()).playEffect(e.getEntity().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		            	((Player) e.getEntity().getShooter()).playEffect(e.getEntity().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.FLAME, null);
		            }
		        }.runTaskTimer(MainClass.getPlugin(MainClass.class), 0L, 1L));
	    	}
	    }
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
	    if (e.getEntity().getShooter() instanceof Player) {
	    	if (e.getEntity() instanceof Egg) {
		        BukkitTask task = tasks.get(e.getEntity());
		        if (task != null) {
		            task.cancel();
		            tasks.remove(e.getEntity());
	            	Vector viewDir = ((Player) e.getEntity().getShooter()).getLocation().getDirection().normalize();
	            	((Player) e.getEntity().getShooter()).playEffect(e.getEntity().getLocation().clone().add(viewDir.clone().multiply(1D)), Effect.EXPLOSION_LARGE, null);
	            	for (Entity p : e.getEntity().getNearbyEntities(5, 5, 5)) {
	        			if (p instanceof Player) ((Player) p).playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
	        		}
		        }
	    	} else if (e.getEntity() instanceof Arrow) {
	    		BukkitTask task = tasks.get(e.getEntity());
		        if (task != null) {
		            task.cancel();
		            tasks.remove(e.getEntity());
		        }
	    	}
	    }
	}
	
}
