package me.kapehh.main.RandomChest;

import me.kapehh.main.RandomChest.config.ChestManager;
import me.kapehh.main.RandomChest.vchest.VirtualInventoryManager;
import me.kapehh.main.pluginmanager.config.PluginConfig;
import me.kapehh.main.pluginmanager.logger.PluginLogger;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

/**
 * Created by Karen on 18.02.2015.
 */
public class Main extends JavaPlugin {
    public static Main instance;

    public VirtualInventoryManager virtualInventoryManager;
    public PluginConfig pluginConfig;
    public ChestManager chestManager;
    public PluginLogger fileLogger;
    public boolean debug = false;

    @Override
    public void onDisable() {
        fileLogger.shutDown();

        instance = null;
    }

    @Override
    public void onEnable() {
        instance = this;

        if (getServer().getPluginManager().getPlugin("PluginManager") == null) {
            getLogger().info("PluginManager not found!!!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        virtualInventoryManager = new VirtualInventoryManager();

        pluginConfig = new PluginConfig(this);
        pluginConfig.addEventClasses(new Config());
        pluginConfig.setup();
        pluginConfig.loadData();

        fileLogger = new PluginLogger(this, "logs.txt");
        fileLogger.setup();

        getCommand("randomchest").setExecutor(new CommandExecutor());
        getServer().getPluginManager().registerEvents(new Listener(), this);
    }
}
