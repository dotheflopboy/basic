package io.github.dotheflopboy.basic.listeners;

import io.github.dotheflopboy.basic.util.Messages;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListeners implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();
        Component messageFromConfig = Messages.message("messages.playerQuit");
        TextReplacementConfig replacementConfig = TextReplacementConfig.builder().match("%player%").replacement(p.getName()).build();
        Component message = messageFromConfig.replaceText(replacementConfig);
        e.quitMessage(message);

    }

}
