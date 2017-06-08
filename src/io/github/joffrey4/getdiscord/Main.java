package io.github.joffrey4.getdiscord;

import io.github.joffrey4.getdiscord.command.CommandDiscord;
import io.github.joffrey4.getdiscord.command.CommandSetDiscord;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private FileConfiguration config = getConfig();

    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
        saveDefaultConfig();

        this.getCommand("discord").setExecutor(new CommandDiscord(config));
        this.getCommand("setdiscord").setExecutor(new CommandSetDiscord(this));
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }

}
