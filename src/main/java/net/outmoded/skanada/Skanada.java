package net.outmoded.skanada;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Skanada extends JavaPlugin {


    SkriptAddon addon;


    @Override
    public void onEnable() {
        // Plugin startup logic
        String version = Bukkit.getMinecraftVersion();

        if (version.equals("1.21.7") || version.equals("1.21.8")){
        }
        else {
            Skanada.getInstance().getLogger().warning("you are running a unsupported version: supported versions = 1.21.7/1.21.78");
        }


        // ###########################
        // Skript stuff

        if (Bukkit.getServer().getPluginManager().getPlugin("Skript") != null){
            addon = Skript.registerAddon(this);
            try {
                //This will register all our syntax for us. Explained below
                addon.loadClasses("net.outmoded.skanada", "syntax");
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogger().info("Loaded Successfully!"); // getLogger adds a message prefix
        }
        else {

            getLogger().warning("Skript Not Detected Shutting Down!");
            getServer().getPluginManager().disablePlugin(this); // disables plugin

        }

        // ###########################

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Skanada getInstance() {
        return getPlugin(Skanada.class);
    }
}
