package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.adminchat")) {
                if(cmd.getName().equalsIgnoreCase("adminchat")) {
                    if(args.length > 0) {
                        String message = "";
                        for(int i = 0; i < args.length; ++i) {
                            message = String.valueOf(message) + " " + args[i];
                        }

                        for(final Player all : Bukkit.getOnlinePlayers()) {
                            if(all.hasPermission("easycommnd.adminchat")) {
                                all.sendMessage(Main.getAdminChat() + " §c" + player.getName() + " §8» §6" + message);
                            }
                        }
                    } else {
                        player.sendMessage(Main.getPrefix() + "Verwende§8: §5/ac §8<§7message§8>");
                    }
                }
            } else {
                player.sendMessage(Main.getPrefix() + Main.getNoPermission());
            }
        }
        return false;
    }
}
