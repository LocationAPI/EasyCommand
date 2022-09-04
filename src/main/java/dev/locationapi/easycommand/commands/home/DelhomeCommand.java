package dev.locationapi.easycommand.commands.home;

import dev.locationapi.easycommand.Main;
import dev.locationapi.easycommand.utils.manager.HomeManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelhomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("delhome")) {
                if(args.length == 1) {
                    HomeManager manager = new HomeManager(player.getUniqueId());

                    if(manager.exist(args[0])) {
                        manager.delHome(args[0]);
                        player.sendMessage(Main.getPrefix() + "Das Home §5" + args[0] + " §7wurde gelöscht!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1,1 );

                    } else {
                        player.sendMessage(Main.getPrefix() + "Der Homepunkt existiert nicht!");
                    }
                } else {
                    if(args.length == 0) {
                        player.sendMessage(Main.getPrefix() + "Verwende§8: §5/delhome §8<§7Homename§8>");
                    }
                }
            }
        }
        return false;
    }
}
