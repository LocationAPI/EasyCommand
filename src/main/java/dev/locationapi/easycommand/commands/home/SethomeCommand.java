package dev.locationapi.easycommand.commands.home;

import dev.locationapi.easycommand.Main;
import dev.locationapi.easycommand.utils.manager.HomeManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SethomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("sethome")) {
                if(args.length == 1) {
                    HomeManager manager = new HomeManager(player.getUniqueId());

                    if(manager.exist(args[0])) {
                        manager.addHome(player.getLocation(), args[0]);
                        player.sendMessage(Main.getPrefix() + "Dein Homepunkt §5" + args[0] + " §7wurde überschrieben!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        return false;
                    }
                    if(player.hasPermission("easycommand.sethome.4")) {
                        if(manager.getHomes().size() < 4) {
                            manager.addHome(player.getLocation(), args[0]);
                            player.sendMessage(Main.getPrefix() + "Du hast dein Homepunkt §5" + args[0] + " §7wurde überschrieben");
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

                        } else {
                            player.sendMessage(Main.getPrefix() + "Du kannst nur maximal 4 Homes setzen!");
                        }
                    } else {
                        player.sendMessage(Main.getPrefix() + Main.getNoPermission());
                    }
                } else {
                    player.sendMessage(Main.getPrefix() + "Verwende§8: §5/sethome §8<§7homename§8>");
                }
            }
        }
        return false;
    }
}
