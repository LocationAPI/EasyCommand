package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class KillallCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.killall")) {
                if(cmd.getName().equalsIgnoreCase("killall")) {
                    World world = player.getWorld();
                    for(Entity entity : world.getLivingEntities()) {
                        if(!(entity instanceof Player)) {
                            entity.remove();
                            player.sendMessage(Main.getPrefix() + "Es wurden alle Tiere und Monster entfernt!");
                        }
                    }
                }
            } else {
                player.sendMessage(Main.getPrefix() + Main.getNoPermission());
            }
        }
        return false;
    }
}
