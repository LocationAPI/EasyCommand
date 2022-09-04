package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.heal")) {
                if(cmd.getName().equalsIgnoreCase("heal")) {
                    if(args.length == 0) {
                        player.setFoodLevel(20);
                        player.sendMessage(Main.getPrefix() + "§7Du wurdest geheilt!");
                    } else if(args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(target != null) {
                            target.setFoodLevel(20);
                            target.sendMessage(Main.getPrefix() + "§7Du wurdest von §5" + player.getName() + " §7geheilt!");
                            player.sendMessage(Main.getPrefix() + "§7Du hast den Spieler §5" + target.getName() + " §7geheilt.");
                        } else {
                            player.sendMessage(Main.getPrefix() + "§7Der Spieler §5" + args[0] + " §7ist nicht online!");
                        }
                    } else {
                        player.sendMessage(Main.getPrefix() + "§7Verwende§8: §5/heal §8<§7player§8>");
                    }
                }
            } else {
                player.sendMessage(Main.getPrefix() + Main.getNoPermission());
            }
        } else {
            sender.sendMessage(Main.getPrefix() + "Dieser Command kann nur ein Spieler ausführen!");
        }
        return false;
    }
}