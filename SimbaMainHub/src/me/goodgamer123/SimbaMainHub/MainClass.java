package me.goodgamer123.SimbaMainHub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new DisableBuilding(), this);
		getServer().getPluginManager().registerEvents(new IpWhitelist(), this);
		getServer().getPluginManager().registerEvents(new JoinParticles(), this);
		
		FileConfiguration config = this.getConfig();
		config.addDefault("IpWhitelist", false);
		config.options().copyDefaults(true);
        saveConfig();
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ipwhitelist")) {

			FileConfiguration config = this.getConfig();
			
			if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("enable")) {
					config.set("IpWhitelist", true);
					saveConfig();
					sender.sendMessage(ChatColor.GREEN + "Ip whitelist is now enabled!");
				} else if (args[0].equalsIgnoreCase("disable")) {
					config.set("IpWhitelist", false);
					saveConfig();
					sender.sendMessage(ChatColor.GREEN + "Ip whitelist is now disabled!");
				} else if (args[0].equalsIgnoreCase("add")) {
					if (args.length >= 2) {
						if (Bukkit.getOfflinePlayer(args[1]).isOnline()) {
							if (config.getStringList("WhitelistedIps") != null) {
								if (!config.getStringList("WhitelistedIps").contains(Bukkit.getPlayer(args[1]).getAddress().getHostString())) {
									List<String> list = config.getStringList("WhitelistedIps");
									list.add(Bukkit.getPlayer(args[1]).getAddress().getHostString());
									config.set("WhitelistedIps", list);
									saveConfig();
									sender.sendMessage(ChatColor.GREEN + "Succesfully added " + args[1] + " to the whitelist!");
								} else {
									sender.sendMessage(ChatColor.RED + args[1] + " is allready added to the whitelist.");
								}
							} else {
								List<String> list = new ArrayList<String>();
								list.add(Bukkit.getPlayer(args[1]).getAddress().getHostString());
								config.set("WhitelistedIps", list);
								saveConfig();
								sender.sendMessage(ChatColor.GREEN + "Succesfully added " + args[1] + " to the whitelist!");
							}
						} else {
							sender.sendMessage(ChatColor.RED + "Player needs to be online to get IP address!");
						}
					}
				} else if (args[0].equalsIgnoreCase("remove")) {
					if (args.length >= 2) {
						if (Bukkit.getOfflinePlayer(args[1]).isOnline()) {
							if (config.getStringList("WhitelistedIps") != null) {
								List<String> list = config.getStringList("WhitelistedIps");
								list.remove(Bukkit.getPlayer(args[1]).getAddress().getHostString());
								config.set("WhitelistedIps", list);
								saveConfig();
								sender.sendMessage(ChatColor.GREEN + "Succesfully removed " + args[1] + " from the whitelist!");
							} else {
								List<String> list = new ArrayList<String>();
								list.remove(Bukkit.getPlayer(args[1]).getAddress().getHostString());
								config.set("WhitelistedIps", list);
								saveConfig();
								sender.sendMessage(ChatColor.GREEN + "Succesfully removed " + args[1] + " from the whitelist!");
							}
						} else {
							sender.sendMessage(ChatColor.RED + "Player needs to be online to get IP address!");
						}
					}
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Use /ipwhitelist [enable | disable | add | remove]!");
			}
			
			return false;
		}
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("You need to be a player to do this!");
			return false;
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("togglebuilding")) {
			if (!DisableBuilding.building.contains(p)) {
				DisableBuilding.building.add(p);
				p.sendMessage(ChatColor.GREEN + "Buidling is now disabled!");
			} else {
				DisableBuilding.building.remove(p);
				p.sendMessage(ChatColor.GREEN + "Buidling is now enabled!");
			}
		}
		
		return false;
	}
}


