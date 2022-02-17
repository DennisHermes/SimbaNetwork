package me.goodgamer123.SimbaMainHub;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class DisableBuilding implements Listener {

	static ArrayList<Player> building = new ArrayList<Player>();
	
	@EventHandler
	public void blockPlace(BlockPlaceEvent e) {
		if (e.getPlayer().isOp()) {
			if (building.contains(e.getPlayer())) e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent e) {
		if (e.getPlayer().isOp()) {
			if (building.contains(e.getPlayer())) e.setCancelled(true);
		}
	}
	
}
