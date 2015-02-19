package me.kapehh.main.RandomChest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Karen on 18.02.2015.
 */
public class CommandExecutor implements org.bukkit.command.CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        Main.instance.virtualInventoryManager.add(player);
        return true;
    }
}
