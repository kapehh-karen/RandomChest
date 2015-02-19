package me.kapehh.main.RandomChest.config;

import org.bukkit.enchantments.Enchantment;

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
