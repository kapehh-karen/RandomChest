package me.kapehh.main.RandomChest;

import me.kapehh.main.RandomChest.config.ChestData;
import me.kapehh.main.RandomChest.config.ChestManager;
import me.kapehh.main.RandomChest.config.EnchantData;
import me.kapehh.main.RandomChest.config.ItemData;
import me.kapehh.main.pluginmanager.config.EventPluginConfig;
import me.kapehh.main.pluginmanager.config.EventType;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Karen on 19.02.2015.
 */
public class Config {

    // Потому-что жизнь-боль, вот почему
    public Material getMaterialById(int id) {
        for (Material material : Material.values()) {
            if (material.getId() == id) {
                return material;
            }
        }
        return null;
    }

    @EventPluginConfig(EventType.LOAD)
    public void onLoadConfig(FileConfiguration cfg) {
        ConfigurationSection chestSection = cfg.getConfigurationSection("Chests");
        Set<String> chests = chestSection.getKeys(false);

        ChestManager chestManager = new ChestManager();
        List<ChestData> chestDatas = new ArrayList<ChestData>();

        for (String chest : chests) {
            ConfigurationSection inChest = chestSection.getConfigurationSection(chest);
            Set<String> items = inChest.getKeys(false);

            ChestData chestData = new ChestData(chest);
            List<ItemData> itemDatas = new ArrayList<ItemData>();

            for (String item : items) {
                ConfigurationSection inItem = inChest.getConfigurationSection(item);
                ConfigurationSection enchantsSection = inItem.getConfigurationSection("Enchantments");

                ItemData itemData = new ItemData(
                        item,
                        getMaterialById(inItem.getInt("Id", 0)),
                        inItem.getInt("Data", 0),
                        inItem.getString("Name", null),
                        inItem.getDouble("Probability", 0),
                        inItem.getInt("MinQuantity", 1),
                        inItem.getInt("MaxQuantity", 1)
                );

                if (enchantsSection != null) {
                    Set<String> enchants = enchantsSection.getKeys(false);

                    List<EnchantData> enchantDatas = new ArrayList<EnchantData>();
                    for (String enchant : enchants) {
                        ConfigurationSection inEnchant = enchantsSection.getConfigurationSection(enchant);
                        EnchantData enchantData = new EnchantData(
                                enchant,
                                Enchantment.getByName(inEnchant.getString("Enchantment", null)),
                                inEnchant.getInt("Level", 0),
                                inEnchant.getDouble("Probability", 0)
                        );
                        enchantDatas.add(enchantData);
                    }

                    itemData.setEnchants(enchantDatas);
                }

                itemDatas.add(itemData);
            }

            chestData.setItems(itemDatas);
            chestDatas.add(chestData);
        }

        chestManager.setChests(chestDatas);
        Main.instance.chestManager = chestManager;
        Main.instance.debug = cfg.getBoolean("Debug");
    }
}
