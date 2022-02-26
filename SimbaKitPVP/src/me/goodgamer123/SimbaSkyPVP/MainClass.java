package me.goodgamer123.SimbaSkyPVP;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DisableBuilding(), this);
		getServer().getPluginManager().registerEvents(new ProjectileTrails(), this);
		getServer().getPluginManager().registerEvents(new DeathEffect(), this);
		getServer().getPluginManager().registerEvents(new AntiSelfBow(), this);
		
		getCommand("gradi").setExecutor(this);
		
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
					
					for (int slot = 0; slot < 27; slot++) {
						if (p.getInventory().getItem(slot) != null) {
						    if (p.getInventory().getItem(slot).getType().equals(Material.EGG) && p.getInventory().getItem(slot).getItemMeta().getLore() == null) {
						    	int amount = 1;
						    	ItemStack egg = new ItemStack(Material.EGG);
						    	ItemMeta eggMeta = egg.getItemMeta();
						    	eggMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8[&e&lEksplozivna Jaja&8]"));
						    	ArrayList<String> eggLore = new ArrayList<>();
						        eggLore.add(ChatColor.translateAlternateColorCodes('&', "&bKAA BOOOM xD"));
						        eggLore.add(ChatColor.translateAlternateColorCodes('&', "&bOvo nije obicno jaje xD"));
						        eggLore.add(ChatColor.translateAlternateColorCodes('&', "&bCuvaj ga nikad ne znas kad ce ti zatrebati xD"));
						    	eggMeta.setLore(eggLore);
						    	egg.setItemMeta(eggMeta);
						    	egg.setAmount(amount);
						    	p.getInventory().setItem(slot, egg);
						    }
						}
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
		if (cmd.getName().equalsIgnoreCase("gradi")) {
			if (!DisableBuilding.building.contains(p)) {
				DisableBuilding.building.add(p);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eMod za postavljanje/razbijanje blokova je sada: &cIskljucen&e."));
			} else {
				DisableBuilding.building.remove(p);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eMod za postavljanje/razbijanje blokova je sada: &aUkljucen&e."));
			}
		}
		
		return false;
	}
}


