package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {

    public static ArrayList<Player> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.vanish")) {
                if(cmd.getName().equalsIgnoreCase("vanish")) {
                    if(vanished.contains(player)) {
                        player.sendMessage(Main.getPrefix() + "Du bist nun nicht mehr unsichtbar!");
                        vanished.remove(player);
                        player.removePotionEffect(PotionEffectType.INVISIBILITY);
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(player);
                        }
                    } else {
                        vanished.add(player);
                        player.sendMessage(Main.getPrefix() + "Du bist nun unsichtbar!");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 1, false, false));
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            all.hidePlayer(player);
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
