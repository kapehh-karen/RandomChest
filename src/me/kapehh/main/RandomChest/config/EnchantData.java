package me.kapehh.main.RandomChest.config;

import org.bukkit.enchantments.Enchantment;

/**
 * Created by Karen on 19.02.2015.
 */
public class EnchantData {
    String nameEnchantData;
    Enchantment enchantment;
    int level;
    double probability;

    public EnchantData(String nameEnchantData, Enchantment enchantment, int level, double probability) {
        this.nameEnchantData = nameEnchantData;
        this.enchantment = enchantment;
        this.level = level;
        this.probability = probability;
    }

    public String getNameEnchantData() {
        return nameEnchantData;
    }

    public void setNameEnchantData(String nameEnchantData) {
        this.nameEnchantData = nameEnchantData;
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "EnchantData{" +
                "nameEnchantData='" + nameEnchantData + '\'' +
                ", enchantment=" + enchantment +
                ", level=" + level +
                ", probability=" + probability +
                '}';
    }
}
