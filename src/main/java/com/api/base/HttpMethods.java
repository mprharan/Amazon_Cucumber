package com.api.base;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HttpMethods {

	
	public static Response doPostCallWithBody(Map<String,String>header,String payloadrepo,String endpoint) {

		Response response = RestAssured.given().headers(header)
				.body(payloadrepo).when().post(endpoint).then().log()
				.all().extract().response();
		return response; 
	}
	
	public static Response deleteRepo(Map<String,String>header,String payloadrepo,String endpoint) {

		Response response = RestAssured.given().headers(header)
				.body(payloadrepo).when().delete(endpoint+"/hariharanmpr/IPT_REST").then().log()
				.all().extract().response();
		return response;
		
	}
}
