package io.github.spikey84.spikeytag.commands;

import io.github.spikey84.spikeytag.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinTag implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        Player player = (Player) sender;
        if(!Main.players.contains(Bukkit.getOfflinePlayer(player.getUniqueId()))) {
            Main.players.add(Bukkit.getOfflinePlayer(player.getUniqueId()));
            player.sendMessage("You have joined the tag game!");
            Main.setGlow();
            return true;
        }
        return false;
    }

}
