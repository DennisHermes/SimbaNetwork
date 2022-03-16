package me.goodgamer123.SimbaMainHub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener {

	private HashMap<UUID, Long> jumpTime = new HashMap<>();
	private HashMap<UUID, Long> cooldown = new HashMap<>();
	
	private ArrayList<UUID> nofinished = new ArrayList<>();
	
	@EventHandler
	private void onPlayerToggleFlight(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
	    UUID uuid = p.getUniqueId();
	    
    	if (p.getGameMode() == GameMode.CREATIVE) return; 
    	Location loc = p.getLocation();
		e.setCancelled(true);
		p.setFlying(false);
		
		long current = System.currentTimeMillis();
		if (cooldown.containsKey(uuid)) {
			long secs = (current - cooldown.get(uuid).longValue()) / 1000L;
			if (secs < 3) return; 
			cooldown.remove(uuid);
		} else {
			cooldown.put(uuid, Long.valueOf(current));
		}
		p.setVelocity(p.getLocation().getDirection().multiply(1.0D).setY(1));
		
		nofinished.add(uuid);
		loc.getWorld().playSound(loc, Sound.BAT_HURT, 5.0F, 0.0F);
		jumpTime.put(uuid, Long.valueOf(System.currentTimeMillis()));
		
		MainClass.getPlugin(MainClass.class).getServer().getScheduler().runTaskLater(MainClass.getPlugin(MainClass.class), new Runnable() {
			public void run() {
				if (p != null && p.isFlying()) {
					DoubleJump.this.nofinished.remove(uuid);
				} 
			}
		},  20L);
	}
	
}
