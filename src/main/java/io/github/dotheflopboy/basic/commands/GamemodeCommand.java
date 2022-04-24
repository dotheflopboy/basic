package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player p) {

            if(label.equalsIgnoreCase("gamemode") || label.equalsIgnoreCase("gm")){
                if(args.length == 0){
                    if (!p.hasPermission("basic.command.gamemode")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    p.sendMessage(Messages.message("messages.commands.gamemode.usage"));

                } else if(args.length == 1){
                    String gm = args[0];


                    if(gm.equalsIgnoreCase("survival") || gm.equalsIgnoreCase("0")){
                        if(!p.hasPermission("basic.command.gamemode.survival")){
                            p.sendMessage(Messages.message("messages.info.noPermission"));
                            return true;
                        }

                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Messages.message("messages.commands.gamemode.survival.self"));

                    } else if(gm.equalsIgnoreCase("creative") || gm.equalsIgnoreCase("1")){
                        if(!p.hasPermission("basic.command.gamemode.creative")){
                            p.sendMessage(Messages.message("messages.info.noPermission"));
                            return true;
                        }

                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Messages.message("messages.commands.gamemode.creative.self"));

                    } else if(gm.equalsIgnoreCase("adventure") || gm.equalsIgnoreCase("2")){
                        if(!p.hasPermission("basic.command.gamemode.adventure")){
                            p.sendMessage(Messages.message("messages.info.noPermission"));
                            return true;
                        }

                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Messages.message("messages.commands.gamemode.adventure.self"));

                    } else if (gm.equalsIgnoreCase("spectator") || gm.equalsIgnoreCase("3")){
                        if(!p.hasPermission("basic.command.gamemode.spectator")){
                            p.sendMessage(Messages.message("messages.info.noPermission"));
                            return true;
                        }

                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(Messages.message("messages.commands.gamemode.spectator.self"));

                    } else {
                        p.sendMessage(Messages.message("messages.commands.gamemode.noGamemode"));
                    }
                } else if(args.length == 2){

                    String gm = args[0];
                    String spieler = args[1];
                    Player target = p.getServer().getPlayer(spieler);

                    if(!p.hasPermission("basic.command.gamemode.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    if(target == null){
                        p.sendMessage(Messages.message("messages.commands.gamemode.noTarget"));
                        return true;
                    }


                    if(gm.equalsIgnoreCase("survival") || gm.equalsIgnoreCase("0")){

                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(Messages.message("messages.commands.gamemode.survival.self"));
                        p.sendMessage(Messages.message("messages.commands.gamemode.survival.other"));


                    } else if(gm.equalsIgnoreCase("creative") || gm.equalsIgnoreCase("1")){

                        target.setGameMode(GameMode.CREATIVE);
                        target.sendMessage(Messages.message("messages.commands.gamemode.creative.self"));
                        p.sendMessage(Messages.message("messages.commands.gamemode.creative.other"));

                    } else if(gm.equalsIgnoreCase("adventure") || gm.equalsIgnoreCase("2")){

                        target.setGameMode(GameMode.ADVENTURE);
                        target.sendMessage(Messages.message("messages.commands.gamemode.adventure.self"));
                        p.sendMessage(Messages.message("messages.commands.gamemode.adventure.other"));

                    } else if(gm.equalsIgnoreCase("spectator") || gm.equalsIgnoreCase("3")){

                        target.setGameMode(GameMode.SPECTATOR);
                        target.sendMessage(Messages.message("messages.commands.gamemode.spectator.self"));
                        p.sendMessage(Messages.message("messages.commands.gamemode.spectator.other"));

                    }



                }

            } else if(label.equalsIgnoreCase("gms")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.gamemode.survival")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(Messages.message("messages.commands.gamemode.survival.self"));
                } else if(args.length == 1){
                    if (!p.hasPermission("basic.command.gamemode.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }
                    Player target = p.getServer().getPlayer(args[0]);

                    if(target == null){
                        p.sendMessage(Messages.message("messages.commands.gamemode.noTarget"));
                        return true;
                    }

                    target.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(Messages.message("messages.commands.gamemode.survival.other"));
                    target.sendMessage(Messages.message("messages.commands.gamemode.survival.self"));


                }
            } else if(label.equalsIgnoreCase("gmc")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.gamemode.creative")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Messages.message("messages.commands.gamemode.creative.self"));
                } else if(args.length == 1){
                    if (!p.hasPermission("basic.command.gamemode.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }
                    Player target = p.getServer().getPlayer(args[0]);

                    if(target == null){
                        p.sendMessage(Messages.message("messages.commands.gamemode.noTarget"));
                        return true;
                    }

                    target.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Messages.message("messages.commands.gamemode.creative.other"));
                    target.sendMessage(Messages.message("messages.commands.gamemode.creative.self"));


                }
            } else if(label.equalsIgnoreCase("gma")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.gamemode.adventure")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(Messages.message("messages.commands.gamemode.adventure.self"));
                } else if(args.length == 1){
                    if (!p.hasPermission("basic.command.gamemode.others")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }
                    Player target = p.getServer().getPlayer(args[0]);

                    if(target == null){
                        p.sendMessage(Messages.message("messages.commands.gamemode.noTarget"));
                        return true;
                    }

                    target.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(Messages.message("messages.commands.gamemode.adventure.other"));
                    target.sendMessage(Messages.message("messages.commands.gamemode.adventure.self"));


                }
            } else if(label.equalsIgnoreCase("gmsp")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.gamemode.spectator")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(Messages.message("messages.commands.gamemode.spectator.self"));
                }
            } else if(args.length == 1){
                if (!p.hasPermission("basic.command.gamemode.others")){
                    p.sendMessage(Messages.message("messages.info.noPermission"));
                    return true;
                }
                Player target = p.getServer().getPlayer(args[0]);

                if(target == null){
                    p.sendMessage(Messages.message("messages.commands.gamemode.noTarget"));
                    return true;
                }

                target.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(Messages.message("messages.commands.gamemode.spectator.other"));
                target.sendMessage(Messages.message("messages.commands.gamemode.spectator.self"));


            }

        } else {
            sender.sendMessage(Messages.message("messages.info.noConsoleCommand"));
        }





        return true;
    }
}
