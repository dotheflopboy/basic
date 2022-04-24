package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player p){

            if(cmd.getName().equalsIgnoreCase("heal")){
                if(args.length == 0){

                    if(!p.hasPermission("basic.command.heal")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.sendMessage(Messages.message("messages.commands.heal.self"));





                } else if(args.length == 1){
                    Player target = p.getServer().getPlayer(args[0]);

                    if(!p.hasPermission("basic.command.heal.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage(Messages.message("messages.commands.heal.noTarget"));
                        return true;
                    }

                    target.setHealth(20);
                    target.setFoodLevel(20);
                    target.sendMessage(Messages.message("messages.commands.heal.self"));
                    p.sendMessage(Messages.message("messages.commands.heal.other"));


                }

            }

        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }
        return true;
    }
}
