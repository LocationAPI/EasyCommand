package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SunCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(player.hasPermission("easycommand.weather")) {
            if(cmd.getName().equalsIgnoreCase("rain")) {
                World world = player.getWorld();

                world.setStorm(false);
                world.setThundering(false);
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(Main.getPrefix() + "Der Spieler §5" + player.getName() + " §7hat das Wetter auf §5Sonne §7gestellt!");
            }
        } else {
            player.sendMessage(Main.getPrefix() + Main.getNoPermission());
        }
        return false;
    }
}