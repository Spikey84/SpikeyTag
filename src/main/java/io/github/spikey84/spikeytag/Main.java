package io.github.spikey84.spikeytag;

import io.github.spikey84.spikeytag.commands.JoinTag;
import io.github.spikey84.spikeytag.commands.LeaveTag;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.glow.GlowAPI;

import java.awt.*;
import java.util.ArrayList;

public class Main extends JavaPlugin {
    public static OfflinePlayer it = Bukkit.getOfflinePlayerIfCached("creativename11");
    public static ArrayList<OfflinePlayer> players = new ArrayList<OfflinePlayer>();

    public static Plugin plugin;
    private int counterId;

    @Override
    public void onEnable() {

        getCommand("jointag").setExecutor(new JoinTag());
        getCommand("leavetag").setExecutor(new LeaveTag());

        plugin = this;

        counterId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            public void run() {
                setGlow();
            }
        }, 0,120);

    }

    public static void setGlow() {
        for(OfflinePlayer player : players) {
            GlowAPI.setGlowing((Entity) it.getPlayer(), GlowAPI.Color.PURPLE, player.getPlayer());
        }
    }
}
