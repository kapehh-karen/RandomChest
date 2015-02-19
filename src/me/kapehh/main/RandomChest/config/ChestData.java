package me.kapehh.main.RandomChest.config;

import me.kapehh.main.RandomChest.vchest.VirtualInventory;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karen on 19.02.2015.
 */
public class ChestData {
    String nameChestData;
    List<ItemData> items;

    public ChestData(String nameChestData) {
        this.nameChestData = nameChestData;
        items = new ArrayList<ItemData>();
    }

    public ItemStack[] getContents() {
        ItemStack[] itemStacks = new ItemStack[VirtualInventory.SIZE_CHEST]; // размер большого сундука
        itemStacks[0] = new ItemStack(Material.INK_SACK, 13, (short) 4);
        return itemStacks;
    }

    public String getNameChestData() {
        return nameChestData;
    }

    public void setNameChestData(String nameChestData) {
        this.nameChestData = nameChestData;
    }

    public List<ItemData> getItems() {
        return items;
    }

    public void setItems(List<ItemData> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ChestData{" +
                "nameChestData='" + nameChestData + '\'' +
                ", items=" + items +
                '}';
    }
}
