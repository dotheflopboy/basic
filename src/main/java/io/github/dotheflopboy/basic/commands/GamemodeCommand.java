package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.Basic;
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
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    p.sendMessage("[Basic] Verwende /gamemode [survival/creative/adventure/spectator]");

                } else if(args.length == 1){
                    String gm = args[0];


                    if(gm.equalsIgnoreCase("survival") || gm.equalsIgnoreCase("0")){
                        if(!p.hasPermission("basic.command.gamemode.survival")){
                            p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                            return true;
                        }

                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage("[Basic] Du hast dein Gamemode auf survival gesetzt.");

                    } else if(gm.equalsIgnoreCase("creative") || gm.equalsIgnoreCase("1")){
                        if(!p.hasPermission("basic.command.gamemode.creative")){
                            p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                            return true;
                        }

                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage("[Basic] Du hast dein Gamemode auf creative gesetzt");

                    } else if(gm.equalsIgnoreCase("adventure") || gm.equalsIgnoreCase("2")){
                        if(!p.hasPermission("basic.command.gamemode.adventure")){
                            p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                            return true;
                        }

                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage("[Basic] Du hast dein Gamemode auf adventure gesetzt");

                    } else if (gm.equalsIgnoreCase("spectator") || gm.equalsIgnoreCase("3")){
                        if(!p.hasPermission("basic.command.gamemode.spectator")){
                            p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                            return true;
                        }

                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage("[Basic] Du hast dein Gamemode auf spectator gesetzt");

                    } else {
                        p.sendMessage("[Basic] Kein Gamemode ausgewählt.");
                    }
                } else if(args.length == 2){

                    p.sendMessage("2 argumente angegeben. /gamemode {gm} {Spieler}");
                    String gm = args[0];
                    String spieler = args[1];
                    Player target = p.getServer().getPlayer(spieler);

                    if(!p.hasPermission("basic.command.gamemode.others")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    if(target == null){
                        p.sendMessage("[Basic] Der Spieler " + spieler + " ist nicht online.");
                        return true;
                    }


                    if(gm.equalsIgnoreCase("survival") || gm.equalsIgnoreCase("0")){

                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage("[Basic] Dein Gamemode wurde auf survival gesetzt.");
                        p.sendMessage("[Basic] Du hast "+ spieler + "s Gamemode auf survival gesetzt.");


                    } else if(gm.equalsIgnoreCase("creative") || gm.equalsIgnoreCase("1")){

                        target.setGameMode(GameMode.CREATIVE);
                        target.sendMessage("[Basic] Dein Gamemode wurde auf creative gesetzt.");
                        p.sendMessage("[Basic] Du hast "+ spieler + "s Gamemode auf creative gesetzt.");

                    } else if(gm.equalsIgnoreCase("adventure") || gm.equalsIgnoreCase("2")){

                        target.setGameMode(GameMode.ADVENTURE);
                        target.sendMessage("[Basic] Dein Gamemode wurde auf adventure gesetzt.");
                        p.sendMessage("[Basic] Du hast "+ spieler + "s Gamemode auf adventure gesetzt.");

                    } else if(gm.equalsIgnoreCase("spectator") || gm.equalsIgnoreCase("3")){

                        target.setGameMode(GameMode.SPECTATOR);
                        target.sendMessage("[Basic] Dein Gamemode wurde auf spectator gesetzt.");
                        p.sendMessage("[Basic] Du hast "+ spieler + "s Gamemode auf spectator gesetzt.");

                    }



                }

            } else if(label.equalsIgnoreCase("gms")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.gamemode.survival")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage("[Basic] Du hast dein Gamemode auf survival gesetzt.");
                } else if(args.length == 1){
                    if (!p.hasPermission("basic.command.gamemode.others")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }
                    Player target = p.getServer().getPlayer(args[0]);

                    if(target == null){
                        p.sendMessage("[Basic] der Spieler " + args[0] + " ist nicht online.");
                        return true;
                    }

                    target.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage("[Basic] Du hast "+ args[0]+ "s Gamemode auf survival gesetzt.");
                    target.sendMessage("[Basic] Dein Gamemode wurde auf survival gesetzt.");


                }
            } else if(label.equalsIgnoreCase("gmc")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.gamemode.creative")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("[Basic] Du hast dein Gamemode auf creative gesetzt.");
                } else if(args.length == 1){
                    if (!p.hasPermission("basic.command.gamemode.others")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }
                    Player target = p.getServer().getPlayer(args[0]);

                    if(target == null){
                        p.sendMessage("[Basic] der Spieler " + args[0] + " ist nicht online.");
                        return true;
                    }

                    target.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("[Basic] Du hast "+ args[0]+ "s Gamemode auf creative gesetzt.");
                    target.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));


                }
            } else if(label.equalsIgnoreCase("gma")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.gamemode.adventure")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage("[Basic] Du hast dein Gamemode auf adventure gesetzt.");
                } else if(args.length == 1){
                    if (!p.hasPermission("basic.command.gamemode.others")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }
                    Player target = p.getServer().getPlayer(args[0]);

                    if(target == null){
                        p.sendMessage("[Basic] der Spieler " + args[0] + " ist nicht online.");
                        return true;
                    }

                    target.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage("[Basic] Du hast "+ args[0]+ "s Gamemode auf adventure gesetzt.");
                    target.sendMessage("[Basic] Dein Gamemode wurde auf adventure gesetzt.");


                }
            } else if(label.equalsIgnoreCase("gmsp")){
                if(args.length == 0){
                    if(!p.hasPermission("basic.command.gamemode.spectator")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage("[Basic] Du hast dein Gamemode auf spectator gesetzt.");
                }
            } else if(args.length == 1){
                if (!p.hasPermission("basic.command.gamemode.others")){
                    p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                    return true;
                }
                Player target = p.getServer().getPlayer(args[0]);

                if(target == null){
                    p.sendMessage("[Basic] der Spieler " + args[0] + " ist nicht online.");
                    return true;
                }

                target.setGameMode(GameMode.SPECTATOR);
                p.sendMessage("[Basic] Du hast "+ args[0]+ "s Gamemode auf spectator gesetzt.");
                target.sendMessage("[Basic] Dein Gamemode wurde auf spectator gesetzt.");


            }

        } else {
            sender.sendMessage("[Basic] Dieser Befehl geht nur im Spiel.");
        }





        return true;
    }
}
