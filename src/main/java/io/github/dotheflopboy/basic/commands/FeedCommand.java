package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player p) {

            if (cmd.getName().equalsIgnoreCase("feed")) {
                if (args.length == 0) {

                    if (!p.hasPermission("basic.command.feed")) {
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    p.setFoodLevel(20);
                    p.sendMessage(Messages.message("messages.commands.feed.self"));


                } else if (args.length == 1) {
                    Player target = p.getServer().getPlayer(args[0]);

                    if (!p.hasPermission("basic.command.feed.others")) {
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage(Messages.message("messages.commands.feed.noTarget"));
                        return true;
                    }

                    target.setFoodLevel(20);
                    target.sendMessage(Messages.message("messages.commands.feed.self"));
                    p.sendMessage(Messages.message("messages.commands.feed.other"));

                }

            }

        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }
        return true;
    }
}