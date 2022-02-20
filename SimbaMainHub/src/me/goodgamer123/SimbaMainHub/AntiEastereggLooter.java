package me.goodgamer123.SimbaMainHub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AntiEastereggLooter implements Listener {
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void inventoryClick(InventoryClickEvent e) {
		if (!e.getWhoClicked().isOp()) e.setCancelled(true);
	}
	
}
