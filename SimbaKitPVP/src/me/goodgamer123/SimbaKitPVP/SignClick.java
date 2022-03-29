package me.goodgamer123.SimbaKitPVP;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class SignClick implements Listener {

	List<Player> signclick = new ArrayList<Player>();
	
	@EventHandler
	public void OnSignClick(PlayerInteractEvent e) {
		if (e.getClickedBlock() == null) return;
        if (e.getClickedBlock().getState() instanceof Sign) {
        	if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
        		if (!signclick.contains(e.getPlayer())) {
	        		e.getPlayer().playSound(e.getClickedBlock().getLocation(), Sound.NOTE_BASS_GUITAR, 5, 1);
					e.getPlayer().getWorld().spigot().playEffect(e.getClickedBlock().getLocation().add(0.5, 0.5, 0.5), Effect.WITCH_MAGIC, 0, 0, 0, 0, 0, 1, 50, 1);
					signclick.add(e.getPlayer());
					new BukkitRunnable() { 
						@Override
						public void run() {
							signclick.remove(e.getPlayer());
						}
					}.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
        		}
        	}
        }
	}

}
