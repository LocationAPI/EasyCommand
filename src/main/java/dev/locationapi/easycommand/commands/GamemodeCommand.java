package dev.locationapi.easycommand.commands;

import dev.locationapi.easycommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("easycommand.gamemode")) {
                if(cmd.getName().equalsIgnoreCase("gamemode")) {
                    if(args.length == 0) {
                        player.sendMessage(Main.getPrefix() + "Verwende§8: §5/gamemode §8<§70,1,2,3§8>");

                    } else if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("0")) {
                            player.sendMessage(Main.getPrefix() + "Du bist nun im §5SURVIVAL §7Modus");
                            player.setGameMode(GameMode.SURVIVAL);

                        } else if(args[0].equalsIgnoreCase("1")) {
                            player.sendMessage(Main.getPrefix() + "Du bist nun im §5CREATIVE §7Modus");
                            player.setGameMode(GameMode.CREATIVE);

                        }else if(args[0].equalsIgnoreCase("2")) {
                            player.sendMessage(Main.getPrefix() + "Du bist nun im §5ADVENTURE §7Modus");
                            player.setGameMode(GameMode.ADVENTURE);
                        }else if(args[0].equalsIgnoreCase("3")) {
                            player.sendMessage(Main.getPrefix() + "Du bist nun im §5SPECTATOR §7Modus");
                            player.setGameMode(GameMode.SPECTATOR);
                        }
                    } else if(args.length == 2) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if(target != null) {
                            if(args[0].equalsIgnoreCase("0")) {
                                target.sendMessage(Main.getPrefix() + "Du bist nun im §5SURVIVAL §7Modus");
                                player.sendMessage(Main.getPrefix() + "Du hast den Spieler §5" + target.getName() + " §7in den §5SURVIVAL §7Modus gesetzt!");
                                target.setGameMode(GameMode.SURVIVAL);

                            } else if(args[0].equalsIgnoreCase("1")) {
                                target.sendMessage(Main.getPrefix() + "Du bist nun im §5CREATIVE §7Modus");
                                player.sendMessage(Main.getPrefix() + "Du hast den Spieler §5" + target.getName() + " §7in den §5CREATIVE §7Modus gesetzt!");
                                target.setGameMode(GameMode.CREATIVE);
                            } else if(args[0].equalsIgnoreCase("2")) {
                                target.sendMessage(Main.getPrefix() + "Du bist nun im §5ADVENTURE §7Modus");
                                player.sendMessage(Main.getPrefix() + "Du hast den Spieler §5" + target.getName() + " §7in den §5ADVENTURE §7Modus gesetzt!");
                                target.setGameMode(GameMode.ADVENTURE);
                            } else if(args[0].equalsIgnoreCase("3")) {
                                target.sendMessage(Main.getPrefix() + "Du bist nun im §5SPECTATOR §7Modus");
                                player.sendMessage(Main.getPrefix() + "Du hast den Spieler §5" + target.getName() + " §7in den §5SPECATOR §7Modus gesetzt!");
                                target.setGameMode(GameMode.SPECTATOR);
                            }
                        } else {
                            player.sendMessage(Main.getPrefix() + "Der Spieler §5" + args[1] + " §7ist nicht online!");
                    }
                } else {
                    player.sendMessage(Main.getPrefix() + "Verwende§8: §5/gamemode §8<§70,1,2,3§8>");
                }
            } else {
                player.sendMessage(Main.getPrefix() + Main.getNoPermission());
            }
        }
        return false;
    }
}
