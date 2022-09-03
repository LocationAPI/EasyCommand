package dev.locationapi.easycommand.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdListener implements Listener {

    @EventHandler
    public void onMotd(ServerListPingEvent event) {
        event.setMotd("             §5●§d• §5MythenCraft §d•§5● §f1.19.2\n             §7Adventure Kingdom");
        event.setMaxPlayers(50);
    }
}
