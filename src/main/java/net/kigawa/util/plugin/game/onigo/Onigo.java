package net.kigawa.util.plugin.game.onigo;

import net.kigawa.util.all.Named;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public interface Onigo extends Named
{
  boolean changeOni(Player oni, Player runner);

  boolean contain(HumanEntity player);
}
