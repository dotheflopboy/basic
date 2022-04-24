package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.Basic;
import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearinventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player p) {

            if (cmd.getName().equalsIgnoreCase("clearinventory")) {
                if (args.length == 0) {

                    if (!p.hasPermission("basic.command.clearinventory")) {
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    p.getInventory().clear();
                    p.sendMessage(Messages.message("messages.commands.clearinventory.self"));

                } else if (args.length == 1) {
                    Player target = p.getServer().getPlayer(args[0]);

                    if (!p.hasPermission("basic.command.clearinventory.others")) {
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage(Messages.message("messages.commands.clearinventory.noTarget"));
                        return true;
                    }

                    target.getInventory().clear();
                    target.sendMessage(Messages.message("messages.commands.clearinventory.self"));
                    p.sendMessage(Messages.message("messages.commands.clearinventory.other"));

                }

            }

        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }
        return true;
    }
}