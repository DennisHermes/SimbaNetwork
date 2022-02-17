package me.goodgamer123.SimbaCreative;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DisableBuilding(), this);

		getCommand("togglebuilding").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You need to be a player to do this!");
			return false;
		}
		
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("togglebuilding")) {
			if (!DisableBuilding.building.contains(p)) {
				DisableBuilding.building.add(p);
				p.sendMessage(ChatColor.GREEN + "Buidling is now enabled!");
			} else {
				DisableBuilding.building.remove(p);
				p.sendMessage(ChatColor.GREEN + "Buidling is now disabled!");
			}
		}
		
		return false;
	}
	
}


