package io.github.dotheflopboy.basic.listeners;

import io.github.dotheflopboy.basic.Basic;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListeners implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();
        String quitText = Basic.getPlugin().getConfig().getString("messages.playerQuit");
        quitText = PlaceholderAPI.setPlaceholders(p, quitText);
        final Component message = LegacyComponentSerializer.legacyAmpersand().deserialize(quitText);

        e.quitMessage(message);


    }

}
