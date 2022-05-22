package fr.xxgoldenbluexx.orionrpg.data.yaml;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

import com.google.inject.Inject;

import fr.xxgoldenbluexx.orionrpg.OrionRPG;
import fr.xxgoldenbluexx.orionrpg.data.IPlayerWrapperRepository;
import fr.xxgoldenbluexx.orionrpg.wrapper.PlayerWrapperBase;

public class YamlPlayerWrapperRepository implements IPlayerWrapperRepository {

	public static final String WRAPPER_PATH = "wrapper";
	
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
		File file = new File(playerDataFolder,uuid.toString()+".yml");
		YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
		return (PlayerWrapperBase) conf.get(WRAPPER_PATH);
	}

	@Override
	public void StoreToUUID(UUID uuid, PlayerWrapperBase wrapper) throws IOException {
		File file = new File(playerDataFolder,uuid.toString()+".yml");
		file.createNewFile(); //DO nothing if file already created.
		YamlConfiguration conf = new YamlConfiguration();
		conf.set(WRAPPER_PATH, wrapper);
		conf.save(file);
	}

}
