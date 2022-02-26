package me.goodgamer123.SimbaSkyPVP;

import org.bukkit.ChatColor;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessages implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void sendMessageOnJoin(PlayerDeathEvent e) {
		if (e.getEntity().getLastDamageCause().getCause().equals(DamageCause.VOID)) {
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', "&6Smrti&f>> &7" + e.getEntity().getName() + " &6ispao je sa SkyPvP mape."));
		} else if (((EntityDamageByEntityEvent) e.getEntity().getLastDamageCause()).getDamager() instanceof Egg) {
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', "&6Smrti&f>> &7" + ((Player) ((Projectile) ((EntityDamageByEntityEvent) e.getEntity().getLastDamageCause()).getDamager()).getShooter()).getName() + " &6iznabadao je &7" + e.getEntity().getName() + " &6sa Ekslopzivnim jajima!"));
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageEvent e) {
		Entity p = e.getEntity();
		if (p instanceof Player) {
			if (e.getCause() == DamageCause.VOID) {
				e.setDamage(999999D);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onProjectile(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getDamager() instanceof Snowball) {
				e.setDamage(3.5);
			} else if (e.getDamager() instanceof Egg) {
				e.setDamage(60);
			}
		}
	}
	
}
