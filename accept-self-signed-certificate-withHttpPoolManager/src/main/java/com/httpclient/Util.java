package com.httpclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.httpclient.beans.Body;

public class Util {

	
	public static String bodyToJsonStr(Body body) throws JsonProcessingException {
		String jsonString = null;

		ObjectMapper objectMapper = new ObjectMapper();
		jsonString = objectMapper.writeValueAsString(body);

		return jsonString;
	}
}
