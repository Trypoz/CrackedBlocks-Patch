package fr.tryphoz.CrackedBlocksPatch;

import fr.tryphoz.CrackedBlocksPatch.Commands.reloadCommand;
import fr.tryphoz.CrackedBlocksPatch.Listeners.explodeWater;
import org.bukkit.plugin.java.JavaPlugin;

public class CrackedBlocksPatch extends JavaPlugin {


    @Override
    public void onEnable() {

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new explodeWater(this), this);
        this.getCommand("cbp").setExecutor(new reloadCommand(this));

    }
}
