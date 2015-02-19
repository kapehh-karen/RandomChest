package me.kapehh.main.RandomChest.vchest;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Karen on 18.02.2015.
 */
public class VirtualInventory {
    Inventory inventory;
    Player player;

    public VirtualInventory(Player player) {
        inventory = Bukkit.createInventory(null, InventoryType.CHEST, player.getName());
        this.player = player;
    }

    public void show() {
        player.openInventory(inventory);
    }

    public void close() {
        player.closeInventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "VirtualInventory{" +
                "inventory=" + inventory +
                ", player=" + player +
                '}';
    }
}
