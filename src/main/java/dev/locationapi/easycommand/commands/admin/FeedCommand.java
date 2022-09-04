package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.feed")) {
                if(cmd.getName().equalsIgnoreCase("feed")) {
                    if(args.length == 0) {
                        player.setFoodLevel(20);
                        player.sendMessage(Main.getPrefix() + "§7Dein Hunger wurde gestillt!");
                    } else if(args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(target != null) {
                            target.setFoodLevel(20);
                            target.sendMessage(Main.getPrefix() + "§7Dein Hunger wurde von §5" + player.getName() + " §7gestillt!");
                            player.sendMessage(Main.getPrefix() + "§7Du hast den Hunger von §5" + target.getName() + " §7gestillt!");
                        } else {
                            player.sendMessage(Main.getPrefix() + "§7Der Spieler " + args[0] + "ist nicht online!");
                        }
                    } else {
                        player.sendMessage(Main.getPrefix() + "§7Verwende§8: §5/feed §8<§7player§8>");
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
