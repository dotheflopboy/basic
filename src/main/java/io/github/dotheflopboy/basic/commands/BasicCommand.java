package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.Basic;
import io.github.dotheflopboy.basic.util.Messages;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BasicCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {


        if(sender instanceof Player p){

            if(cmd.getName().equalsIgnoreCase("basic")){

                if(args.length == 1){
                    String arg = args[0];
                    if(arg.equalsIgnoreCase("reload")){
                        if(!p.hasPermission("basic.command.reload")){
                            p.sendMessage(Messages.message("messages.info.noPermission"));
                            return true;
                        }

                        Basic.getPlugin().reloadConfig();
                        p.sendMessage(Messages.message("messages.commands.basic.configReload"));

                    } else if(arg.equalsIgnoreCase("help")){
                        if(!p.hasPermission("basic.command.help")){
                            p.sendMessage(Messages.message("messages.info.noPermission"));
                            return true;
                        }
                        Component line = MiniMessage.miniMessage().deserialize("<yellow>------------------------------------------------");
                        Component l1 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/basic {reload/help} - <green>Plugins main Command.");
                        Component l2 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/god {player} - <green>Setzt einen Spieler in Gottmodus.");
                        Component l3 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/feed {player} - <green>Sättigt einen Spieler.");
                        Component l4 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/heal {player} - <green>Heilt einen Spieler.");
                        Component l5 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/clearinventory {player} - <green>Leert das Inventar eines Spielers.");
                        Component l6 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/fly {player} - <green>Aktiviert/Deaktiviert den Flugmodus.");
                        Component l7 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/gamemode {0/1/2/3} {player} - <green>Setzt den Spielmodus eines Spielers.");
                        Component l8 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/colors - <green>Zeigt die Minecraft Farbcodes an.");
                        Component l9 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/repair {hand/all} - <green>Repariert deine Items.");
                        Component l10 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/workbench - <green>Öffnet eine Werkbank.");



                        p.sendMessage(line);
                        p.sendMessage(l1);
                        p.sendMessage(l2);
                        p.sendMessage(l3);
                        p.sendMessage(l4);
                        p.sendMessage(l5);
                        p.sendMessage(l6);
                        p.sendMessage(l7);
                        p.sendMessage(l8);
                        p.sendMessage(l9);
                        p.sendMessage(l10);
                        p.sendMessage(line);
                    }
                }

            }

        } else {


            if(cmd.getName().equalsIgnoreCase("basic")){

                if(args.length == 1){
                    String arg = args[0];
                    if(arg.equalsIgnoreCase("reload")){

                        Basic.getPlugin().reloadConfig();
                        sender.sendMessage(Messages.message("messages.commands.basic.configReload"));

                    } else if(arg.equalsIgnoreCase("help")){

                        Component line = MiniMessage.miniMessage().deserialize("<yellow>------------------------------------------------");
                        Component l1 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/basic {reload/help} - <green>Plugins main Command.");
                        Component l2 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/god {player} - <green>Setzt einen Spieler in Gottmodus.");
                        Component l3 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/feed {player} - <green>Sättigt einen Spieler.");
                        Component l4 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/heal {player} - <green>Heilt einen Spieler.");
                        Component l5 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/clearinventory {player} - <green>Leert das Inventar eines Spielers.");
                        Component l6 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/fly {player} - <green>Aktiviert/Deaktiviert den Flugmodus.");
                        Component l7 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/gamemode {0/1/2/3} {player} - <green>Setzt den Spielmodus eines Spielers.");
                        Component l8 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/colors - <green>Zeigt die Minecraft Farbcodes an.");
                        Component l9 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/repair {hand/all} - <green>Repariert deine Items.");
                        Component l10 = MiniMessage.miniMessage().deserialize("<dark_gray>» <yellow>/workbench - <green>Öffnet eine Werkbank.");


                        sender.sendMessage(line);
                        sender.sendMessage(l1);
                        sender.sendMessage(l2);
                        sender.sendMessage(l3);
                        sender.sendMessage(l4);
                        sender.sendMessage(l5);
                        sender.sendMessage(l6);
                        sender.sendMessage(l7);
                        sender.sendMessage(l8);
                        sender.sendMessage(l9);
                        sender.sendMessage(l10);
                        sender.sendMessage(line);

                    }
                }

            }


        }

        return true;
    }
}
