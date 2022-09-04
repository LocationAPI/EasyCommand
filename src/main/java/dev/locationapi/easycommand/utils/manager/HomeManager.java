package dev.locationapi.easycommand.utils.manager;

import dev.locationapi.easycommand.utils.FileAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.Set;
import java.util.UUID;

public class HomeManager {

    private FileAPI fw;

    public HomeManager(UUID uuid) {

        fw = new FileAPI("plugins/HomeSystem", uuid.toString() + ".yml");
    }

    public void addHome(Location loc, String name) {

        fw.setValues(name + ".world", loc.getWorld().getName());
        fw.setValues(name + ".x", loc.getX());
        fw.setValues(name + ".y", loc.getY());
        fw.setValues(name + ".z", loc.getZ());
        fw.setValues(name + ".yaw", loc.getYaw());
        fw.setValues(name + ".pitch", loc.getPitch());

        fw.save();
    }

    public boolean exist(String name) {
        return fw.getString(name) != null;
    }

    public Location getLocation(String name) {
        return new Location(Bukkit.getWorld(fw.getString(name + ".world")), fw.getDouble(name + ".x"), fw.getDouble(name + ".y"), fw.getDouble(name + ".z"), (float)fw.getDouble(name + ".yaw"), (float)fw.getDouble(name + ".pitch"));
    }

    public Set<String> getHomes(){
        return fw.getKeys(false);
    }

    public void delHome(String name) {

        fw.setValues(name, null);
        fw.save();

    }

}