package me.kapehh.main.RandomChest;

import me.kapehh.main.RandomChest.config.ChestData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Karen on 18.02.2015.
 */
public class CommandExecutor implements org.bukkit.command.CommandExecutor {

    private Player getOnlinePlayer(String name) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length < 1) {
            return false;
        }

        String method = args[0];
        if (method.equalsIgnoreCase("open")) {
            if (args.length < 2) {
                return false;
            }
            String chestName = args[1];
            Player player = null;

            if (!commandSender.isOp() && !commandSender.hasPermission("randomchest.use." + chestName)) {
                commandSender.sendMessage(ChatColor.RED + "Forbidden!");
                return true;
            }

            if ((args.length < 3) && (commandSender instanceof Player)) {
                player = (Player) commandSender;
            } else if (args.length >= 3) {
                player = getOnlinePlayer(args[2]);
            }

            if (player == null) {
                commandSender.sendMessage("Player not found!");
                return true;
            }

            ChestData chestData = Main.instance.chestManager.getChestDataFromName(chestName);
            if (chestData == null) {
                commandSender.sendMessage("Chest not found!");
                return true;
            }

            Main.instance.virtualInventoryManager.add(player, chestData);
        } else if (method.equalsIgnoreCase("reload")) {
            if (!commandSender.isOp()) {
                commandSender.sendMessage(ChatColor.RED + "Forbidden!");
                return true;
            }

            Main.instance.pluginConfig.loadData();
            commandSender.sendMessage(ChatColor.GREEN + "Reloaded!");
        } else {
            return false;
        }

        return true;
    }
}
