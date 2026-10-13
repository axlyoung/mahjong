package com.attic.bj.common.util;

import java.io.IOException;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

public class JsonUtil {
	// Jackson 2 defaults keep the JSON format compatible with data already stored and sent to clients
	private static ObjectMapper objectMapper = JsonMapper
			.builderWithJackson2Defaults().build();

	public static Object decode(String json, Class clazz) throws IOException {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (JacksonException e) {
			throw new IOException(e);
		}
	}

	public static String encode(Object o) throws IOException {
		try {
			return objectMapper.writeValueAsString(o);
		} catch (JacksonException e) {
			throw new IOException(e);
		}
	}
}
