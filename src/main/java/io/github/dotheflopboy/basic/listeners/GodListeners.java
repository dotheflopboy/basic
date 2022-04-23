package io.github.dotheflopboy.basic.listeners;


import com.destroystokyo.paper.event.entity.CreeperIgniteEvent;
import io.github.dotheflopboy.basic.commands.GodCommand;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class GodListeners implements Listener {


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        if(ent instanceof Player) {
            Player p = (Player) ent;
            if(GodCommand.gods.contains(p.getName())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamage2(EntityDamageEvent e) {
        Entity ent = e.getEntity();
        if(ent instanceof Player) {
            Player p = (Player) ent;
            if(GodCommand.gods.contains(p.getName())) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onDamage3(EntityDamageByBlockEvent e) {
        Entity ent = e.getEntity();
        if(ent instanceof Player) {
            Player p = (Player) ent;
            if(GodCommand.gods.contains(p.getName())) {
                e.setCancelled(true);
            }
        }
    }


}
