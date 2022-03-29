package me.goodgamer123.SimbaKitPVP;

import java.lang.reflect.Field;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathEffect implements Listener {

	@EventHandler
	public void playerDeathEvent(PlayerDeathEvent e) {
        
		for (int i = 0; i < 15; i++) {
			Item item0 = e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 1.5, 0), new ItemStack(Material.INK_SACK, 1, (short) 1));
	        try {
		        Field itemField = item0.getClass().getDeclaredField("item");
		        Field ageField;
		        Object entityItem;
		
		        itemField.setAccessible(true);
		        entityItem = itemField.get(item0);
		
		        ageField = entityItem.getClass().getDeclaredField("age");
		        ageField.setAccessible(true);
				ageField.set(entityItem, 6000 - (3 * 20));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	        item0.setPickupDelay(Integer.MAX_VALUE);
		}
		e.getEntity().playSound(e.getEntity().getLocation(), Sound.CAT_HIT, 1, 1);
		for (Entity p : e.getEntity().getNearbyEntities(10, 10, 10)) {
			if (p instanceof Player) ((Player) p).playSound(p.getLocation(), Sound.CAT_HIT, 1, 1);
		}
	}
	
}
