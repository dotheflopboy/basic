package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.Basic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("heal")){
                if(args.length == 0){

                    if(!p.hasPermission("basic.command.heal")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    p.setHealth(20);
                    p.setFoodLevel(20);





                } else if(args.length == 1){
                    Player target = p.getServer().getPlayer(args[0]);

                    if(!p.hasPermission("basic.command.heal.others")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage("[Basic] der Spieler " + args[0] + " ist nicht online.");
                        return true;
                    }

                    target.setHealth(20);
                    target.setFoodLevel(20);

                }

            }

        } else {
            sender.sendMessage("[Basic] Dieser Befehl geht nur im Spiel!");
        }
        return true;
    }
}
