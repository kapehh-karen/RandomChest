package me.kapehh.main.RandomChest.vchest;

import me.kapehh.main.RandomChest.config.ChestData;
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
    public static final int SIZE_CHEST = 9 * 6;

    Inventory inventory;
    Player player;

    public VirtualInventory(Player player, ChestData chest) {
        inventory = Bukkit.createInventory(null, SIZE_CHEST, chest.getNameChestData());
        inventory.setContents(chest.getContents());
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
