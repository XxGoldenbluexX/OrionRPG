package fr.xxgoldenbluexx.orionrpg.listener;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.xxgoldenbluexx.orionrpg.OrionRPG;
import fr.xxgoldenbluexx.orionrpg.data.IPlayerWrapperRepository;
import fr.xxgoldenbluexx.orionrpg.wrapper.PlayerWrapperBase;

public class ConnectionListener {

	public void OnPlayerJoin(PlayerJoinEvent evt) {
		OrionRPG.RunAsync(() -> {
			try {
				Player player = evt.getPlayer();
				final PlayerWrapperBase base = OrionRPG.injector.getInstance(IPlayerWrapperRepository.class).GetFromUUID(player.getUniqueId());
				OrionRPG.RunSync(() -> {
					OrionRPG.main.getPlayerMapRef().put(player, base);
				});
			}catch(Exception e) {
				OrionRPG.logger.log(Level.WARNING, e.getMessage(), e);
			}
		});
	}

	public void OnPLayerLeave(PlayerQuitEvent evt) {
		final PlayerWrapperBase wrapper = OrionRPG.main.getPlayerWrapper(evt.getPlayer());
		final UUID uuid = evt.getPlayer().getUniqueId();
		OrionRPG.main.getPlayerMapRef().remove(evt.getPlayer());
		OrionRPG.RunAsync(() -> {
			try {
				OrionRPG.injector.getInstance(IPlayerWrapperRepository.class).StoreToUUID(uuid, wrapper);
			} catch (IOException e) {
				OrionRPG.logger.log(Level.WARNING, e.getMessage(), e);
			}
		});
	}
}
