package org.gabeg.bukkit.filmtacular;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FilmtacularCommandExecutor implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(cmd.getName().equalsIgnoreCase("ft")){
    		
    		if (args.length < 1 || args[0] == "help") {
    			Filmtacular.Log("Filmtacular command list:");
    			Filmtacular.Log("status : shows all Filmtacular settings.");
    			Filmtacular.Log("toggleSturdyBoats : toggles sturdy boats on or off.");
    			Filmtacular.Log("toggleSturdyMinecarts : toggles sturdy minecarts on or off.");
    			Filmtacular.Log("toggleMinecartSeatbelts : toggles minecart seatbelts on or off.");
    			Filmtacular.Log("toggleDebugMode : toggles verbose logging for Filmtacular events.");
    		}
    		
    		else if (args[0].equalsIgnoreCase("toggleDebugMode")) {
    			Filmtacular.DebugMode = !Filmtacular.DebugMode;
    			Filmtacular.Log("Filmtacular: debug mode is now " + (Filmtacular.DebugMode ? "enabled" : "disabled") + ".");
    		}
    		
    		else if (args[0].equalsIgnoreCase("toggleSturdyBoats")) {
    			Filmtacular.SturdyBoats = !Filmtacular.SturdyBoats;
    			Filmtacular.Log("Filmtacular: sturdy boats are now " + (Filmtacular.SturdyBoats ? "enabled" : "disabled") + ".");
    		}
    		
    		else if (args[0].equalsIgnoreCase("toggleSturdyMinecarts")) {
    			Filmtacular.SturdyMinecarts = !Filmtacular.SturdyMinecarts;
    			Filmtacular.Log("Filmtacular: sturdy minecarts are now " + (Filmtacular.SturdyMinecarts ? "enabled" : "disabled") + ".");
    		}

    		else if (args[0].equalsIgnoreCase("toggleMinecartSeatbelts")) {
    			Filmtacular.MinecartSeatbelts = !Filmtacular.MinecartSeatbelts;
    			Filmtacular.Log("Filmtacular: minecart seatbelts are now " + (Filmtacular.MinecartSeatbelts ? "enabled" : "disabled") + ".");
    		}

    		else if (args[0].equalsIgnoreCase("status")) {
    			Filmtacular.Log("Filmtacular status report:");
    			Filmtacular.Log("Sturdy boats : " + (Filmtacular.SturdyBoats ? "enabled" : "disabled"));
    			Filmtacular.Log("Sturdy minecarts : " + (Filmtacular.SturdyMinecarts ? "enabled" : "disabled"));
    			Filmtacular.Log("Minecart seatbelts : " + (Filmtacular.MinecartSeatbelts ? "enabled" : "disabled"));
    		}
    		
    		return true;
    	} //If this has happened the function will return true. 
            // If this hasn't happened the a value of false will be returned.
    	return false; 
    }
    
}
