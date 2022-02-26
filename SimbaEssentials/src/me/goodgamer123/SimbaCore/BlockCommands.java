package me.goodgamer123.SimbaCore;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlockCommands implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().split(" ")[0].contains(":")) {
        	e.setCancelled(true);
        } else if (e.getMessage().startsWith("/music")) {
        	if (e.getMessage().split(" ").length == 1) {
        		e.setCancelled(true);
        		e.getPlayer().sendMessage(ChatColor.RED + "Unknown command. Use /music help.");
        	}
        } else if (e.getMessage().startsWith("/skin")) {
        	if (e.getMessage().split(" ").length == 1) {
        		e.setCancelled(true);
        		e.getPlayer().sendMessage(ChatColor.RED + "Unknown command. Use /music help.");
        	}
        }
    }
	
}
