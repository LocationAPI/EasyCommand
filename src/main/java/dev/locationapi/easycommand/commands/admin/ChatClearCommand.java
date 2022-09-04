package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClearCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.chatclear")) {
                if(cmd.getName().equalsIgnoreCase("chatclear")) {
                    for(int i = 0; i != 100; i++) {
                        Bukkit.broadcastMessage("");
                    }

                    Bukkit.broadcastMessage(Main.getPrefix() + "Der Chat wurde von §5" + player.getName() + " §7geleert!");
                }
            } else {
                player.sendMessage(Main.getPrefix() + Main.getNoPermission());
            }
        }
        return false;
    }
}
