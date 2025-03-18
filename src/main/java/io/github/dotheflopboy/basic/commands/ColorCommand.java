package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.util.Messages;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class ColorCommand implements CommandExecutor {



    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player p) {

            if (cmd.getName().equalsIgnoreCase("colors")) {
                if (args.length == 0) {

                    if (!p.hasPermission("basic.command.colors")) {
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }


                    final Component component = MiniMessage.miniMessage().deserialize("<dark_gray>------------------------------------------------<newline>"+
                            "<black>&0 <dark_blue>&1 <dark_green>&2 <dark_aqua>&3 <dark_red>&4 <dark_purple>&5 <gold>&6 <gray>&7<newline>"+
                            "<dark_gray>&8 <blue>&9 <green>&a <aqua>&b <red>&c <light_purple>&d <yellow>&e <white>&f<newline>"+
                            "&l = <bold>Fett</bold>  &o = <i>kursiv</i>  &n = <u>Unterstrichen</u><newline>"+
                            "&m = <st>Durchgestrichen</st>  &k = <obf>Hallo</obf>  &r = <yellow>zurü<reset>ckgesetzt<newline>"+
                            "<dark_gray>------------------------------------------------"
                    );

                    p.sendMessage(component);

                }

            }

        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }
        return true;
    }
}

