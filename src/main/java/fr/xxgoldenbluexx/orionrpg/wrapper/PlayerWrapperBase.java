package fr.xxgoldenbluexx.orionrpg.wrapper;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import com.google.inject.Inject;

import fr.xxgoldenbluexx.orionrpg.annotation.SerializedField;
import fr.xxgoldenbluexx.orionrpg.serialization.AutoSerializable;
import fr.xxgoldenbluexx.orionrpg.type.PlayerType;

public class PlayerWrapperBase extends AutoSerializable{

	private Player player;
	
	@SerializedField
	private PlayerType playerType;
	
	public Player player() {
		return player;
	}
	
	@Inject
	public PlayerWrapperBase() {
		super(new HashMap<>());
	}
	
	public PlayerWrapperBase(Map<String,Object> serialMap) {
		super(serialMap);
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public PlayerType getPlayerType() {
		return playerType;
	}
	
	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}
	
}
