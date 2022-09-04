package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminBanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.ban")) {
                if(cmd.getName().equalsIgnoreCase("ban")) {
                    String format = args[1].substring(args.length - 1, args.length);
                    int duration = Integer.valueOf(args[1].substring(0, args.length - 1));
                    long time = 0;

                    switch (format) {
                        case "s":
                            time = duration * 1000;
                            break;
                        case "m":
                            time = duration * 1000 * 60;
                            break;
                        case "h":
                            time = duration * 1000 * 60 * 60;
                            break;
                        case "d":
                            time = duration * 1000 * 60 * 24;
                            break;
                        case "w":
                            time = duration * 1000 * 60 * 24 *7;
                            break;
                        default:
                            player.sendMessage("Gib ein gültiges Format an!");
                            return true;
                    }
                    if(args.length >= 2) {
                        String reason = "";
                        for(int i = 2; i < args.length; i++) {
                            reason = reason + args[i] + " ";
                        }
                        reason = reason.trim();
                    }
                } else {
                    player.sendMessage(Main.getPrefix() + "§7Verwende§8: §5/ban §8<§7player§8> §8<§7time§8> §8<§7reason§8>");
                }
            }
        }
        return false;
    }
}
