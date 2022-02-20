package me.goodgamer123.SimbaSkyPVP;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.AnvilInventory;

public class PermanentAnvil implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(PlayerInteractEvent e) {
		if (e.getClickedBlock() == null) return;
		if (e.getClickedBlock().getType() == Material.ANVIL && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block b = e.getClickedBlock();
			if (b.getData() >= 4 && b.getData() < 12) {
				if (b.getData() == 4) b.setData((byte)0);
				else if (b.getData() == 5) b.setData((byte)1);
				else if (b.getData() == 6) b.setData((byte)2);
				else if (b.getData() == 7) b.setData((byte)3);
				else if (b.getData() == 8) b.setData((byte)0);
				else if (b.getData() == 9) b.setData((byte)1);
				else if (b.getData() == 10) b.setData((byte)2);
				else if (b.getData() == 11) b.setData((byte)3);
			}
		} 
	}
	  
	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(BlockPlaceEvent e) {
		if (e.getBlock() == null) return;
		if (e.getBlock().getType() == Material.ANVIL && e.getBlock().getLocation().getBlock().getType() == Material.ANVIL) {
			Block b = e.getBlock();
			if (b.getData() >= 4 && b.getData() < 12) {
				if (b.getData() == 4) b.setData((byte)0); 
				else if (b.getData() == 5) b.setData((byte)1); 
				else if (b.getData() == 6) b.setData((byte)2); 
				else if (b.getData() == 7) b.setData((byte)3); 
				else if (b.getData() == 8) b.setData((byte)0); 
				else if (b.getData() == 9) b.setData((byte)1); 
				else if (b.getData() == 10) b.setData((byte)2); 
				else if (b.getData() == 11) b.setData((byte)3); 
			} 
		} 
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getInventory() instanceof AnvilInventory) {
			int radius = 5;
		    for (int x = e.getWhoClicked().getLocation().getBlockX() - radius; x <= e.getWhoClicked().getLocation().getBlockX() + radius; x++) {
		        for (int y = e.getWhoClicked().getLocation().getBlockY() - radius; y <= e.getWhoClicked().getLocation().getBlockY() + radius; y++) {
		            for (int z = e.getWhoClicked().getLocation().getBlockZ() - radius; z <= e.getWhoClicked().getLocation().getBlockZ() + radius; z++) {
		                Block b = e.getWhoClicked().getWorld().getBlockAt(x, y, z);
		                if (b.getType() == Material.ANVIL) {
		                	if (b.getData() >= 4 && b.getData() < 12) {
		        				if (b.getData() == 4) b.setData((byte)0); 
		        				else if (b.getData() == 5) b.setData((byte)1); 
		        				else if (b.getData() == 6) b.setData((byte)2); 
		        				else if (b.getData() == 7) b.setData((byte)3); 
		        				else if (b.getData() == 8) b.setData((byte)0); 
		        				else if (b.getData() == 9) b.setData((byte)1); 
		        				else if (b.getData() == 10) b.setData((byte)2); 
		        				else if (b.getData() == 11) b.setData((byte)3); 
		        			} 
		                }
		            }
		        }
		    }
		}
	}
	
}
