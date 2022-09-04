package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPCommand implements CommandExecutor {

    private int taskID;
    private int count = 3;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.tp")) {
                if(cmd.getName().equalsIgnoreCase("tp")) {
                    if(args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);

                        player.teleport(target);
                        player.sendMessage(Main.getPrefix() + "Du hast dich zum Spieler §5" + target.getName() + " §7teleportiert!");

                    } else {
                        player.sendMessage(Main.getPrefix() + "Verwende§8: §5/tp §8<§7player§8>");
                    }
                }
            } else {
                player.sendMessage(Main.getPrefix() + Main.getNoPermission());
            }
        }
        return false;
    }
}
