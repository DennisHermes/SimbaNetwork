package me.goodgamer123.SimbaCore;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class BlockCommands implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().split(" ")[0].contains(":")) {
        	e.setCancelled(true);
        } else if (e.getMessage().startsWith("/music")) {
        	if (e.getMessage().split(" ").length == 1) {
        		e.setCancelled(true);
        		e.getPlayer().sendMessage(ChatColor.RED + "Unknown command. Use /music help.");
        	}
        } else if (e.getMessage().startsWith("/skin")) {
        	if (e.getMessage().split(" ").length == 1) {
        		e.setCancelled(true);
        		e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+----------------------------------------+"));
        		try {
        			URL url = new URL("https://minotar.net/avatar/" + e.getPlayer().getName() + "/8.png");
        			BufferedImage image = ImageIO.read(url);
        			for (int i = 0; i < image.getHeight(); i++) {
        				StringBuilder chatHeadString = new StringBuilder();
        				for (int j = 0; j < image.getWidth(); j++) {
        					Color color = new Color(image.getRGB(j, i));
        					ChatColor chatColor = fromRGB(color.getRed(), color.getGreen(), color.getBlue());
        					chatHeadString.append(chatColor).append('\u2588');
        				}
        				if (i == 0) e.getPlayer().sendMessage("  " + chatHeadString.toString());
        				if (i == 1) e.getPlayer().sendMessage("  " + chatHeadString.toString());
        				if (i == 2) e.getPlayer().sendMessage("  " + chatHeadString.toString() + ChatColor.translateAlternateColorCodes('&', "   &6&lSkinovi &8- &f&lKomande&r Tvoj skin:"));
        				if (i == 3) e.getPlayer().sendMessage("  " + chatHeadString.toString() + ChatColor.translateAlternateColorCodes('&', "   &6/skin &7<&fImeSkina&7> &7-&f Mjenja tvoj skin."));
        				if (i == 4) e.getPlayer().sendMessage("  " + chatHeadString.toString() + ChatColor.translateAlternateColorCodes('&', "   &6/skin &7<&fImeSkina&7> &7-&f Mjenja tvoj skin."));
        				if (i == 5) e.getPlayer().sendMessage("  " + chatHeadString.toString() + ChatColor.translateAlternateColorCodes('&', "   &6/skin clear &7-&f Resetuje tvoj skin."));
        				if (i == 6) e.getPlayer().sendMessage("  " + chatHeadString.toString());
        				if (i == 7) e.getPlayer().sendMessage("  " + chatHeadString.toString());
        			}
        		} catch (IOException e1) {
        			e1.printStackTrace();
        		}
        		e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+----------------------------------------+"));
        	}
        }
    }
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
        e.setMessage(e.getMessage().replaceAll("[^a-zA-Z0-9\\\\\\\\._-]", ""));
        
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChat2(AsyncPlayerChatEvent e) {
		String formatted = String.format(e.getFormat(), e.getPlayer().getDisplayName(), e.getMessage());
        TextComponent message = new TextComponent(formatted);
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "Click me!" ).create()));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/t " + e.getPlayer().getName()));
        e.setCancelled(true);
        for (Player p : Bukkit.getOnlinePlayers()) {
        	p.spigot().sendMessage(message);
        }
	}
	

	private static Map<ChatColor, ColorSet<Integer, Integer, Integer>> colorMap = new HashMap<ChatColor, ColorSet<Integer, Integer, Integer>>();
	static {
		colorMap.put(ChatColor.BLACK, new ColorSet<Integer, Integer, Integer>(0, 0, 0));
		colorMap.put(ChatColor.DARK_BLUE, new ColorSet<Integer, Integer, Integer>(0, 0, 170));
		colorMap.put(ChatColor.DARK_GREEN, new ColorSet<Integer, Integer, Integer>(0, 170, 0));
		colorMap.put(ChatColor.DARK_AQUA, new ColorSet<Integer, Integer, Integer>(0, 170, 170));
		colorMap.put(ChatColor.DARK_RED, new ColorSet<Integer, Integer, Integer>(170, 0, 0));
		colorMap.put(ChatColor.DARK_PURPLE, new ColorSet<Integer, Integer, Integer>(170, 0, 170));
		colorMap.put(ChatColor.GOLD, new ColorSet<Integer, Integer, Integer>(255, 170, 0));
		colorMap.put(ChatColor.GRAY, new ColorSet<Integer, Integer, Integer>(170, 170, 170));
		colorMap.put(ChatColor.DARK_GRAY, new ColorSet<Integer, Integer, Integer>(85, 85, 85));
		colorMap.put(ChatColor.BLUE, new ColorSet<Integer, Integer, Integer>(85, 85, 255));
		colorMap.put(ChatColor.GREEN, new ColorSet<Integer, Integer, Integer>(85, 255, 85));
		colorMap.put(ChatColor.AQUA, new ColorSet<Integer, Integer, Integer>(85, 255, 255));
		colorMap.put(ChatColor.RED, new ColorSet<Integer, Integer, Integer>(255, 85, 85));
		colorMap.put(ChatColor.LIGHT_PURPLE, new ColorSet<Integer, Integer, Integer>(255, 85, 255));
		colorMap.put(ChatColor.YELLOW, new ColorSet<Integer, Integer, Integer>(255, 255, 85));
		colorMap.put(ChatColor.WHITE, new ColorSet<Integer, Integer, Integer>(255, 255, 255));
	}

	private static class ColorSet<R, G, B> {
		R red = null;
		G green = null;
		B blue = null;

		ColorSet(R red, G green, B blue) {
			this.red = red;
			this.green = green;
			this.blue = blue;
		}

		public R getRed() {
			return red;
		}

		public G getGreen() {
			return green;
		}

		public B getBlue() {
			return blue;
		}

	}

	public static ChatColor fromRGB(int r, int g, int b) {
		TreeMap<Integer, ChatColor> closest = new TreeMap<Integer, ChatColor>();
		colorMap.forEach((color, set) -> {
			int red = Math.abs(r - set.getRed());
			int green = Math.abs(g - set.getGreen());
			int blue = Math.abs(b - set.getBlue());
			closest.put(red + green + blue, color);
		});
		return closest.firstEntry().getValue();
	}
	
}
