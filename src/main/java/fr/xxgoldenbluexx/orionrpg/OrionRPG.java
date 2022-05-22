package fr.xxgoldenbluexx.orionrpg;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.xxgoldenbluexx.orionrpg.listener.OrionListener;
import fr.xxgoldenbluexx.orionrpg.wrapper.PlayerWrapperBase;

public class OrionRPG extends JavaPlugin {
	
	public static OrionRPG main;
	
	public static OrionListener listener;
	
	private Map<Player,PlayerWrapperBase> playerMap = new HashMap<>();
	
	@Override
	public void onEnable() {
		super.onEnable();
		main = this;
		listener = new OrionListener();
		Bukkit.getPluginManager().registerEvents(listener, main);
	}
	
	public PlayerWrapperBase getPlayerWrapper(Player player) {
		return playerMap.get(player);
	}
	
}
