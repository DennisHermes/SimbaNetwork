package me.goodgamer123.SimbaMainHub;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class LobbyPreferences implements CommandExecutor, Listener {

	@EventHandler
    public void Damage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			File prefFile = new File(MainClass.getPlugin(MainClass.class).getDataFolder() + "/preferences.yml");
			FileConfiguration prefs = YamlConfiguration.loadConfiguration(prefFile);
			if (prefs.getBoolean(e.getEntity().getUniqueId().toString() + ".Anti knockback")) {
				Vector vec = new Vector();
				Bukkit.getScheduler().runTaskLater(MainClass.getPlugin(MainClass.class), () -> e.getEntity().setVelocity(vec), 1l);
			}
		}
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You need to be a player to do this!");
			return false;
		}
		
		Player p = (Player) sender;
		
		File prefFile = new File(MainClass.getPlugin(MainClass.class).getDataFolder() + "/preferences.yml");
		FileConfiguration prefs = YamlConfiguration.loadConfiguration(prefFile);
		
		if (cmd.getName().equalsIgnoreCase("togglespeed")) {
			if (prefs.getBoolean(p.getUniqueId().toString() + ".Speed")) {
				p.removePotionEffect(PotionEffectType.SPEED);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &cUgasio &6si svoju brzinu na Hubu, od sada ces opet biti spor kao puz :)"));
				prefs.set(p.getUniqueId().toString() + ".Speed", false);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &aUkljucio &6si svoju brzinu na Hubu, od sada si brz kao munja :)"));
				prefs.set(p.getUniqueId().toString() + ".Speed", true);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		} else if (cmd.getName().equalsIgnoreCase("toggleplayers")) {
			if (prefs.getBoolean(p.getUniqueId().toString() + ".Hide players")) {
				for (Player p1 : Bukkit.getOnlinePlayers()) {
					p.showPlayer(p1);
				}
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &aOmogucio &6si prikaz igraca oko sebe, od sada ces ih opet vidjeti!"));
				prefs.set(p.getUniqueId().toString() + ".Hide players", false);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				for (Player p1 : Bukkit.getOnlinePlayers()) {
					p.hidePlayer(p1);
				}
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &cSakrio &6si prikaz igraca oko sebe, od sada ih neces vidjeti!"));
				prefs.set(p.getUniqueId().toString() + ".Hide players", true);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		else if (cmd.getName().equalsIgnoreCase("togglesounds")) {
			if (prefs.getBoolean(p.getUniqueId().toString() + ".Mute sound")) {
				
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &cUgasio &6si zvukove na Hubu od sada ih neces cuti!"));
				prefs.set(p.getUniqueId().toString() + ".Mute sound", false);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &aUkljucio &6si zvukove na Hubu od sada ces ih opet cuti!"));
				prefs.set(p.getUniqueId().toString() + ".Mute sound", true);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		else if (cmd.getName().equalsIgnoreCase("togglekb")) {
			if (prefs.getBoolean(p.getUniqueId().toString() + ".Anti knockback")) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &cUgasio &6si knockback na Hubu od sada te gadgeti i zabava nece dirati!"));
				prefs.set(p.getUniqueId().toString() + ".Anti knockback", false);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &aUkljucio &6si knockback na Hubu od sada gadgeti i zabava ce te opet gurati i bacati!"));
				prefs.set(p.getUniqueId().toString() + ".Anti knockback", true);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		else if (cmd.getName().equalsIgnoreCase("toggledj")) {
			if (prefs.getBoolean(p.getUniqueId().toString() + ".Double jump")) {
				p.setAllowFlight(false);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &cUgasio &6si dupli skok na Hubu i vise nisi kengo!"));
				prefs.set(p.getUniqueId().toString() + ".Double jump", false);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				p.setAllowFlight(true);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Hub&f>> &aUkljucio &6si dupli skok ma Hubu od sada si opet kengo!"));
				prefs.set(p.getUniqueId().toString() + ".Double jump", true);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		return false;
	}
			
	
}
