package fr.xxgoldenbluexx.orionrpg.data;

import java.io.IOException;
import java.util.UUID;

import fr.xxgoldenbluexx.orionrpg.wrapper.PlayerWrapperBase;

public interface IPlayerWrapperRepository {

	
	public PlayerWrapperBase GetFromUUID(UUID uuid) throws IOException;
	
	public void StoreToUUID(UUID uuid, PlayerWrapperBase wrapper) throws IOException;
	
}
