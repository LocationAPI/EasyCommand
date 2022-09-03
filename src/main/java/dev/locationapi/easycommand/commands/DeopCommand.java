package dev.locationapi.easycommand.commands;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.op")) {
                if(cmd.getName().equalsIgnoreCase("deop")) {
                    if(args.length == 0) {
                        if(player instanceof Player) {
                            if(player.isOp()) {
                                player.setOp(false);
                                player.sendMessage(Main.getPrefix() + "§7Du bist nun kein Operator mehr!");
                            } else {
                                player.sendMessage(Main.getPrefix() + "Du bist kein Operator!");
                            }
                        } else {
                            sender.sendMessage(Main.getPrefix() + "Diesen Command kann nur ein Spieler ausführen!");
                        }
                    } else if(args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(target != null) {
                            if(target.isOp()) {
                                target.setOp(false);
                                target.sendMessage(Main.getPrefix() + "Du bist nun kein Operator mehr!");
                                player.sendMessage(Main.getPrefix() + "Du hast dem Spieler §5" + target.getName() + " §7den Operator entfernt!");
                            } else {
                                player.sendMessage(Main.getPrefix() + "Du hast dem Spieler §5" + target.getName() + " §7den Operator entfernt!");
                            }
                        } else {
                            player.sendMessage(Main.getPrefix() + "§7Der Spieler §5" + args[0] + " §7ist nicht online!");
                        }
                    } else {
                        player.sendMessage(Main.getPrefix() + "Verwende§8: §5/deop §8<§7player§8>");
                    }
                }
            } else {
                player.sendMessage(Main.getPrefix() + "Das war ein netter Versuch ;)");
            }
        }
        return false;
    }
}
