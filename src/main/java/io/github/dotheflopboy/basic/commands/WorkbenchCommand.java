package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WorkbenchCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args){

        if(sender instanceof Player p){
            if(label.equalsIgnoreCase("workbench")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.workbench")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    p.openWorkbench(null, true);
                    p.sendMessage(Messages.message("messages.commands.workbench.self"));


                } else if(args.length == 1) {

                    Player target = p.getServer().getPlayer(args[0]);


                    if(!p.hasPermission("basic.command.workbench.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage(Messages.message("messages.commands.workbench.noTarget"));
                        return true;
                    }

                    target.openWorkbench(null,true);
                    target.sendMessage(Messages.message("messages.commands.workbench.self"));
                    p.sendMessage(Messages.message("messages.commands.workbench.other"));

                }
            } else if(label.equalsIgnoreCase("craft")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.workbench")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    p.openWorkbench(null, true);
                    p.sendMessage(Messages.message("messages.commands.workbench.self"));


                } else if(args.length == 1) {

                    Player target = p.getServer().getPlayer(args[0]);


                    if(!p.hasPermission("basic.command.workbench.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage(Messages.message("messages.commands.workbench.noTarget"));
                        return true;
                    }

                    target.openWorkbench(null,true);
                    target.sendMessage(Messages.message("messages.commands.workbench.self"));
                    p.sendMessage(Messages.message("messages.commands.workbench.other"));

                }


            }


        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }


        return true;
    }


}
