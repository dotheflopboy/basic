package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.Basic;
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
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    p.setFoodLevel(20);


                } else if (args.length == 1) {
                    Player target = p.getServer().getPlayer(args[0]);

                    if (!p.hasPermission("basic.command.feed.others")) {
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage("[Basic] der Spieler " + args[0] + " ist nicht online.");
                        return true;
                    }

                    target.setFoodLevel(20);

                }

            }

        } else {
            sender.sendMessage("[Basic] Dieser Befehl geht nur im Spiel!");
        }
        return true;
    }
}