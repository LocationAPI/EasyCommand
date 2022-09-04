package dev.locationapi.easycommand.commands;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSGCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("msg")) {
                if(args.length < 2) {
                    player.sendMessage(Main.getPrefix() + "Verwende§8: §5/msg §8<§7player§8> §8<§7message§8>");

                } else {
                    if(Bukkit.getServer().getPlayer(args[0]) != null) {
                        if(!player.getName().equalsIgnoreCase(args[0])) {
                            Player target = Bukkit.getPlayer(args[0]);
                            String message = "";

                            for(int i = 1; i != args.length; i++) {
                                message = message + " " + args[i];
                            }

                            player.sendMessage("§e§lNACHRICHT §7| §8« §e" + player.getName() + " §8➟ §e" + target.getName() + " §8» §7" + message);
                            target.sendMessage("§e§lNACHRICHT §7| §8« §e" + player.getName() + " §8➟ §e" + target.getName() + " §8» §7" + message);
                        } else {
                            sender.sendMessage(Main.getPrefix() + "Du kannst dir nicht selber schreiben!");
                        }
                    } else {
                        sender.sendMessage(Main.getPrefix() + "Der Spieler ist nicht online!");
                    }
                }
            }
        }
        return false;
    }
}
