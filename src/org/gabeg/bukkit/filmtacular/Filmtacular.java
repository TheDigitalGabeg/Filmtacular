package org.gabeg.bukkit.filmtacular;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Filmtacular extends JavaPlugin {
    
    static boolean DebugMode;
    static boolean SturdyBoats;
    static boolean SturdyMinecarts;
    static boolean MinecartSeatbelts;
    static double MinecartSeatbeltTolerance;
    
    static final Logger logger = Logger.getGlobal();
    
    FilmtacularCommandExecutor cmdExec;

    @Override
    public void onEnable(){
        // TODO Insert logic to be performed when the plugin is enabled
    	DebugMode = false;
    	SturdyBoats = true;
    	SturdyMinecarts = true;
    	MinecartSeatbelts = true;
    	MinecartSeatbeltTolerance = 0.1;
    	
    	cmdExec = new FilmtacularCommandExecutor();
    	getCommand("ft").setExecutor(cmdExec);
    	
    	getServer().getPluginManager().registerEvents(new VehicleEventListener(), this);
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    
    public static void Log(String text) {
    	logger.info(text);
    	Bukkit.broadcast(text, "");
    }
    
}
