package io.github.dotheflopboy.basic.listeners;

import io.github.dotheflopboy.basic.Basic;
import io.github.dotheflopboy.basic.util.Messages;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListeners implements Listener {

    @EventHandler
    public void onPlayerJoins(PlayerJoinEvent e){

        Player p = e.getPlayer();
        String joinText = Basic.getPlugin().getConfig().getString("messages.playerJoin");
        joinText = PlaceholderAPI.setPlaceholders(p, joinText);
        //  final Component message = LegacyComponentSerializer.legacyAmpersand().deserialize(joinText);
        final Component msg = MiniMessage.miniMessage().deserialize(joinText);

        e.joinMessage(msg);


    }



}
