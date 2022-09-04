package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminBroadcastCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.adminbroadcast")) {
                if(cmd.getName().equalsIgnoreCase("advertisement") || cmd.getName().equalsIgnoreCase("ad")) {
                    if(args.length >= 1) {
                        String message = "";
                        for(int i = 0; i < args.length; i++) {
                            message = message + args[i] + " ";
                        }

                        Bukkit.broadcastMessage("§8");
                        Bukkit.broadcastMessage("§5§lAnkündigung");
                        Bukkit.broadcastMessage("§8");
                        Bukkit.broadcastMessage(message.replaceAll("&", "§"));
                        Bukkit.broadcastMessage("§6");
                        Bukkit.broadcastMessage("§8");

                        Bukkit.getOnlinePlayers().forEach(players -> players.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F));
                    }
                } else {
                    player.sendMessage(Main.getPrefix() + "Verwende§8: §5/ad §8<§7message§8>");
                }
            } else {
                player.sendMessage(Main.getPrefix() + Main.getNoPermission());
            }
        }
        return false;
    }
}