package io.github.dotheflopboy.basic.tabcompleters;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GamemodeTabComplete implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        List<String> list = new ArrayList<>();

        if(label.equalsIgnoreCase("gamemode") || label.equalsIgnoreCase("gm")){
            if(args.length == 1){
                list.add("survival");
                list.add("creative");
                list.add("adventure");
                list.add("spectator");
                return list;
            } else if (args.length == 2){


                Bukkit.getOnlinePlayers().forEach(p -> list.add(p.getName()));
                return  list;
            }
        }


        return null;
    }

}
