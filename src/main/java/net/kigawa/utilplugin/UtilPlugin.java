package net.kigawa.utilplugin;

import net.kigawa.util.plugin.plugin.KigawaPlugin;
import net.kigawa.utilplugin.sql.Connect;
import org.bukkit.configuration.file.FileConfiguration;

public final class UtilPlugin extends KigawaPlugin {
    UtilConfig config;

    @Override
    public void onStart() {
        config=new UtilConfig(this);
    }

    @Override
    public void addConfigDefault(FileConfiguration config) {

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public Connect getConnect(){
        return new Connect(config,this);
    }
}
