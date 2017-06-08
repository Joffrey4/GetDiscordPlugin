package io.github.joffrey4.getdiscord.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CommandDiscord implements CommandExecutor {

    private FileConfiguration config;

    public CommandDiscord(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            // Send the Discord link
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Discord.color") + "Discord: ") + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', config.getString("Discord.link")));

            // Send the comment line if it exists
            if (config.getString("Discord.comment") != null && (!Objects.equals(config.getString("Discord.comment"), ""))) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Discord.comment")));
            }
        }

        return true;
    }
}
