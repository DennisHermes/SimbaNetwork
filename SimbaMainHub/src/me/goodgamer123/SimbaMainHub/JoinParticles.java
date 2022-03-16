package me.goodgamer123.SimbaMainHub;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class JoinParticles implements Listener {

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

//===========================================================================================================================================================================================//
		
        PlayerConnection connection = ((CraftPlayer) e.getPlayer()).getHandle().playerConnection;
        
		String title = ChatColor.translateAlternateColorCodes('&', "&6&lSimba&f&lNetwork");
		String subTitle = ChatColor.translateAlternateColorCodes('&', "&fDobrodosao &6" + e.getPlayer().getName() + "&f, na nas Network!");
        
        IChatBaseComponent text = IChatBaseComponent.ChatSerializer.a("{'text': '" + title + "'}");
        IChatBaseComponent subText = IChatBaseComponent.ChatSerializer.a("{'text': '" + subTitle + "'}");
        
        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, text, 1, 5, 1);
        PacketPlayOutTitle subPacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subText, 1, 5, 1);
        
        connection.sendPacket(packet);
        connection.sendPacket(subPacket);
        
        new BukkitRunnable() { 
			@Override
			public void run() {
				PlayerConnection connection = ((CraftPlayer) e.getPlayer()).getHandle().playerConnection;
		        
				String title = ChatColor.translateAlternateColorCodes('&', "&6AntiCheat Provjera...");
				String subTitle = ChatColor.translateAlternateColorCodes('&', "&fSacekaj dok se AntiCheat provjera zarvrsi zatim se prijavi");
		        
		        IChatBaseComponent text = IChatBaseComponent.ChatSerializer.a("{'text': '" + title + "'}");
		        IChatBaseComponent subText = IChatBaseComponent.ChatSerializer.a("{'text': '" + subTitle + "'}");
		        
		        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, text, 1, 10, 1);
		        PacketPlayOutTitle subPacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subText, 1, 10, 1);
		        
		        connection.sendPacket(packet);
		        connection.sendPacket(subPacket);
			}
		}.runTaskLater(MainClass.getPlugin(MainClass.class), 100);
		
//===========================================================================================================================================================================================//
		
		File prefFile = new File(MainClass.getPlugin(MainClass.class).getDataFolder() + "/preferences.yml");
		if (prefFile.exists()) {
			FileConfiguration prefs = YamlConfiguration.loadConfiguration(prefFile);
			if (prefs.get(e.getPlayer().getUniqueId().toString()) != null) {
				
				if (prefs.getBoolean(e.getPlayer().getUniqueId().toString() + ".Speed")) {
					e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
				}
				
				if (prefs.getBoolean(e.getPlayer().getUniqueId().toString() + ".Hide players")) {
					for (Player p1 : Bukkit.getOnlinePlayers()) {
						e.getPlayer().hidePlayer(p1);
					}
				}
				
				if (prefs.getBoolean(e.getPlayer().getUniqueId().toString() + ".Mute sound")) {
					e.getPlayer().setAllowFlight(true);
				}
				
				if (prefs.getBoolean(e.getPlayer().getUniqueId().toString() + ".Double jump")) {
					e.getPlayer().setAllowFlight(true);
				}
				
			} else {
				prefs.set(e.getPlayer().getUniqueId().toString() + ".Speed", true);
				prefs.set(e.getPlayer().getUniqueId().toString() + ".Hide players", false);
				prefs.set(e.getPlayer().getUniqueId().toString() + ".Mute sound", false);
				prefs.set(e.getPlayer().getUniqueId().toString() + ".Anti knockback", false);
				prefs.set(e.getPlayer().getUniqueId().toString() + ".Double jump", true);
				try {
					prefs.save(prefFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else {
			MainClass.getPlugin(MainClass.class).getDataFolder().mkdirs();
			FileConfiguration prefs = YamlConfiguration.loadConfiguration(prefFile);
			prefs.set(e.getPlayer().getUniqueId().toString() + ".Speed", true);
			prefs.set(e.getPlayer().getUniqueId().toString() + ".Hide players", false);
			prefs.set(e.getPlayer().getUniqueId().toString() + ".Mute sound", false);
			prefs.set(e.getPlayer().getUniqueId().toString() + ".Anti knockback", false);
			prefs.set(e.getPlayer().getUniqueId().toString() + ".Double jump", true);
			try {
				prefs.save(prefFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		FileConfiguration prefs = YamlConfiguration.loadConfiguration(prefFile);
		for (Player p1 : Bukkit.getOnlinePlayers()) {
			if (prefs.getBoolean(p1.getUniqueId().toString() + ".Hide players")) {
				p1.hidePlayer(e.getPlayer());
			}
		}
		
	}
	
}
