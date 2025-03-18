package io.github.dotheflopboy.basic;

import io.github.dotheflopboy.basic.commands.*;
import io.github.dotheflopboy.basic.listeners.*;
import io.github.dotheflopboy.basic.tabcompleters.BasicTabComplete;
import io.github.dotheflopboy.basic.tabcompleters.GamemodeTabComplete;
import io.github.dotheflopboy.basic.tabcompleters.RepairTabComplete;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

        saveDefaultConfig();



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
        Objects.requireNonNull(this.getCommand("spawn")).setExecutor(new SpawnCommand());
        Objects.requireNonNull(this.getCommand("suicide")).setExecutor(new SuicideCommand());
        Objects.requireNonNull(this.getCommand("itemframe")).setExecutor(new ItemframeCommand());
        Bukkit.getPluginManager().registerEvents(new ChatListeners(),this);
        Bukkit.getPluginManager().registerEvents(new GodListeners(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListeners(),this);
        Bukkit.getPluginManager().registerEvents(new QuitListeners(),this);


    }
    

    @Override
    public void onDisable() {

    }


}
