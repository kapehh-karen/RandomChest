package me.kapehh.main.RandomChest.vchest;

import me.kapehh.main.RandomChest.Main;
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

    ChestData chestData;
    Inventory inventory;
    Player player;
    ItemStack[] contents;

    public VirtualInventory(Player player, ChestData chest) {
        inventory = Bukkit.createInventory(null, SIZE_CHEST, chest.getNameChestData());
        contents = chest.getContents();
        inventory.setContents(contents);
        this.player = player;
        this.chestData = chest;
    }

    public void show() {
        if (Main.instance.debug) {
            StringBuilder sb = new StringBuilder().append('{');
            for (ItemStack itemStack : contents) {
                if (itemStack == null || itemStack.getType().equals(Material.AIR)) continue;
                sb.append(itemStack).append(", ");
            }
            sb.append('}');
            Main.instance.fileLogger.getLog().info(
                    String.format("Player '%s' open chest '%s' with contents %s",
                            player.getName(),
                            chestData.getNameChestData(),
                            sb.toString()
                    )
            );
        }
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
