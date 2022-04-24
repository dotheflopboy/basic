package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.Basic;
import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GodCommand implements CommandExecutor {

    public static ArrayList<String> gods = new ArrayList<>();
    //ToDo Mobs should ignore you
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if(sender instanceof Player p) {

            if(cmd.getName().equalsIgnoreCase("god")){
                if(args.length == 0){

                    if(!p.hasPermission("basic.command.god")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if(gods.contains(p.getName())) {

                        gods.remove(p.getName());
                        p.sendMessage(Messages.message("messages.commands.god.self.off"));
                        return true;

                    }

                    gods.add(p.getName());
                    p.sendMessage(Messages.message("messages.commands.god.self.on"));

                } else if(args.length == 1){
                    Player target = p.getServer().getPlayer(args[0]);

                    if(!p.hasPermission("basic.command.god.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage(Messages.message("messages.commands.god.noTarget"));
                        return true;
                    }

                    if(gods.contains(target.getName())) {

                        gods.remove(target.getName());
                        target.sendMessage(Messages.message("messages.commands.god.self.off"));
                        return true;

                    }

                    gods.add(target.getName());
                    target.sendMessage(Messages.message("messages.commands.god.self.on"));


                }

            }


        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }

        return true;
    }
}
