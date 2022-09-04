package dev.locationapi.easycommand.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistManager {

    public void setTablist(Player player) {
        player.setPlayerListHeaderFooter("§5§lMythenCraft\n\n", "\n\n§7Dein Ping§8: §d" + player.getPing());
    }

    public void setPlayerTeams(Player player) {
        Scoreboard scoreboard = player.getScoreboard();

        Team admin = scoreboard.getTeam("0000admin");
        if(admin == null) {
            admin = scoreboard.registerNewTeam("0000admin");

        }

        Team präsident = scoreboard.getTeam("0001präsident");
        if(präsident == null) {
            präsident = scoreboard.registerNewTeam("0001präsident");
        }

        Team kanzler = scoreboard.getTeam("0002kanzler");
        if(kanzler == null) {
            kanzler = scoreboard.registerNewTeam("0002kanzler");
        }

        Team richter = scoreboard.getTeam("0003richter");
        if(richter == null) {
            richter = scoreboard.registerNewTeam("0003richter");
        }

        Team volk = scoreboard.getTeam("0004volk");
        if(volk == null) {
            volk = scoreboard.registerNewTeam("0004volk");
        }

        admin.setPrefix("§4Admin §8| §4");
        admin.setColor(ChatColor.DARK_RED);

        präsident.setPrefix("§cPräsident §8| §c");
        präsident.setColor(ChatColor.RED);

        kanzler.setPrefix("§6Kanzler §8| §6");
        kanzler.setColor(ChatColor.GOLD);

        richter.setPrefix("§eRichter §8| §e");
        richter.setColor(ChatColor.YELLOW);

        volk.setPrefix("§5Volk §8| §5");
        volk.setColor(ChatColor.DARK_PURPLE);

        for(Player target : Bukkit.getOnlinePlayers()) {
            if(target.hasPermission("easycommand.admin")) {
                admin.addEntry(target.getName());

            } else if(target.hasPermission("easycommand.präsident")) {
                präsident.addEntry(target.getName());

            } else if(target.hasPermission("easycommand.kanzler")) {
                kanzler.addEntry(target.getName());

            } else if(target.hasPermission("easycommand.richter")) {
                richter.addEntry(target.getName());

            } else {
                volk.addEntry(target.getName());
            }
        }

    }
}
