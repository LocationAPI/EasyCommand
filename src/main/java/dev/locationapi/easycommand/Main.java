package dev.locationapi.easycommand;

import dev.locationapi.easycommand.commands.*;
import dev.locationapi.easycommand.listener.JoinQuitListener;
import dev.locationapi.easycommand.listener.MotdListener;
import dev.locationapi.easycommand.utils.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main instance;
    public static TablistManager tablistManager;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "EasyCommand is loading...");
        registerClasses();
        tablistManager = new TablistManager();


    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "EasyCommand is not loading...");
    }

    public void registerClasses() {
        instance = this;

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new JoinQuitListener(), this);
        pm.registerEvents(new MotdListener(), this);

        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("op").setExecutor(new OPCommand());
        getCommand("deop").setExecutor(new DeopCommand());
        getCommand("fly").setExecutor(new FlyCommand());
    }

    public static Main getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return "§8» §5Mythic §8• §7";
    }

    public static String getNoPermission() {
        return "§7Dazu hast du keine Berechtigung!";
    }

    public static TablistManager getTablistManager() {
        return tablistManager;
    }
}
