package fr.xxgoldenbluexx.orionrpg.data.yaml;

import java.io.File;
import java.util.UUID;

import com.google.inject.Inject;

import fr.xxgoldenbluexx.orionrpg.OrionRPG;
import fr.xxgoldenbluexx.orionrpg.data.IPlayerWrapperRepository;
import fr.xxgoldenbluexx.orionrpg.wrapper.PlayerWrapperBase;

public class YamlPlayerWrapperRepository implements IPlayerWrapperRepository {

	private final File playerDataFolder;
	
	@Inject
	public YamlPlayerWrapperRepository(OrionRPG main) {
		playerDataFolder = new File(main.getDataFolder(),"playerData");
		try {
			playerDataFolder.mkdirs();
		}catch(Exception e) {
			main.getLogger().warning("Unable to create playerData folder.");
		}
	}
	
	@Override
	public PlayerWrapperBase GetFromUUID(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerWrapperBase StoreToUUID(UUID uuid, PlayerWrapperBase wrapper) {
		// TODO Auto-generated method stub
		return null;
	}

}
