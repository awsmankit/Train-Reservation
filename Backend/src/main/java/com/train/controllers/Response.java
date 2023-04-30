package com.train.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
	
	// Method for successful response with data
	public static ResponseEntity<?> success(Object data) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", "success");
		if(data != null)
			map.put("data", data);
		// Return HTTP status code 200 (OK) with response body containing status and data
		return ResponseEntity.ok(map);
	}
	
	// Method for error response with error message
	public static ResponseEntity<?> error(Object err) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", "error");
		if(err != null)
			map.put("error", err);
		// Return HTTP status code 200 (OK) with response body containing status and error message
		return ResponseEntity.ok(map);
	}
	
	// Method for returning a response with a specified HTTP status code
	public static ResponseEntity<?> status(HttpStatus status) {
		// Build response entity with specified HTTP status code
		return ResponseEntity.status(status).build();
	}
}
