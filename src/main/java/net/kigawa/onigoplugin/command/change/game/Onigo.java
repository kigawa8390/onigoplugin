package net.kigawa.onigoplugin.command.change.game;

import net.kigawa.onigoplugin.OnigoPlugin;
import net.kigawa.util.plugin.all.command.FirstCommand;
import net.kigawa.util.plugin.game.onigo.command.game.End;
import net.kigawa.util.plugin.game.onigo.command.game.List;
import net.kigawa.util.plugin.game.onigo.command.game.Start;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Onigo extends FirstCommand {
    OnigoPlugin plugin;

    public Onigo(OnigoPlugin plugin) {
        super(plugin);
        this.plugin = plugin;
        addSubcommands(new Start(plugin));
        addSubcommands(new End(plugin));
        addSubcommands(new List(plugin));
    }


    @Override
    public boolean onAlways(CommandSender commandSender, Command command, String s, String[] strings) {
        return true;
    }

    @Override
    public boolean onNotFound(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }


    @Override
    public String getCommandStr() {
        return "onigo";
    }

    @Override
    public int getWordNumber() {
        return 0;
    }


}
