package io.github.spikey84.spikeytag.events;

import io.github.spikey84.spikeytag.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Hit implements Listener {

    @EventHandler
    public void hit(EntityDamageByEntityEvent event) {
        if(event.getDamager() != Main.it || event.getEntity() instanceof Player) return;
        Player player = (Player) event.getEntity();
        Main.it = player;
    }
}
