package net.kigawa.util.plugin.all.command;

import net.kigawa.util.plugin.all.KigawaPlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public abstract class FirstCommand extends SubCommand implements CommandExecutor, TabCompleter {
    KigawaPlugin plugin;
    List<SubCommand> subCommands = new ArrayList<>();

    public FirstCommand(KigawaPlugin plugin) {
        super(plugin);
        this.plugin = plugin;

        plugin.getCommand(getCommandStr()).setExecutor(this);
        plugin.getCommand(getCommandStr()).setTabCompleter(this);
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        return tabComplete(commandSender, command, s, strings);
    }

    public void addSubcommands(SubCommand subCommand) {
        subCommands.add(subCommand);
        addTabLists(subCommand);
    }

    @Override
    public boolean onCommand(
            CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        plugin.logger(getCommandStr() + " onAlways");
        if (!onAlways(commandSender, command, s, strings)) {
            return false;
        }
        if (strings.length > 0) {

            plugin.logger(getCommandStr() + " onIsContain");

            if (subCommands != null) {
                if (subCommands.contains(new EqualsCommand(strings[0]))) {
                    plugin.logger(getCommandStr() + " onGetSubCommand");
                    SubCommand subCommand = subCommands.get(subCommands.indexOf(new EqualsCommand(strings[0])));
                    return subCommand.onCommand(commandSender, command, s, strings);
                }
            }
        }
        plugin.logger(getCommandStr() + " onNotFound");
        return onNotFound(commandSender, command, s, strings);
    }


    @Override
    public int getWordNumber() {
        return 0;
    }


    public abstract boolean onAlways(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings);

    public abstract boolean onNotFound(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings);
}
