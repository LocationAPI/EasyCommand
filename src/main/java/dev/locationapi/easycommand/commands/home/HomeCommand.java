package dev.locationapi.easycommand.commands.home;

import dev.locationapi.easycommand.Main;
import dev.locationapi.easycommand.utils.manager.HomeManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.home")) {
                if(cmd.getName().equalsIgnoreCase("home")) {
                    if(args.length == 0) {
                         HomeManager manager = new HomeManager(player.getUniqueId());

                         if(!(manager.getHomes().size() == 0)) {
                             String out = "";
                             for(String s : manager.getHomes()) {
                                 out = "§e" + s + "§7, " + out;
                             }

                             out = out.trim();
                             out = out.substring(0, out.length() -1);

                             player.sendMessage(Main.getPrefix() + "§7Deine Homes§8: " + out);
                         } else if(manager.getHomes().size() == 0) {
                             player.sendMessage(Main.getPrefix() + "§7Du musst dir ein Homepunkt setzen!");
                         }
                    } else if(args.length == 1) {
                        HomeManager manager = new HomeManager(player.getUniqueId());

                        if(manager.exist(args[0])) {
                            player.teleport(manager.getLocation(args[0]));
                            player.sendMessage(Main.getPrefix() + "Du hast dich zu deinem Home teleportiert!");
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        } else {
                            player.sendMessage(Main.getPrefix() + "Dieser Homepunkt existiert nicht!");
                        }
                    }
                } else {
                    player.sendMessage(Main.getPrefix() + Main.getNoPermission());
                }
            }
        }
        return false;
    }
}
