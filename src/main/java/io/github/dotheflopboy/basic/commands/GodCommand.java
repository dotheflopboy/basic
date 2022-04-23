package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.Basic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GodCommand implements CommandExecutor {

    public static ArrayList<String> gods = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("god")){
                if(args.length == 0){

                    if(!p.hasPermission("basic.command.god")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    if(gods.contains(p.getName())) {

                        gods.remove(p.getName());
                        p.sendMessage("[Basic] Du bist nun nicht mehr im Gottmodus!");
                        return true;

                    }

                    gods.add(p.getName());
                    p.sendMessage("[Basic] Du bist nun im Gottmodus!");

                } else if(args.length == 1){
                    Player target = p.getServer().getPlayer(args[0]);

                    if(!p.hasPermission("basic.command.god.others")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage("[Basic] der Spieler " + args[0] + " ist nicht online.");
                        return true;
                    }

                    if(gods.contains(target.getName())) {

                        gods.remove(target.getName());
                        target.sendMessage("[Basic] Du bist nun nicht mehr im Gottmodus!");
                        return true;

                    }

                    gods.add(target.getName());
                    target.sendMessage("[Basic] Du bist nun im Gottmodus!");


                }

            }


        } else {
            sender.sendMessage("[Basic] Dieser Befehl geht nur im Spiel!");
        }

        return true;
    }
}
