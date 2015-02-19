package me.kapehh.main.RandomChest.config;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karen on 19.02.2015.
 */
public class ItemData {
    String nameItemData;
    Material id;
    int data;
    String name;
    double probability;
    int MinQuantity;
    int MaxQuantity;
    List<EnchantData> enchants;

    public ItemData(String nameItemData, Material id, int data, String name, double probability, int minQuantity, int maxQuantity) {
        this.nameItemData = nameItemData;
        this.id = id;
        this.data = data;
        this.name = name;
        this.probability = probability;
        MinQuantity = minQuantity;
        MaxQuantity = maxQuantity;
        enchants = new ArrayList<EnchantData>();
    }

    public String getNameItemData() {
        return nameItemData;
    }

    public void setNameItemData(String nameItemData) {
        this.nameItemData = nameItemData;
    }

    public Material getId() {
        return id;
    }

    public void setId(Material id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getMinQuantity() {
        return MinQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        MinQuantity = minQuantity;
    }

    public int getMaxQuantity() {
        return MaxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        MaxQuantity = maxQuantity;
    }

    public List<EnchantData> getEnchants() {
        return enchants;
    }

    public void setEnchants(List<EnchantData> enchants) {
        this.enchants = enchants;
    }

    @Override
    public String toString() {
        return "ItemData{" +
                "nameItemData='" + nameItemData + '\'' +
                ", id=" + id +
                ", data=" + data +
                ", name='" + name + '\'' +
                ", probability=" + probability +
                ", MinQuantity=" + MinQuantity +
                ", MaxQuantity=" + MaxQuantity +
                ", enchants=" + enchants +
                '}';
    }
}
