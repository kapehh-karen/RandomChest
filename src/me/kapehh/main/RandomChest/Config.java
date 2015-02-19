package me.kapehh.main.RandomChest;

import me.kapehh.main.pluginmanager.config.EventPluginConfig;
import me.kapehh.main.pluginmanager.config.EventType;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by Karen on 19.02.2015.
 */
public class Config {

    @EventPluginConfig(EventType.LOAD)
    public void onLoadConfig(FileConfiguration cfg) {
        System.out.println("LOADING CFG: " + cfg.getBoolean("debug"));
    }
}
