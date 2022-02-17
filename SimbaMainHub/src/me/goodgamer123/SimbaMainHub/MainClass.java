package me.goodgamer123.SimbaMainHub;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MainClass extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new DisableBuilding(), this);
	}
	
	@EventHandler
	public void OnJoin(PlayerJoinEvent e) {

		new BukkitRunnable() { 
			@Override
			public void run() {
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
				e.getPlayer().getWorld().spigot().playEffect(e.getPlayer().getLocation().add(0, 1, 0), Effect.WITCH_MAGIC, 0, 0, 0, 0, 0, 1, 10, 1);
				e.getPlayer().getWorld().spigot().playEffect(e.getPlayer().getLocation().add(0, 1, 0), Effect.FIREWORKS_SPARK, 0, 0, 0, 0, 0, 1, 10, 1);
				e.getPlayer().getWorld().spigot().playEffect(e.getPlayer().getLocation().add(0, 1, 0), Effect.FLAME, 0, 0, 0, 0, 0, 1, 10, 1);
				e.getPlayer().getWorld().spigot().playEffect(e.getPlayer().getLocation().add(0, 1, 0), Effect.MAGIC_CRIT, 0, 0, 0, 0, 0, 1, 10, 1);
			}
		}.runTaskLater(MainClass.getPlugin(MainClass.class), 10);
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


