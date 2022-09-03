package dev.locationapi.easycommand.utils;

import org.bukkit.entity.Player;

public class TablistManager {

    public void setTablist(Player player) {
        player.setPlayerListHeaderFooter("§5§lMythenCraft\n\n", "\n\n§7Dein Ping§8: §d" + player.getPing());
    }
}
