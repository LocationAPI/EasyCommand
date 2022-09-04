package dev.locationapi.easycommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("staff")) {
            player.sendMessage("§8─────────[ §5Staff §8]─────────");
            player.sendMessage("");
            player.sendMessage("§7Server-Administratoren§8:");
            player.sendMessage("");
            player.sendMessage("§8» §4MuffinLP");
            player.sendMessage("§8» §4Vermens");
            player.sendMessage("");
            player.sendMessage("§8─────────[ §5Staff §8]─────────");
        }
        return false;
    }
}
