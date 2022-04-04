package fr.tryphoz.CrackedBlocksPatch.Listeners;

import fr.tryphoz.CrackedBlocksPatch.CrackedBlocksPatch;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class explodeWater implements Listener {

    final private CrackedBlocksPatch main;

    public explodeWater(CrackedBlocksPatch monPlugin){
        this.main = monPlugin;
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e){

        if(main.getConfig().getBoolean("Options.water-protection")){

            if(e.getEntityType() == EntityType.PRIMED_TNT){

                Integer x = e.getEntity().getLocation().getBlockX();
                Integer y = e.getEntity().getLocation().getBlockY();
                Integer z = e.getEntity().getLocation().getBlockZ();

                if(e.getLocation().getWorld().getBlockAt(x, y, z).getType() == Material.WATER || e.getLocation().getWorld().getBlockAt(x, y, z).getType() == Material.STATIONARY_WATER) {

                    if(main.getConfig().getBoolean("Options.fake-explosion")){
                        e.getLocation().getWorld().createExplosion(e.getLocation(), 10);
                    }

                    e.setCancelled(true);

                }

            }

        }

    }

}
