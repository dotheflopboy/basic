package io.github.dotheflopboy.basic.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BasicTabComplete implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        List<String> list = new ArrayList<>();

        if(cmd.getName().equalsIgnoreCase("basic")) {
            if (args.length == 1) {
                list.add("reload");
                list.add("help");
                return list;
            }


        }
        return null;
    }


}
