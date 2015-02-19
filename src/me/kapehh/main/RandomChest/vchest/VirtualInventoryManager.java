package me.kapehh.main.RandomChest.vchest;

import me.kapehh.main.RandomChest.config.ChestData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karen on 19.02.2015.
 */
public class VirtualInventoryManager {
    List<VirtualInventory> virtualInventories = new ArrayList<VirtualInventory>();

    public void add(Player player, ChestData chest) {
        VirtualInventory virtualInventory = new VirtualInventory(player, chest);
        virtualInventories.add(virtualInventory);
        virtualInventory.show();
    }

    public void onClose(Inventory inventory) {
        for (VirtualInventory virtualInventory : virtualInventories) {
            if (virtualInventory.getInventory().equals(inventory)) {
                //System.out.println("HAHAHA CLOSE: " + virtualInventory);
                virtualInventories.remove(virtualInventory);
                break;
            }
        }
    }
}
