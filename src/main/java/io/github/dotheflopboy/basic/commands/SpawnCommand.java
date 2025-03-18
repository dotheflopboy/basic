package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.Basic;
import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {



    public boolean spawnExist(){
        if(Basic.getPlugin().getConfig().get("spawn") == null){
            return false;

        }
        return true;
    }

    public Location getSpawn(){
        FileConfiguration cfg = Basic.getPlugin().getConfig();

        String worldName = cfg.getString("spawn.world");
        double x = cfg.getDouble("spawn.x");
        double y = cfg.getDouble("spawn.y");
        double z = cfg.getDouble("spawn.z");
        int yaw = cfg.getInt("spawn.yaw");
        int pitch = cfg.getInt("spawn.pitch");


        World world = null;
        if (worldName != null) {
            world = Bukkit.getWorld(worldName);
        }

        Location loc = new Location(world,x,y,z,yaw,pitch);
        return loc;
    }

    public void delSpawn(){
        FileConfiguration cfg = Basic.getPlugin().getConfig();
        cfg.set("spawn", null);
        Basic.getPlugin().saveConfig();
    }

    public void setSpawn(Player p){
        FileConfiguration cfg = Basic.getPlugin().getConfig();
        Location location = p.getLocation();
        cfg.set("spawn.world",location.getWorld().getName());
        cfg.set("spawn.x",location.getX());
        cfg.set("spawn.y",location.getY());
        cfg.set("spawn.z",location.getZ());
        cfg.set("spawn.pitch",location.getPitch());
        cfg.set("spawn.yaw",location.getYaw());
        Basic.getPlugin().saveConfig();

    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String @NotNull [] args) {

        if(!(sender instanceof Player p)){
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
            return true;
        }

        if(label.equalsIgnoreCase("spawn")){

            if(args.length == 0){

                if(!(p.hasPermission("basic.command.spawn"))){
                    p.sendMessage(Messages.message("messages.info.noPermission"));
                    return true;
                }

                if(!spawnExist()){
                    p.sendMessage(Messages.message("messages.commands.spawn.noSpawnPoint"));
                    return true;
                }

                Location loc = getSpawn();

                p.teleport(loc);
                p.sendMessage(Messages.message("messages.commands.spawn.teleported.self"));


            } else if (args.length == 1){

                if(!(p.hasPermission("basic.command.spawn.others"))){
                    p.sendMessage(Messages.message("messages.info.noPermission"));
                    return true;
                }

                Player target = Bukkit.getServer().getPlayer(args[0]);

                if(target == null){
                    p.sendMessage(Messages.message("messages.commands.spawn.noTarget"));
                    return true;
                }

                if(!spawnExist()){
                    p.sendMessage(Messages.message("messages.commands.spawn.noSpawnPoint"));
                    return true;
                }

                Location loc = getSpawn();
                target.teleport(loc);
                target.sendMessage(Messages.message("messages.commands.spawn.teleported.self"));
                p.sendMessage(Messages.message("messages.commands.spawn.teleported.other"));

            }
        } else if (label.equalsIgnoreCase("setspawn")){

            if(args.length == 0){

                if(!(p.hasPermission("basic.command.setspawn"))){
                    p.sendMessage(Messages.message("messages.info.noPermission"));
                    return true;
                }

                setSpawn(p);
                p.sendMessage(Messages.message("messages.commands.spawn.setspawn.set.yourLocation"));



            }

        } else if (label.equalsIgnoreCase("delspawn")){

            if(args.length == 0){

                if(!(p.hasPermission("basic.command.delspawn"))){
                    p.sendMessage(Messages.message("messages.info.noPermission"));
                    return true;
                }

                if(!spawnExist()){
                    p.sendMessage(Messages.message("messages.commands.spawn.noSpawnPoint"));
                    return true;
                }

                delSpawn();
                p.sendMessage(Messages.message("messages.commands.spawn.delspawn"));


            }
        }




        return true;
    }






}
