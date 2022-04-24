package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SuicideCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player p){
            if(cmd.getName().equalsIgnoreCase("suicide")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.suicide")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    p.setHealth(0);

                }




            }

        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }
        return true;
    }

}
