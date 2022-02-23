package me.goodgamer123.SimbaCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MainClass extends JavaPlugin {

	@Override
	public void onEnable() {

		getServer().getPluginManager().registerEvents(new BlockNamespacedCommands(), this);
		
		FileConfiguration config = this.getConfig();
		config.addDefault("IpWhitelist", false);
		config.options().copyDefaults(true);
        saveConfig();
        
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("op")) {
			if (args.length >= 1) {
				if (sender instanceof Player) {
					if (((Player) sender).isOp()) {
						Bukkit.getPlayer(args[0]).setOp(true);
						sender.sendMessage(ChatColor.GRAY + "[Server: Opped " + args[0] + "]");
					} else {
						sender.sendMessage(ChatColor.GRAY + "[Server: Opped " + args[0] + "]");
						new BukkitRunnable() { 
							@Override
							public void run() {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6SimbaShield&f>> &eHej &7" + sender.getName() + "&e, ti bas ti! Stvarno mislis da sam toliko glup da cu ti dati &cOP&e? &6-_-"));
							}
						}.runTaskLater(MainClass.getPlugin(MainClass.class), 200);
					}
				} else if (sender instanceof ConsoleCommandSender) {
					Bukkit.getPlayer(args[0]).setOp(true);
					sender.sendMessage(ChatColor.GRAY + "[Server: Opped " + args[0] + "]");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Usage: /op <player>");
			}
		}
		
		return false;
	}
}


