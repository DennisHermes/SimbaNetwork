package me.goodgamer123.SimbaFactions;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin implements Listener {

	static HashMap<Player, Boolean> building = new HashMap<Player, Boolean>();
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);

		getCommand("togglebuilding").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You need to be a player to do this!");
			return false;
		}
		
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("togglebuilding")) {
			if (!building.containsKey(p)) {
				building.put(p, true);
				p.sendMessage(ChatColor.GREEN + "Buidling is now enabled!");
			} else {
				if (building.get(p)) {
					building.put(p, false);
					p.sendMessage(ChatColor.GREEN + "Buidling is now disabled!");
				} else {
					building.put(p, true);
					p.sendMessage(ChatColor.GREEN + "Buidling is now enabled!");
				}
			}
		}
		
		return false;
	}
	
	@EventHandler
	public void blockPlace(BlockPlaceEvent e) {
		if (e.getPlayer().isOp()) {
			if (!building.containsKey(e.getPlayer())) e.setCancelled(true);
			else if (!building.get(e.getPlayer())) e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent e) {
		if (e.getPlayer().isOp()) {
			if (!building.containsKey(e.getPlayer())) e.setCancelled(true);
			else if (!building.get(e.getPlayer())) e.setCancelled(true);
		}
	}
	
}


