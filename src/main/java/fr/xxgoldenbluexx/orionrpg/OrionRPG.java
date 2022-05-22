package fr.xxgoldenbluexx.orionrpg;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.inject.Guice;
import com.google.inject.Injector;

import fr.xxgoldenbluexx.orionrpg.ioc.OrionRPGiocModule;
import fr.xxgoldenbluexx.orionrpg.listener.OrionListener;
import fr.xxgoldenbluexx.orionrpg.wrapper.PlayerWrapperBase;

public class OrionRPG extends JavaPlugin {
	
	public static OrionRPG main;
	
	public static Injector injector;
	
	public static OrionListener listener;
	
	private Map<Player,PlayerWrapperBase> playerMap = new HashMap<>();
	
	@Override
	public void onEnable() {
		super.onEnable();
		main = this;
		injector = Guice.createInjector(new OrionRPGiocModule());
		listener = new OrionListener();
		Bukkit.getPluginManager().registerEvents(listener, main);
	}
	
	public PlayerWrapperBase getPlayerWrapper(Player player) {
		return playerMap.get(player);
	}
	
	public Map<Player,PlayerWrapperBase> getPlayerMapRef(){
		return playerMap;
	}
	
	public static void RunAsync(Runnable runnable) {
		Bukkit.getScheduler().runTaskAsynchronously(main, runnable);
	}
	
	public static void RunSync(Runnable runnable) {
		Bukkit.getScheduler().runTask(main, runnable);
	}
	
}
