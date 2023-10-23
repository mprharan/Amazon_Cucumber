package com.test.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicReqres {
	@Test
	private void getUseretails() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().header("Content-Type","application/json").when().get("/api/users/2").then().log().all().extract().response();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Constants.HTTPS_STATUSCOE_OK);
		String responseText = response.asPrettyString();
		System.out.println(responseText);
	}
	
	@Test
	private void postCreateUser() {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().post("/api/users").then().log().all().extract().response();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Constants.HTTPS_STATUS_CREATED);
		String responseText = response.asPrettyString();
		System.out.println(responseText);
	}

}
