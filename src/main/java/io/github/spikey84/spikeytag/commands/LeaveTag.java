package io.github.spikey84.spikeytag.commands;

import io.github.spikey84.spikeytag.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeaveTag implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        Player player = (Player) sender;
        if(!Main.players.contains(Bukkit.getOfflinePlayer(player.getUniqueId()))) {
            Main.players.add(Bukkit.getOfflinePlayer(player.getUniqueId()));
            player.sendMessage("You have left the tag game.");
            if(Main.it == Bukkit.getOfflinePlayer(player.getUniqueId())) {
                Main.it = Main.players.get(0);
                Main.players.get(0).getPlayer().sendMessage("You are now it!");
            }
            return true;
        }
        return false;
    }
}
