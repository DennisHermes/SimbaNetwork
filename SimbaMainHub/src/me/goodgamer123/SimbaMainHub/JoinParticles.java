package me.goodgamer123.SimbaMainHub;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
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
		
	}
	
}
