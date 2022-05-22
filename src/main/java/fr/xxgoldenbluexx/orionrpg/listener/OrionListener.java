package fr.xxgoldenbluexx.orionrpg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class OrionListener implements Listener{

	private ConnectionListener connectionListener = new ConnectionListener();
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent evt) {
		connectionListener.OnPlayerJoin(evt);
	}
	
	@EventHandler
	public void OnPlayerLeave(PlayerQuitEvent evt) {
		connectionListener.OnPLayerLeave(evt);
	}
	
}
