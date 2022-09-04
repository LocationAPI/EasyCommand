package dev.locationapi.easycommand.commands.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminhilfeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(args.length == 0) {
            HelpPage(player, 1);

        } else if(args.length == 1) {
            try {
                int page = Integer.parseInt(args[0]);
                HelpPage(player, page);
            }catch (Exception e) {

            }
        }

        return false;
    }

    public static void HelpPage(Player player, int page) {
        if(player.hasPermission("easycommand.adminhelp")) {
            if(page == 1) {
                player.sendMessage("§8─────────[ §5Admin§8-§5Hilfe §7Seite §d1 §8]─────────");
                player.sendMessage("");
                player.sendMessage("§8» §d/ad §8- §7Sende eine Broadcast");
                player.sendMessage("§8» §d/ac §8- §7Schreibe im AdminChat mit allen Server-Admins");
                player.sendMessage("§8» §d/admin §8<§7on§8|§7off§8>§8- §7Geh in den Adminmodus");
                player.sendMessage("§8» §d/vanish §8- §7Mach dich unsichtbar um keinen zu Stören");
                player.sendMessage("§8» §d/chatclear §8- §7Entleere den Chat");
                player.sendMessage("§8» §d/day §8- §7Setze die Zeit auf Tag");
                player.sendMessage("§8» §d/night §8- §7Setze die Zeit auf Nacht");
                player.sendMessage("§8» §d/sun §8- §7Setze das Wetter auf Regen");
                player.sendMessage("§8» §d/chatclear §8- §7Entleere den Chat");
                player.sendMessage("");
                player.sendMessage("§8─────────[ §5Admin§8-§5Hilfe §8]─────────");
            } else if(page == 2) {
                player.sendMessage("§8─────────[ §5Admin§8-§5Hilfe §7Seite §d2 §8]─────────");
                player.sendMessage("");
                player.sendMessage("§8» §d/op §8<§7player§8> §8- §7Setze einen Spieler zum Operator");
                player.sendMessage("§8» §d/deop §8<§7player§8> §8- §7Nimm den Operator vom Spieler weg");
                player.sendMessage("§8» §d/fly §8<§7player§8>§8- §7Setze dich oder einen Spieler in den Flugmodus");
                player.sendMessage("§8» §d/gm §8<§70,1,2,3§8> §8<§7player§8> §8- §7Setze dich in den Gamemode");
                player.sendMessage("§8» §d/feed §8<§7player§8> §8- §7Still deinen oder einem Spieler den Hunger");
                player.sendMessage("§8» §d/heal §8<§7player§8> §8- §7Heil dein oder einem Spieler das Leben");
                player.sendMessage("§8» §d/killall §8- §7Töte alle Tiere & Monster in der Umgebung");
                player.sendMessage("§8» §d/tp §8<§7player§8> §8- §7Teleportiere dich zu einem Spieler");
                player.sendMessage("§8» §d/spy §8- §7Überprüfe von anderen die Commands");
                player.sendMessage("");
                player.sendMessage("§8─────────[ §5Admin§8-§5Hilfe §8]─────────");
            }
        }
    }
}
