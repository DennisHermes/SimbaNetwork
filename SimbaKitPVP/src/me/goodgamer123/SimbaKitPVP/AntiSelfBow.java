package me.goodgamer123.SimbaKitPVP;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AntiSelfBow implements Listener {
	
	@EventHandler
	public void arrowHitEvent(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow) {
			if (((Arrow) (e.getDamager())).getShooter() instanceof Player) {
				if (e.getEntity() instanceof Player) {
					if (((Arrow) (e.getDamager())).getShooter() == e.getEntity()) {
						e.setCancelled(true);
						((Player) ((Arrow) (e.getDamager())).getShooter()).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6PvP&f>> &7Ne mozes pogoditi samog sebe niti ces farmati killove :)"));
					}
				}
			}
		}
	}
	
}
