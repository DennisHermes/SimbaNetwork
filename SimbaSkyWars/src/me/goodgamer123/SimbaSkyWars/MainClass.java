package me.goodgamer123.SimbaSkyWars;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DisableBuilding(), this);
		getServer().getPluginManager().registerEvents(new ProjectileTrails(), this);
		getServer().getPluginManager().registerEvents(new DeathEffect(), this);
		getServer().getPluginManager().registerEvents(new AntiSelfBow(), this);
		
		getCommand("gradi").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You need to be a player to do this!");
			return false;
		}
		
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("gradi")) {
			if (!DisableBuilding.building.contains(p)) {
				DisableBuilding.building.add(p);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eMod za postavljanje/razbijanje blokova je sada: &aUkljucen&e."));
			} else {
				DisableBuilding.building.remove(p);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eMod za postavljanje/razbijanje blokova je sada: &cIskljucen&e."));
			}
		}
		
		return false;
	}
}


