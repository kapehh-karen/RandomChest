package me.kapehh.main.RandomChest;

import me.kapehh.main.pluginmanager.config.EventPluginConfig;
import me.kapehh.main.pluginmanager.config.EventType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Karen on 19.02.2015.
 */
public class Config {

    @EventPluginConfig(EventType.LOAD)
    public void onLoadConfig(FileConfiguration cfg) {
        ConfigurationSection chestSection = cfg.getConfigurationSection("Chests");
        Set<String> chests = chestSection.getKeys(false);

        for (String chest : chests) {
            ConfigurationSection inChest = chestSection.getConfigurationSection(chest);
            Set<String> items = inChest.getKeys(false);

            for (String item : items) {
                ConfigurationSection inItem = inChest.getConfigurationSection(item);

                System.out.println("ITEM " + item + " id " + inItem.getInt("Id"));
            }
        }
    }
}
