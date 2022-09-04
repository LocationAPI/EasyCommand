package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(player.hasPermission("easycommand.time")) {
            if(cmd.getName().equalsIgnoreCase("night")) {
                World world = player.getWorld();

                world.setTime(3000);
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(Main.getPrefix() + "Der Spieler §5" + player.getName() + " §7hat auf §5Nacht §7gestellt");
            }
        }
        return false;
    }
}
