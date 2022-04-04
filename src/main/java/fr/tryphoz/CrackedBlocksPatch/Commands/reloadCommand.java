package fr.tryphoz.CrackedBlocksPatch.Commands;

import fr.tryphoz.CrackedBlocksPatch.CrackedBlocksPatch;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reloadCommand implements CommandExecutor {

    private CrackedBlocksPatch main;

    public reloadCommand(CrackedBlocksPatch monPlugin){
        this.main = monPlugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {


            Player player = (Player) sender;

            if(player.hasPermission("cbp.reload")){

                if (args.length <= 0 || !args[0].equalsIgnoreCase("reload")) {
                    player.sendMessage(main.getConfig().getString("Messages.invalid-usage").replace('&', '§'));
                }else{
                    main.reloadConfig();
                    player.sendMessage(main.getConfig().getString("Messages.reload-success").replace('&', '§'));
                }

            }else{
                player.sendMessage(main.getConfig().getString("Messages.no-perm").replace('&', '§'));
            }

        }else{
            main.reloadConfig();
            Bukkit.getServer().getConsoleSender().sendMessage(main.getConfig().getString("Messages.reload-success-console").replace('&', '§'));
        }

        return true;
    }


}
