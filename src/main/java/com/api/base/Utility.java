package com.api.base;

import io.restassured.response.Response;

public class Utility {
	
	public static String readJsonPath(Response response,String jsonPath) {

		return response.then().extract().jsonPath().getString(jsonPath);
		
	}

}
