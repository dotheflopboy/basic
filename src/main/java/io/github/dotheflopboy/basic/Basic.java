package io.github.dotheflopboy.basic;

import io.github.dotheflopboy.basic.commands.*;
import io.github.dotheflopboy.basic.listeners.*;
import io.github.dotheflopboy.basic.tabcompleters.BasicTabComplete;
import io.github.dotheflopboy.basic.tabcompleters.GamemodeTabComplete;
import io.github.dotheflopboy.basic.tabcompleters.RepairTabComplete;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;



public final class Basic extends JavaPlugin {

    private static Basic plugin;

    public Basic(){
        plugin = this;
    }

    public static Basic getPlugin(){
        return plugin;
    }

    FileConfiguration config = getConfig();


    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        config.addDefault("messages.info.noPermission", "&8[&6Basic&8] &cDu hast keine Rechte dafür!");
        config.addDefault("messages.info.noConsoleCommand", "&8[&6Basic&8] &cDieser Befehl geht nur im Spiel!");
        config.addDefault("messages.commands.basic.configReload", "&8[&6Basic&8] &aDie Plugin Config wurde erneut geladen.");
        config.addDefault("messages.commands.gamemode.usage", "&8[&6Basic&8] &aVerwende /gamemode [survival/creative/adventure/spectator].");
        config.addDefault("messages.commands.gamemode.survival.self", "&8[&6Basic&8] &aDein Gamemode wurde auf Survival gesetzt.");
        config.addDefault("messages.commands.gamemode.creative.self", "&8[&6Basic&8] &aDein Gamemode wurde auf Creative gesetzt.");
        config.addDefault("messages.commands.gamemode.adventure.self", "&8[&6Basic&8] &aDein Gamemode wurde auf Adventure gesetzt.");
        config.addDefault("messages.commands.gamemode.spectator.self", "&8[&6Basic&8] &aDein Gamemode wurde auf Spectator gesetzt.");
        config.addDefault("messages.commands.gamemode.noGamemode", "&8[&6Basic&8] &cKein Gamemode ausgewählt.");
        config.addDefault("messages.commands.gamemode.noTarget", "&8[&6Basic&8] &cDer Spieler ist nicht online.");
        config.addDefault("messages.commands.gamemode.survival.other", "&8[&6Basic&8] &aDu hast den Gamemode des Spielers auf Survival gesetzt.");
        config.addDefault("messages.commands.gamemode.creative.other", "&8[&6Basic&8] &aDu hast den Gamemode des Spielers auf Creative gesetzt.");
        config.addDefault("messages.commands.gamemode.adventure.other", "&8[&6Basic&8] &aDu hast den Gamemode des Spielers auf Adventure gesetzt.");
        config.addDefault("messages.commands.gamemode.spectator.other", "&8[&6Basic&8] &aDu hast den Gamemode des Spielers auf Spectator gesetzt.");
        config.addDefault("messages.commands.clearinventory.noTarget", "&8[&6Basic&8] &cDer Spieler ist nicht online.");
        config.addDefault("messages.commands.clearinventory.self", "&8[&6Basic&8] &aDein Inventar wurde geleert.");
        config.addDefault("messages.commands.clearinventory.other", "&8[&6Basic&8] &aDu hast das Inventar des Spielers geleert.");
        config.addDefault("messages.commands.feed.noTarget", "&8[&6Basic&8] &cDer Spieler ist nicht online.");
        config.addDefault("messages.commands.feed.self", "&8[&6Basic&8] &aDu wurdest gesättigt.");
        config.addDefault("messages.commands.feed.other", "&8[&6Basic&8] &aDu hast den Spieler gesättigt.");
        config.addDefault("messages.commands.fly.noTarget", "&8[&6Basic&8] &cDer Spieler ist nicht online.");
        config.addDefault("messages.commands.fly.self.on", "&8[&6Basic&8] &aDein Flugmodus wurde auf aktiviert gesetzt.");
        config.addDefault("messages.commands.fly.self.off", "&8[&6Basic&8] &aDein Flugmodus wurde auf deaktiviert gesetzt.");
        config.addDefault("messages.commands.fly.other.on", "&8[&6Basic&8] &aDu hast den Flugmodus des Spielers auf aktiviert gesetzt.");
        config.addDefault("messages.commands.fly.other.off", "&8[&6Basic&8] &aDu hast den Flugmodus des Spielers auf deaktiviert gesetzt.");
        config.addDefault("messages.commands.god.noTarget", "&8[&6Basic&8] &cDer Spieler ist nicht online.");
        config.addDefault("messages.commands.god.self.on", "&8[&6Basic&8] &aDu bist nun im Gottmodus!");
        config.addDefault("messages.commands.god.self.off", "&8[&6Basic&8] &aDu bist nun nicht mehr im Gottmodus!");
        config.addDefault("messages.commands.heal.noTarget", "&8[&6Basic&8] &cDer Spieler ist nicht online.");
        config.addDefault("messages.commands.heal.self", "&8[&6Basic&8] &aDu wurdest geheilt.");
        config.addDefault("messages.commands.heal.other", "&8[&6Basic&8] &aDu hast den Spieler geheilt.");
        config.addDefault("messages.commands.repair.noTarget", "&8[&6Basic&8] &cDer Spieler ist nicht online.");
        config.addDefault("messages.commands.repair.self.noItem", "&8[&6Basic&8] &aDu hast kein Item in deiner Hand.");
        config.addDefault("messages.commands.repair.self.repaired", "&8[&6Basic&8] &aDas Item in deiner Hand wurde repariert.");
        config.addDefault("messages.commands.repair.self.repairedAll", "&8[&6Basic&8] &aAlle Items in deinem Inventar wurden repariert.");
        config.addDefault("messages.playerJoin", "&8[&a+&8]&r %player%");
        config.addDefault("messages.playerQuit", "&8[&c-&8]&r %player%");
        config.addDefault("messages.commands.workbench.noTarget", "&8[&6Basic&8] &cDer Spieler ist nicht online.");
        config.addDefault("messages.commands.workbench.other", "&8[&6Basic&8] &aDu hast dem Spieler eine Werkbank geöffnet.");
        config.addDefault("messages.commands.workbench.self", "&8[&6Basic&8] &aDir wurde eine Werkbank geöffnet.");
        config.options().copyDefaults(true);
        saveConfig();




        Objects.requireNonNull(this.getCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(this.getCommand("god")).setExecutor(new GodCommand());
        Objects.requireNonNull(this.getCommand("feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(this.getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(this.getCommand("clearinventory")).setExecutor(new ClearinventoryCommand());
        Objects.requireNonNull(this.getCommand("colors")).setExecutor(new ColorCommand());
        Objects.requireNonNull(this.getCommand("gamemode")).setExecutor(new GamemodeCommand());
        Objects.requireNonNull(this.getCommand("gamemode")).setTabCompleter(new GamemodeTabComplete());
        Objects.requireNonNull(this.getCommand("basic")).setExecutor(new BasicCommand());
        Objects.requireNonNull(this.getCommand("basic")).setTabCompleter(new BasicTabComplete());
        Objects.requireNonNull(this.getCommand("repair")).setExecutor(new RepairCommand());
        Objects.requireNonNull(this.getCommand("repair")).setTabCompleter(new RepairTabComplete());
        Objects.requireNonNull(this.getCommand("workbench")).setExecutor(new WorkbenchCommand());
        Bukkit.getPluginManager().registerEvents(new ChatListeners(),this);
        Bukkit.getPluginManager().registerEvents(new GodListeners(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListeners(),this);
        Bukkit.getPluginManager().registerEvents(new QuitListeners(),this);


    }
    

    @Override
    public void onDisable() {

    }


}
