package dev.locationapi.easycommand.commands.admin;

import dev.locationapi.easycommand.Main;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class AdminCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack adminhelmet = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta adminmeta = (LeatherArmorMeta) adminhelmet.getItemMeta();
            adminmeta.setColor(Color.RED);
            adminmeta.setDisplayName("§4Server-Admin");
            adminhelmet.setItemMeta(adminmeta);

            ItemStack adminchest = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta adminnmeta = (LeatherArmorMeta) adminchest.getItemMeta();
            adminnmeta.setColor(Color.RED);
            adminnmeta.setDisplayName("§4Server-Admin");
            adminchest.setItemMeta(adminnmeta);

            ItemStack adminleg = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta adminlegg = (LeatherArmorMeta) adminleg.getItemMeta();
            adminlegg.setColor(Color.RED);
            adminlegg.setDisplayName("§4Server-Admin");
            adminleg.setItemMeta(adminlegg);

            ItemStack adminboots = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta adminboot = (LeatherArmorMeta) adminboots.getItemMeta();
            adminboot.setColor(Color.RED);
            adminboot.setDisplayName("§4Server-Admin");
            adminboots.setItemMeta(adminboot);


            if(player.hasPermission("easycommand.admin")) {
                if(cmd.getName().equalsIgnoreCase("admin")) {
                    if(args.length == 0) {

                    } else if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("on")) {
                            player.sendMessage(Main.getPrefix() + "Du bist nun als §cAdmin §7unterwegs!");
                            player.setGameMode(GameMode.CREATIVE);
                            player.getInventory().setHelmet(adminhelmet);
                            player.getInventory().setChestplate(adminchest);
                            player.getInventory().setLeggings(adminleg);
                            player.getInventory().setBoots(adminboots);

                        } else if(args[0].equalsIgnoreCase("off")) {
                            player.sendMessage(Main.getPrefix() + "Du bist nun nicht mehr als §cAdmin §7unterwegs!");
                            player.getInventory().clear();
                            player.setGameMode(GameMode.SURVIVAL);
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
