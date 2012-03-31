package net.slipcor.pvparena.listeners;

import net.slipcor.pvparena.arena.Arena;
import net.slipcor.pvparena.core.Debug;
import net.slipcor.pvparena.managers.Arenas;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.inventory.InventoryClickEvent;

/**
 * custom listener class
 * 
 * -
 * 
 * PVP Arena Custom Listener
 * 
 * @author slipcor
 * 
 * @version v0.7.0
 * 
 */
public class CustomListener implements Listener {
	private Debug db = new Debug(19);

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player p = event.getPlayer();

		Arena arena = Arenas.getArenaByPlayer(p);

		if (arena == null) {
			return;
		}
		
		if (!arena.type().usesFlags()) {
			return;
		}
		
		db.i("cancelling!");
		// player is carrying a flag
		event.setCancelled(true);
	}
}
