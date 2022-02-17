package me.goodgamer123.SimbaSkyPVP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new InstaSoup(), this);
		getServer().getPluginManager().registerEvents(new DisableBuilding(), this);
		getServer().getPluginManager().registerEvents(new ProjectileTrails(), this);
		getServer().getPluginManager().registerEvents(new DeathEffect(), this);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.getHealth() <= 4) {
						p.getWorld().spigot().playEffect(p.getLocation().add(0, 1, 0), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(1, 1, 0), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(0, 1, 0.5), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(0, 2, 1), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(1, 1, 0), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(1, 1, 1), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(1, 2, 1), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(0, 1, 0), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(0.5, 1, 0), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(0, 1, -1), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(0, 2, -1), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(-0.5, 1, 0), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(-1, 1, 0.5), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
						p.getWorld().spigot().playEffect(p.getLocation().add(0.5, 2, -1), Effect.COLOURED_DUST, 0, 1, 255, 0, 0, 1, 0, 64);
					}
				}
			}
		}, 20L, 20L);
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
				p.sendMessage(ChatColor.GREEN + "Buidling is now disabled!");
			} else {
				DisableBuilding.building.remove(p);
				p.sendMessage(ChatColor.GREEN + "Buidling is now enabled!");
			}
		}
		
		return false;
	}
}


