package io.github.dotheflopboy.basic.listeners;

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


       // e.setFormat("%s"+ ChatColor.DARK_GRAY + " » " + ChatColor.RESET + "%s");


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
