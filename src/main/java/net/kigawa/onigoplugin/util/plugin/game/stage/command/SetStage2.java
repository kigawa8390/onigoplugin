package net.kigawa.onigoplugin.util.plugin.game.stage.command;

import net.kigawa.onigoplugin.OnigoPlugin;
import net.kigawa.onigoplugin.util.plugin.all.command.SubCommand;
import net.kigawa.onigoplugin.util.plugin.game.stage.StageManager;
import org.bukkit.World;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetStage2 extends SubCommand
{
  OnigoPlugin plugin;
  private StageManager stageManager;

  public SetStage2(OnigoPlugin OnigoPlugin, StageManager stageManager) {
    super(OnigoPlugin);
    plugin = OnigoPlugin;
    this.stageManager = stageManager;
  }

  @Override
  public String getName() {
    return "setstage2";
  }


  @Override
  public boolean onAlways(CommandSender commandSender, Command command, String s, String[] strings) {
    return true;
  }

  @Override
  public boolean onNotFound(CommandSender commandSender, Command command, String s, String[] strings) {
    if (strings.length == 5) {
      if (commandSender instanceof Player | commandSender instanceof BlockCommandSender) {
        World world;
        if (commandSender instanceof Player) {
          world = ((Player) commandSender).getWorld();
        } else {
          world = ((BlockCommandSender) commandSender).getBlock().getWorld();
        }
        stageManager.setStage2(strings[1], world.getName(),
            Integer.valueOf(strings[2]), Integer.valueOf(strings[3]), Integer.valueOf(strings[4]), commandSender);
        commandSender.sendMessage("set start point of stage");
      }

    } else {
      commandSender.sendMessage("/stage setstage2 <stage name> <x> <y> <z>");
    }
    return true;
  }

  @Override
  public int getWordNumber() {
    return 0;
  }
}
