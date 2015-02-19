package me.kapehh.main.RandomChest;

import me.kapehh.main.RandomChest.vchest.VirtualInventoryManager;
import me.kapehh.main.pluginmanager.config.PluginConfig;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Karen on 18.02.2015.
 */
public class Main extends JavaPlugin {
    public static Main instance;

    public VirtualInventoryManager virtualInventoryManager;
    public PluginConfig pluginConfig;

    @Override
    public void onDisable() {
        super.onDisable();
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

        getCommand("randomchest").setExecutor(new CommandExecutor());
        getServer().getPluginManager().registerEvents(new Listener(), this);
    }
}
