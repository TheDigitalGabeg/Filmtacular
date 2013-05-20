package org.gabeg.bukkit.filmtacular;

import org.bukkit.GameMode;
import org.bukkit.entity.Boat;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class VehicleEventListener implements Listener {
	   
	@EventHandler
	public void onVehicleExitEvent(VehicleExitEvent event) {
		
		// block adventure mode players from leaving moving minecarts
		if (Filmtacular.MinecartSeatbelts
		 && Minecart.class.isInstance(event.getVehicle())
		 && HumanEntity.class.isInstance(event.getVehicle().getPassenger())) {
			
			if (((HumanEntity)event.getVehicle().getPassenger()).getGameMode() == GameMode.ADVENTURE
			 && ((Minecart)event.getVehicle()).getVelocity().length() > Filmtacular.MinecartSeatbeltTolerance) {
			 	event.setCancelled(true);
				if (Filmtacular.DebugMode)
	    			Filmtacular.Log("Filmtacular: prevented player " + ((Player)event.getVehicle().getPassenger()).getDisplayName() + " from leaving a moving minecart.");
		 	}
		}
	}
	   
	 @EventHandler
	 public void onVehicleDamageEvent(VehicleDamageEvent event) {
	 	
	 	// block boat damage from adventure mode players or environmental effects
	 	if (Filmtacular.SturdyBoats
	 	 && Boat.class.isInstance(event.getVehicle())
	    	 && ( !HumanEntity.class.isInstance(event.getAttacker()) ||
	    		  (HumanEntity.class.isInstance(event.getAttacker()) && ((HumanEntity)event.getAttacker()).getGameMode() == GameMode.ADVENTURE)))
	 	{
	 		event.setCancelled(true);
			if (Filmtacular.DebugMode)
    			Filmtacular.Log("Filmtacular: prevented damage to a boat.");
	 	}
	 	
	 	// block minecart damage from adventure mode players
	 	if (Filmtacular.SturdyMinecarts
		 && Minecart.class.isInstance(event.getVehicle())
	 	 && HumanEntity.class.isInstance(event.getAttacker())
		 && ((HumanEntity)event.getAttacker()).getGameMode() == GameMode.ADVENTURE)
	 	{
	 		event.setCancelled(true);
			if (Filmtacular.DebugMode)
    			Filmtacular.Log("Filmtacular: prevented damage to a minecart.");
	 	}
	 }
 
	@EventHandler
	public void onVehicleDestroyEvent(VehicleDestroyEvent event) {
		
		// block boat destruction from adventure mode players and environmental effect (fuck you, lillypads)
		if (Filmtacular.SturdyBoats
		 && Boat.class.isInstance(event.getVehicle())
		 && ( !HumanEntity.class.isInstance(event.getAttacker()) ||
			  (HumanEntity.class.isInstance(event.getAttacker()) && ((HumanEntity)event.getAttacker()).getGameMode() == GameMode.ADVENTURE)))
		{
			event.setCancelled(true);
			if (Filmtacular.DebugMode)
    			Filmtacular.Log("Filmtacular: prevented destruction of a boat.");
		}
	
		// block minecart destruction from adventure mode players
		if (Filmtacular.SturdyMinecarts
		 && Minecart.class.isInstance(event.getVehicle())
		 && HumanEntity.class.isInstance(event.getAttacker())
		 && ((HumanEntity)event.getAttacker()).getGameMode() == GameMode.ADVENTURE)
		{
			event.setCancelled(true);
			if (Filmtacular.DebugMode)
    			Filmtacular.Log("Filmtacular: prevented destruction of a minecart.");
		}
	}
}
