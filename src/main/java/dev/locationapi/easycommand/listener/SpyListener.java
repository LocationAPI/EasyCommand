package dev.locationapi.easycommand.listener;

import dev.locationapi.easycommand.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SpyListener implements Listener {

    @EventHandler
    public void onCommand(final PlayerCommandPreprocessEvent event) {
        for(final Player player : Main.commandspyList) {
            player.sendMessage(Main.getPrefix() + "§7 " + event.getPlayer().getName() + " §8» §7" + event.getMessage());
        }
    }
}
