package com.bradleyjh.clearskies;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    boolean wClear = false;
  
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getLogger().info("[ClearSkies] ClearSkies enabled");
    }
  
    public void onDisable() {
        getServer().getLogger().info("[ClearSkies] ClearSkies disabled");
    }
  
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            event.setCancelled(true);
            event.getWorld().setThundering(false);
            event.getWorld().setStorm(false);
        }
    }
}