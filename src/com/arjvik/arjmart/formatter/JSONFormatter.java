package com.arjvik.arjmart.formatter;

import java.util.Map;

import com.google.gson.JsonObject;

public class JSONFormatter implements Formatter {

	public JSONFormatter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String format(Map<String, Object> map) {
		JsonObject json = new JsonObject();
		for (String key : map.keySet()) {
			Object value = map.get(key);
			if(value instanceof String){
				json.addProperty(key, (String) value);
			}else if(value instanceof Number){
				json.addProperty(key, (Number) value);
			}else if(value instanceof Boolean){
				json.addProperty(key, (Boolean) value);
			}else if(value instanceof Character){
				json.addProperty(key, (Character) value);
			}else{
				throw new IllegalArgumentException("Invalid type: "+value.getClass().getName());
			}
		}
		return json.toString();
	}
}