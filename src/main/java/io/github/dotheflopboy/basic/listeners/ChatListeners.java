package io.github.dotheflopboy.basic.listeners;

import io.github.dotheflopboy.basic.Basic;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatListeners implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("basic.chat.colors.*")){
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        }



        String text = Basic.getPlugin().getConfig().getString("messages.chatformat");
        String format = ChatColor.translateAlternateColorCodes('&', text);

        TextReplacementConfig replacement1 = TextReplacementConfig.builder()
                .match("\\%player\\%")
                .replacement("%s")
                .build();
        TextReplacementConfig replacement2 = TextReplacementConfig.builder()
                .match("\\%msg\\%")
                .replacement("%s")
                .build();


        final Component chatFormat = MiniMessage.miniMessage().deserialize(text).replaceText(replacement1).replaceText(replacement2);

        e.setFormat(ChatColor.translateAlternateColorCodes('&',LegacyComponentSerializer.legacyAmpersand().serialize(chatFormat)));
        // format.replace("%player%", "%s").replace("%msg%", "%s")


        if(p.hasPermission("basic.chat.ping")) {
            for (Player target : Bukkit.getServer().getOnlinePlayers()) {
                if (e.getMessage().contains("@" + target.getName())) {
                    target.sendMessage("Du wurdest von " + p.getName() + " erwähnt!");
                    e.setMessage(e.getMessage().replace("@" + target.getName(), ChatColor.translateAlternateColorCodes('&', "&b@" + target.getName() + "&r")));
                }

            }
        }

    }



}
