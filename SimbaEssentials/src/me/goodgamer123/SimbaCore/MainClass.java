package me.goodgamer123.SimbaCore;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class MainClass extends JavaPlugin {

	ArrayList<String> ssList = new ArrayList<String>();
	
	@Override
	public void onEnable() {

		getServer().getPluginManager().registerEvents(new BlockCommands(), this);
		
		FileConfiguration config = this.getConfig();
		config.addDefault("IpWhitelist", false);
		config.options().copyDefaults(true);
        saveConfig();
        
        if (LocalDateTime.now().getHour() == 5 && LocalDateTime.now().getMinute() == 0 && LocalDateTime.now().getSecond() == 0) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
		} else if (LocalDateTime.now().getHour() == 5 && LocalDateTime.now().getMinute() == 55 && LocalDateTime.now().getSecond() == 0) {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &6Podserver ce se automatski restartovati za &f&l5 &6minuta! Spremi sve sto radis!"));
			
			for (Player p : Bukkit.getOnlinePlayers()) {
				PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
		        
				String title = ChatColor.translateAlternateColorCodes('&', "&6Redovni restart podservera...");
				String subTitle = ChatColor.translateAlternateColorCodes('&', "&fZa 5 minuta pocece restart, spremi sve sto radis!");
		        
		        IChatBaseComponent text = IChatBaseComponent.ChatSerializer.a("{'text': '" + title + "'}");
		        IChatBaseComponent subText = IChatBaseComponent.ChatSerializer.a("{'text': '" + subTitle + "'}");
		        
		        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, text, 1, 5, 1);
		        PacketPlayOutTitle subPacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subText, 1, 5, 1);
		        
		        connection.sendPacket(packet);
		        connection.sendPacket(subPacket);
			}
		} else if (LocalDateTime.now().getHour() == 5 && LocalDateTime.now().getMinute() == 55 && LocalDateTime.now().getSecond() == 0) {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &6Podserver ce se automatski restartovati za samo &f&l1 &6minut! Spremi sve sto radis!"));
			
			for (Player p : Bukkit.getOnlinePlayers()) {
				PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
		        
				String title = ChatColor.translateAlternateColorCodes('&', "&6Redovni restart podservera...");
				String subTitle = ChatColor.translateAlternateColorCodes('&', "&fZa 1 minut pocece restart, spremi sve sto radis!");
		        
		        IChatBaseComponent text = IChatBaseComponent.ChatSerializer.a("{'text': '" + title + "'}");
		        IChatBaseComponent subText = IChatBaseComponent.ChatSerializer.a("{'text': '" + subTitle + "'}");
		        
		        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, text, 1, 5, 1);
		        PacketPlayOutTitle subPacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subText, 1, 5, 1);
		        
		        connection.sendPacket(packet);
		        connection.sendPacket(subPacket);
			}
		}
        
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				
			}
			
		}, 20L, 20L);
        
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
		
		if (cmd.getName().equalsIgnoreCase("screenshare")) {
			if (args.length >= 1) {
				if (Bukkit.getPlayer(args[0]) != null) {
					if (args.length >= 2) {
						if (args[1].equalsIgnoreCase("accept")) {
							if (ssList.contains(args[0].toLowerCase())) {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &aPrihvatio si ss od igraca &f(playername)&a."));
								Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &aTvoj Screen Share (ss) je prihvacen!"));
								ssList.remove(args[0].toLowerCase());
							} else {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &7Nemas nista da prihvatis jer nisi ni poslao zahtjev za ss ovom igracu."));
							}
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &aUspjesno si poslao zahtjev za ss igracu &f" + args[0] + "&a."));
							ssList.add(args[0].toLowerCase());
							for (int i = 0; i < 10; i++) {
								int u = i;
								new BukkitRunnable() { 
									@Override
									public void run() {
										if (ssList.contains(args[0].toLowerCase())) {
											if (u == 0) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l5 &eMinuta i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
											} else if (u == 1) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l4 &eMinuta i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
											} else if (u == 2) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l4 &eMinuta i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
											} else if (u == 3) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l3 &eMinuta i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
											} else if (u == 4) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l3 &eMinuta i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
											} else if (u == 5) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l2 &eMinuta i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
											} else if (u == 6) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l2 &eMinuta i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
											} else if (u == 7) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l1 &eMinuta i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
											} else if (u == 8) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l1 &eMinut i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
											} else if (u == 9) {
												Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l0 &eMinut i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
												ssList.remove(args[0].toLowerCase());
											}
										}
									}
								}.runTaskLater(MainClass.getPlugin(MainClass.class), i * 600);
							}
						}
					} else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &aUspjesno si poslao zahtjev za ss igracu &f" + args[0] + "&a."));
						for (int i = 0; i < 10; i++) {
							int u = i;
							new BukkitRunnable() { 
								@Override
								public void run() {
									if (u == 0) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l5 &eMinuta i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									} else if (u == 1) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l4 &eMinuta i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									} else if (u == 2) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l4 &eMinuta i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									} else if (u == 3) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l3 &eMinuta i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									} else if (u == 4) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l3 &eMinuta i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									} else if (u == 5) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l2 &eMinuta i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									} else if (u == 6) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l2 &eMinuta i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									} else if (u == 7) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l1 &eMinuta i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									} else if (u == 8) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l1 &eMinut i &f&l0 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									} else if (u == 9) {
										Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &eOstalo ti je jos &f&l0 &eMinut i &f&l30 &eSekundi, da odradis Screen Share (ss). Za uputstvo kucaj &f/ss&6."));
									}
								}
							}.runTaskLater(MainClass.getPlugin(MainClass.class), i * 600);
						}
					}
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kontrola&f>> &7Igrac kojem si htio poslati zahtjev za ss nije online."));
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Usage: /ss <player>");
			}
		}
		
		return false;
	}
}


