package dev.locationapi.easycommand.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    public static ItemStack createItem(Material material, int subid, String displayname) {

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        mitem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE });
        item.setItemMeta(mitem);

        return item;
    }

    public static ItemStack createItemw(Material material, int subid) {

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE });
        item.setItemMeta(mitem);

        return item;
    }

    public static ItemStack createItemAnz(Material material, int subid, int Anzahl, String displayname) {

        ItemStack item = new ItemStack(material, Anzahl, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE });
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);

        return item;
    }

    public static ItemStack createItemAnzw(Material material, int subid, int Anzahl) {

        ItemStack item = new ItemStack(material, Anzahl, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE });
        item.setItemMeta(mitem);

        return item;
    }


    public static ItemStack createItemLore(Material material, int subid, List lore, String displayname) {

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE });
        mitem.setLore(lore);
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);

        return item;
    }

    public static ItemStack createItemLoreEnch(Material material, int subid, List lore, String displayname, Enchantment ench, int lvl) {

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.addEnchant(ench, lvl, true);
        mitem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_UNBREAKABLE });
        mitem.setLore(lore);
        mitem.setDisplayName(displayname);

        item.setItemMeta(mitem);

        return item;
    }

    public static ItemStack createItemlLore(Material material, int subid, int anz, String lore, String displayname) {

        ItemStack item = new ItemStack(material, anz, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE });
        List<String>l = new ArrayList<>();
        l.add("");
        l.add(lore);
        mitem.setLore(l);
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);

        return item;
    }



    public static ItemStack createItemEnch(Material material, int subid, Enchantment ent, int Level , String displayname) {

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);
        item.addUnsafeEnchantment(ent, Level);
        return item;

    }

    public static ItemStack createSkullLore(String owner, String dname, List<String> lore){

        ItemStack item = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short)3);
        SkullMeta mitem = (SkullMeta)item.getItemMeta();
        mitem.setLore(lore);
        mitem.setOwner(owner);
        mitem.setDisplayName(dname);
        item.setItemMeta(mitem);



        return item;

    }

    public static ItemStack createSkull(String owner, String dname){

        ItemStack item = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short)3);
        SkullMeta mitem = (SkullMeta)item.getItemMeta();
        mitem.setOwner(owner);
        mitem.setDisplayName(dname);
        item.setItemMeta(mitem);



        return item;

    }

    public static ItemStack createColor(Material material, Color c, String displayname){
        ItemStack is = new ItemStack(material);
        LeatherArmorMeta lam = (LeatherArmorMeta) is.getItemMeta();
        lam.setDisplayName(displayname);
        List<String>lore = new ArrayList<>();
        lam.setLore(lore);
        lam.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE });
        lam.setColor(c);
        is.setItemMeta(lam);


        return is;

    }

    public static ItemStack createColorLore(Material material, Color c, List<String> lore, String displayname){
        ItemStack is = new ItemStack(material);
        LeatherArmorMeta lam = (LeatherArmorMeta) is.getItemMeta();
        lam.setDisplayName(displayname);
        lam.setLore(lore);
        lam.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        lam.setColor(c);
        is.setItemMeta(lam);


        return is;

    }
}