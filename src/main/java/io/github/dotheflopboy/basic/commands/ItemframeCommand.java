package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ItemframeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String @NotNull [] args) {

        if(!(sender instanceof Player p)){
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
            return true;
        }

        if(label.equalsIgnoreCase("itemframe")){

            if(args.length == 0){
                p.sendMessage("usageCommand");
                return true;
            } else if(args.length == 1) {

                if (!p.hasPermission("basic.command.itemframe")) {
                    p.sendMessage(Messages.message("messages.info.noPermission"));
                    return true;
                }

                // (invisible/fixed/invulnerable/all)
                String arg = args[0];

                if (arg.equalsIgnoreCase("invisible")){

                    if (!p.hasPermission("basic.command.itemframe.invisible")) {
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }


                    Entity iframe = p.getTargetEntity(5);


                    if(iframe == null){
                        return true;
                    }

                    if(iframe instanceof ItemFrame){
                        ((ItemFrame) iframe).setVisible(iframe.isInvisible());
                    }



                }

            }



        }

        return true;
    }
}
