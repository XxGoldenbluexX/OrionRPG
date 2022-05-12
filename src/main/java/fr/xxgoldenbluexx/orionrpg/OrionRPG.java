package fr.xxgoldenbluexx.orionrpg;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.xxgoldenbluexx.orionrpg.listener.OrionListener;
import fr.xxgoldenbluexx.orionrpg.wrapper.PlayerWrapper;

public class OrionRPG extends JavaPlugin {
	
	public static OrionRPG main;
	
	public static OrionListener listener;
	
	private Map<Player,PlayerWrapper> playerMap = new HashMap<>();
	
	@Override
	public void onEnable() {
		super.onEnable();
		main = this;
		listener = new OrionListener();
		Bukkit.getPluginManager().registerEvents(listener, main);
	}
	
}
