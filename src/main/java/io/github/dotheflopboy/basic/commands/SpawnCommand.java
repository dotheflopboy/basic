package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.Basic;
import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player p){
            if(label.equalsIgnoreCase("spawn")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.spawn")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    Location loc = Basic.getPlugin().getConfig().getLocation("spawn.spawnPoint");

                    if(loc == null){
                        p.sendMessage(Messages.message("messages.commands.spawn.noSpawnPoint"));
                        return true;
                    }

                    p.teleport(loc);
                    p.sendMessage(Messages.message("messages.commands.spawn.teleported.self"));

                } else if(args.length == 1){
                    if(!p.hasPermission("basic.command.spawn.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    Player target = Bukkit.getServer().getPlayer(args[0]);

                    if(target == null){
                        p.sendMessage(Messages.message("messages.commands.spawn.noTarget"));
                        return true;
                    }

                    Location loc = Basic.getPlugin().getConfig().getLocation("spawn.spawnPoint");

                    if(loc == null){
                        p.sendMessage(Messages.message("messages.commands.spawn.noSpawnPoint"));
                        return true;
                    }

                    target.teleport(loc);
                    target.sendMessage(Messages.message("messages.commands.spawn.teleported.self"));
                    p.sendMessage(Messages.message("messages.commands.spawn.teleported.other"));


                }
            } else if(label.equalsIgnoreCase("setspawn")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.setspawn")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    Location location = p.getLocation();
                    Basic.getPlugin().getConfig().set("spawn.spawnPoint",location);
                    Basic.getPlugin().saveConfig();
                    p.sendMessage(Messages.message("messages.commands.spawn.setspawn.set.yourLocation"));


                }

            } else if(label.equalsIgnoreCase("delspawn")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.delspawn")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    Location loc = Basic.getPlugin().getConfig().getLocation("spawn.spawnPoint");

                    if(loc == null){
                        p.sendMessage(Messages.message("messages.commands.spawn.noSpawnPoint"));
                        return true;
                    }

                    Basic.getPlugin().getConfig().set("spawn.spawnPoint",null);
                    Basic.getPlugin().saveConfig();
                    p.sendMessage(Messages.message("messages.commands.spawn.delspawn"));


                }


            }

        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }

        return true;
    }
}
