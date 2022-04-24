package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class FlyCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if(sender instanceof Player p){

            if(cmd.getName().equalsIgnoreCase("fly")){
                if(args.length == 0){

                    if(!p.hasPermission("basic.command.fly")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if(!p.getAllowFlight()){
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage(Messages.message("messages.commands.fly.self.on"));
                    }else {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage(Messages.message("messages.commands.fly.self.off"));
                    }



                } else if(args.length == 1){
                    Player target = p.getServer().getPlayer(args[0]);

                    if(!p.hasPermission("basic.command.fly.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage(Messages.message("messages.commands.fly.noTarget"));
                        return true;
                    }

                    if(!target.getAllowFlight()){
                        target.setAllowFlight(true);
                        target.setFlying(true);
                        p.sendMessage(Messages.message("messages.commands.fly.other.on"));
                    } else {
                        target.setAllowFlight(false);
                        target.setFlying(false);
                        p.sendMessage(Messages.message("messages.commands.fly.other.off"));
                    }

                }

            }

        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }
        return true;
    }
}
