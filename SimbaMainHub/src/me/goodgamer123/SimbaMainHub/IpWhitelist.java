package me.goodgamer123.SimbaMainHub;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class IpWhitelist implements Listener {

	@EventHandler
	public void OnJoin(PlayerJoinEvent e) {
		FileConfiguration config = MainClass.getPlugin(MainClass.class).getConfig();
		if (config.getBoolean("IpWhitelist")) {
			if (config.getStringList("WhitelistedIps") != null) {
				if (!config.getStringList("WhitelistedIps").contains(e.getPlayer().getAddress().getHostString())) {
					e.getPlayer().kickPlayer("You are not whitelisted on this server!");
				}
			}
		}
	}
	
	
}
