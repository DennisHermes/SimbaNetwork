package me.goodgamer123.SimbaCore;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlockNamespacedCommands implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().split(" ")[0].contains(":")) {
        	e.setCancelled(true);
        }
    }
	
}
