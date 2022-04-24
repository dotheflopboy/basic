package io.github.dotheflopboy.basic.listeners;

import io.github.dotheflopboy.basic.util.Messages;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListeners implements Listener {

    @EventHandler
    public void onPlayerJoins(PlayerJoinEvent e){

        Player p = e.getPlayer();
        Component messageFromConfig = Messages.message("messages.playerJoin");
        TextReplacementConfig replacementConfig = TextReplacementConfig.builder().match("%player%").replacement(p.getName()).build();
        Component message = messageFromConfig.replaceText(replacementConfig);
        e.joinMessage(message);


    }



}
