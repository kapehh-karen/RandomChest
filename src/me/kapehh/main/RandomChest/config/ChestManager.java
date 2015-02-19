package me.kapehh.main.RandomChest.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karen on 19.02.2015.
 */
public class ChestManager {
    List<ChestData> chests;

    public ChestManager() {
        this.chests = new ArrayList<ChestData>();
    }

    public ChestData getChestDataFromName(String name) {
        for (ChestData chestData : chests) {
            if (chestData.getNameChestData().equals(name)) {
                return chestData;
            }
        }
        return null;
    }

    public List<ChestData> getChests() {
        return chests;
    }

    public void setChests(List<ChestData> chests) {
        this.chests = chests;
    }

    @Override
    public String toString() {
        return "ChestManager{" +
                "chests=" + chests +
                '}';
    }
}
