package me.kapehh.main.RandomChest.config;

import me.kapehh.main.RandomChest.Main;
import me.kapehh.main.RandomChest.vchest.VirtualInventory;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Karen on 19.02.2015.
 */
public class ChestData {
    private static final Random rand = new Random();

    String nameChestData;
    List<ItemData> items;

    public ChestData(String nameChestData) {
        this.nameChestData = nameChestData;
        items = new ArrayList<ItemData>();
    }

    private double getRandProbability() {
        return 100 * rand.nextDouble();
    }

    private int getRandQuantity(ItemData item) {
        if (item.getMaxQuantity() == item.getMinQuantity()) return item.getMinQuantity();
        return item.getMinQuantity() + rand.nextInt(item.getMaxQuantity() - item.getMinQuantity() + 1);
    }

    public ItemStack[] getContents() {
        ItemStack[] itemStacks = new ItemStack[VirtualInventory.SIZE_CHEST]; // размер большого сундука

        ItemStack itemStack;
        double chance;
        int count, tmp, i;

        i = 0;
        for (ItemData item : items) {
            //System.out.println("===START===");

            // получаем текущий шанс для итема
            chance = getRandProbability();

            //System.out.println("CURRENT CHANCE: " + chance + ", chance of item (" + item.getNameItemData() + "): " + item.getProbability());

            // если не повезло, то обида и едем дальше
            if (chance >= item.getProbability()) continue;

            // получаем случайное количество от минимального до максимального
            count = getRandQuantity(item);

            //System.out.println("COUNT BETWEEN " + item.getMinQuantity() + " AND " + item.getMaxQuantity() + " == " + count);

            do {
                //System.out.println("===START===");

                // чтоб не вылететь за пределы сундука
                if (i >= VirtualInventory.SIZE_CHEST) break;

                // берем меньшее из максимального размера в стаке и того что ещё осталось выдать
                tmp = Math.min(item.getId().getMaxStackSize(), count);

                //System.out.println("tmp = " + tmp + ", count = " + count + ", max size = " + item.getId().getMaxStackSize());

                itemStack = new ItemStack(item.getId(), tmp, (short) item.getData());
                if (item.getName() != null) {
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(item.getName());

                    for (EnchantData ench : item.getEnchants()) {
                        // получаем текущий шанс для чара
                        chance = getRandProbability();

                        if (chance >= ench.getProbability()) continue;

                        itemMeta.addEnchant(ench.getEnchantment(), ench.getLevel(), true);
                    }

                    itemStack.setItemMeta(itemMeta);
                }

                itemStacks[i] = itemStack;
                i++;
                count -= tmp;

                //System.out.println("count = " + count);
            } while (count > 0);
        }

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
