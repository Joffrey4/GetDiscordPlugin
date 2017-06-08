package io.github.joffrey4.getdiscord.command;

import io.github.joffrey4.getdiscord.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetDiscord implements CommandExecutor {

    private Main plugin;

    public CommandSetDiscord(Main instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length >= 1) {

                // Link command
                if (strings[0].equalsIgnoreCase("link")) {
                    if (strings.length == 2) {
                        plugin.getConfig().set("Discord.link", strings[1]);
                        plugin.saveConfig();
                        player.sendMessage(ChatColor.DARK_AQUA + "[GetDiscord] " + ChatColor.RESET + "You've properly set '" + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Discord.link")) + ChatColor.RESET + "' as link !");

                    } else {
                        player.sendMessage(ChatColor.RED + "You must enter a valid link.");
                    }

                // Comment command
                } else if (strings[0].equalsIgnoreCase("comment")) {
                    if (strings.length == 1) {
                        plugin.getConfig().set("Discord.comment", "");
                        plugin.saveConfig();
                        player.sendMessage(ChatColor.DARK_AQUA + "[GetDiscord] " + ChatColor.RESET + "Comment for /discord was been removed");

                    } else {
                        StringBuilder builder = new StringBuilder();

                        for (int i = 1; i < strings.length; i++) {
                            builder.append(strings[i]).append(" ");
                        }

                        String comment = builder.toString();
                        plugin.getConfig().set("Discord.comment", comment);
                        plugin.saveConfig();
                        player.sendMessage(ChatColor.DARK_AQUA + "[GetDiscord] " + ChatColor.RESET + "Comment for /discord was been set to '" + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Discord.comment")) + ChatColor.RESET + "'");
                    }

                // Color command
                } else if (strings[0].equalsIgnoreCase("color")) {
                    if (strings.length == 2) {
                        if (strings[1].length() == 2 && strings[1].contains("&")) {
                            plugin.getConfig().set("Discord.color", strings[1]);
                            plugin.saveConfig();
                            player.sendMessage(ChatColor.DARK_AQUA + "[GetDiscord] " + ChatColor.RESET + "Color for /discord was been set to " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Discord.color")) + "this amazing one " + ChatColor.RESET + "!");

                        } else {
                            player.sendMessage(ChatColor.RED + "You must enter a valid color code, like '&1'");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "You must enter a valid color code.");
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "You must enter a valid argument, like 'link' or 'comment'");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You must enter at least one argument, like 'link' or 'comment'");
            }
            return true;
        }
        return false;
    }
}
