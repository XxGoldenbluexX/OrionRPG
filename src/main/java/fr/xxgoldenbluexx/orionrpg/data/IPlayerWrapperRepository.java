package fr.xxgoldenbluexx.orionrpg.data;

import java.util.UUID;

import fr.xxgoldenbluexx.orionrpg.wrapper.PlayerWrapperBase;

public interface IPlayerWrapperRepository {

	
	public PlayerWrapperBase GetFromUUID(UUID uuid);
	
	public PlayerWrapperBase StoreToUUID(UUID uuid, PlayerWrapperBase wrapper);
	
}
