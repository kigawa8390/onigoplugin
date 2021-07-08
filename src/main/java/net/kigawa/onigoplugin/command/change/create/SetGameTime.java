package net.kigawa.onigoplugin.command.change.create;

import net.kigawa.onigoplugin.OnigoPlugin;
import net.kigawa.util.plugin.all.command.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class SetGameTime extends SubCommand {
    OnigoPlugin plugin;

    public SetGameTime(OnigoPlugin onigoPlugin) {
        super(onigoPlugin);
        plugin = onigoPlugin;
    }

    @Override
    public String getCommandStr() {
        return "setgametime";
    }



    @Override
    public boolean onAlways(CommandSender commandSender, Command command, String s, String[] strings) {
        return true;
    }

    @Override
    public boolean onNotFound(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 3) {
            plugin.getChangeGame().setGameTime(strings[1], commandSender, Integer.valueOf(strings[2]));
            commandSender.sendMessage("set game time");
        } else {
            commandSender.sendMessage("/onigocreate setgametime <game name> <count(minute)>");
        }
        return true;
    }

    @Override
    public int getWordNumber() {
        return 0;
    }


}
