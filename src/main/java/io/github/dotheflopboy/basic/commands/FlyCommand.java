package io.github.dotheflopboy.basic.commands;



import io.github.dotheflopboy.basic.Basic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class FlyCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if(sender instanceof Player p){

            if(cmd.getName().equalsIgnoreCase("fly")){
                if(args.length == 0){

                    if(!p.hasPermission("basic.command.fly")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    if(!p.getAllowFlight()){
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage("[Basic] Du hast dein Flugmodus auf aktiviert gesetzt.");
                    }else {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage("[Basic] Du hast dein Flugmodus auf deaktiviert gesetzt.");
                    }



                } else if(args.length == 1){
                    Player target = p.getServer().getPlayer(args[0]);

                    if(!p.hasPermission("basic.command.fly.others")){
                        p.sendMessage(Basic.getPlugin().getConfig().getString("messages.info.noPermission"));
                        return true;
                    }

                    if (target == null) {
                        p.sendMessage("[Basic] der Spieler " + args[0] + " ist nicht online.");
                        return true;
                    }

                    if(!target.getAllowFlight()){
                        target.setAllowFlight(true);
                        target.setFlying(true);
                        p.sendMessage("[Basic] Du hast " + target.getName() + "s Flugmodus auf aktiviert gesetzt.");
                    } else {
                        target.setAllowFlight(false);
                        target.setFlying(false);
                        p.sendMessage("[Basic] Du hast " + target.getName() + "s Flugmodus auf deaktiviert gesetzt.");
                    }

                }

            }

        } else {
            sender.sendMessage("[Basic] Dieser Befehl geht nur im Spiel!");
        }
        return true;
    }
}
