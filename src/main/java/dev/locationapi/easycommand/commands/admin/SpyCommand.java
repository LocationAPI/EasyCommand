package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.spy")) {
                if(cmd.getName().equalsIgnoreCase("spy")) {
                    if(Main.commandspyList.contains(player)) {
                        Main.commandspyList.remove(player);
                        player.sendMessage(Main.getPrefix() + "Du siehst nun keine Commands mehr von anderen im Chat!");
                    } else {
                        Main.commandspyList.add(player);
                        player.sendMessage(Main.getPrefix() + "Du siehst nun alle Commands von anderen im Chat!");
                    }
                }
            }
        }
        return false;
    }
}
