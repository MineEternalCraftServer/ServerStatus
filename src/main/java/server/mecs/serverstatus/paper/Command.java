package server.mecs.serverstatus.paper;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender.hasPermission("server.status"))) {
            sender.sendMessage("§cYou are not allowed to use this command.");
            return false;
        }
        return true;
    }
}
