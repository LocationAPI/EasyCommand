package dev.locationapi.easycommand;

import dev.locationapi.easycommand.commands.*;
import dev.locationapi.easycommand.commands.admin.*;
import dev.locationapi.easycommand.commands.home.DelhomeCommand;
import dev.locationapi.easycommand.commands.home.HomeCommand;
import dev.locationapi.easycommand.commands.home.SethomeCommand;
import dev.locationapi.easycommand.listener.JoinQuitListener;
import dev.locationapi.easycommand.listener.MotdListener;
import dev.locationapi.easycommand.listener.SpyListener;
import dev.locationapi.easycommand.utils.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    public static Main instance;
    public static Main plugin;
    public static TablistManager tablistManager;
    public static final List<Player> commandspyList = new ArrayList<>();

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
        plugin = this;

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new JoinQuitListener(), this);
        pm.registerEvents(new MotdListener(), this);
        pm.registerEvents(new SpyListener(), this);

        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("op").setExecutor(new OPCommand());
        getCommand("deop").setExecutor(new DeopCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("adminchat").setExecutor(new AdminChatCommand());
        getCommand("admin").setExecutor(new AdminCommand());
        getCommand("advertisement").setExecutor(new AdminBroadcastCommand());
        getCommand("ban").setExecutor(new AdminBanCommand());
        getCommand("staff").setExecutor(new StaffCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("sun").setExecutor(new SunCommand());
        getCommand("rain").setExecutor(new RainCommand());
        getCommand("tp").setExecutor(new TPCommand());
        getCommand("killall").setExecutor(new KillallCommand());
        getCommand("chatclear").setExecutor(new ChatClearCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("msg").setExecutor(new MSGCommand());
        getCommand("spy").setExecutor(new SpyCommand());
        getCommand("adminhilfe").setExecutor(new AdminhilfeCommand());

        getCommand("home").setExecutor(new HomeCommand());
        getCommand("sethome").setExecutor(new SethomeCommand());
        getCommand("delhome").setExecutor(new DelhomeCommand());
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

    public static String getAdminChat() {
        return "§8» §cAdminChat §8• §7";
    }

    public static TablistManager getTablistManager() {
        return tablistManager;
    }

    public static Main getPlugin() {
        return plugin;
    }
}
