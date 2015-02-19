package me.kapehh.main.RandomChest;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * Created by Karen on 19.02.2015.
 */
public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onCloseInventory(InventoryCloseEvent event) {
        Main.instance.virtualInventoryManager.onClose(event.getInventory());
    }
}
