package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.fly")) {
                if(cmd.getName().equalsIgnoreCase("fly")) {
                    if(args.length == 0) {
                        if(player.getAllowFlight()) {
                            player.setAllowFlight(false);
                            player.sendMessage(Main.getPrefix() + "§7Du kannst nun nicht mehr fliegen!");
                        } else {
                            player.setAllowFlight(true);
                            player.sendMessage(Main.getPrefix() + "Du kannst nun fliegen!");
                        }
                    } else if(args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(target != null) {
                            if(target.getAllowFlight()) {
                                target.setAllowFlight(false);
                                target.sendMessage(Main.getPrefix() + "§7Du kannst nun nicht mehr fliegen!");
                                player.sendMessage(Main.getPrefix() + "Der Spieler §5" + target.getName() + " §7kann nun nicht mehr fliegen!");
                            } else {
                                target.setAllowFlight(true);
                                target.sendMessage(Main.getPrefix() + "§7Du kannst nun fliegen!");
                                player.sendMessage(Main.getPrefix() + "Der Spieler §5" + target.getName() + " §7kann nun fliegen!");
                            }
                        } else {
                            player.sendMessage(Main.getPrefix() + "Der Spieler §5" + args[0] + "ist nicht online!");
                        }
                    } else {
                        player.sendMessage(Main.getPrefix() + "Verwende§8: §5/fly §8<§7player§8>");
                    }
                }
            } else {
                player.sendMessage(Main.getPrefix() + Main.getNoPermission());
            }
        }
        return false;
    }
}
