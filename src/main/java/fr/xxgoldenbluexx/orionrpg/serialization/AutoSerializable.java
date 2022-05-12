package fr.xxgoldenbluexx.orionrpg.serialization;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import fr.xxgoldenbluexx.orionrpg.annotation.SerializedField;

public abstract class AutoSerializable implements ConfigurationSerializable{
	
	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<>();
		Class<? extends AutoSerializable> clazz = this.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			try {
				if (field.getAnnotationsByType(SerializedField.class).length>0) {
					field.setAccessible(true);
					map.put(field.getName(), field.get(this));
				};
			}catch(Exception e) {
				
			}
		}
		return map;
	}
	
	public AutoSerializable(Map<String,Object> serialMap) {
		Class<? extends AutoSerializable> clazz = this.getClass();
		for (Entry<String, Object> savedValue : serialMap.entrySet()) {
			try {
				Field f = clazz.getDeclaredField(savedValue.getKey());
				if (f != null) {
					f.setAccessible(true);
					f.set(this, savedValue.getValue());
				}
			}catch(Exception e) {
				
			}
		}
	}

}
