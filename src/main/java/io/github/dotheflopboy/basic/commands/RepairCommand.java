package io.github.dotheflopboy.basic.commands;

import io.github.dotheflopboy.basic.util.Messages;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.jetbrains.annotations.NotNull;

public class RepairCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player p){
            if(cmd.getName().equalsIgnoreCase("repair")){
                if(!p.hasPermission("basic.command.repair")){
                    p.sendMessage(Messages.message("messages.info.noPermission"));
                    return true;
                }

                if(args.length == 0){
                    if(!p.hasPermission("basic.command.repair.hand")){
                        p.sendMessage(Messages.message("messages.info.noPermission"));
                        return true;
                    }

                    ItemStack handItem = p.getInventory().getItemInMainHand();

                    if(handItem == null || handItem.getType().equals(Material.AIR)){
                        p.sendMessage(Messages.message("messages.commands.repair.self.noItem"));
                        return true;
                    }


                    Damageable handItemMeta = (Damageable) handItem.getItemMeta();

                    handItemMeta.setDamage(0);
                    handItem.setItemMeta(handItemMeta);

                    p.sendMessage(Messages.message("messages.commands.repair.self.repaired"));

                } else if(args.length == 1){
                    if (args[0].equalsIgnoreCase("all")) {
                        if(!p.hasPermission("basic.command.repair.all")){
                            p.sendMessage(Messages.message("messages.info.noPermission"));
                            return true;
                        }

                        for(ItemStack item: p.getInventory()){

                            if(item != null) {

                                Damageable itemMeta = (Damageable) item.getItemMeta();
                                itemMeta.setDamage(0);
                                item.setItemMeta(itemMeta);
                            }

                        }

                        p.sendMessage(Messages.message("messages.commands.repair.self.repairedAll"));



                    } else if(args[0].equalsIgnoreCase("hand")){
                        if(!p.hasPermission("basic.command.repair.hand")){
                            p.sendMessage(Messages.message("messages.info.noPermission"));
                            return true;
                        }
                        ItemStack handItem = p.getInventory().getItemInMainHand();

                        if(handItem == null || handItem.getType().equals(Material.AIR)){
                            p.sendMessage(Messages.message("messages.commands.repair.self.noItem"));
                            return true;
                        }
                        Damageable handItemMeta = (Damageable) handItem.getItemMeta();

                        handItemMeta.setDamage(0);
                        handItem.setItemMeta(handItemMeta);

                        p.sendMessage(Messages.message("messages.commands.repair.self.repaired"));
                    }

                }

            }
        }


        return true;
    }
}
