package dev.locationapi.easycommand.utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FileAPI {

    private File f;
    private YamlConfiguration c;

    public FileAPI(String FilePath, String FileName) {
        this.f = new File(FilePath, FileName);
        this.c = YamlConfiguration.loadConfiguration(this.f);
    }

    public FileAPI setValues(String ValuePath, Object Value) {
        c.set(ValuePath, Value);

        return this;
    }

    public Object getObject(String ValuePath) {
        return c.get(ValuePath);
    }

    public int getInt(String ValuePath) {
        return c.getInt(ValuePath);
    }

    public String getString(String ValuePath) {
        return c.getString(ValuePath);
    }

    public boolean getBoolean(String ValuePath) {
        return c.getBoolean(ValuePath);
    }

    public long getLong(String ValuePath) {
        return c.getLong(ValuePath);
    }
    public double getDouble(String ValuePath) {
        return c.getDouble(ValuePath);
    }

    public List<String> getList(String ValuePath) {
        return c.getStringList(ValuePath);
    }

    public Set<String> getKeys(boolean deep){
        return c.getKeys(deep);
    }

    public ConfigurationSection getConfigurationSection(String Section) {
        return c.getConfigurationSection(Section);
    }

    public FileAPI save() {
        try {

            this.c.save(this.f);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}