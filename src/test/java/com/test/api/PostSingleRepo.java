package com.test.api;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.api.base.Constants;
import com.api.base.JSONPath;
import com.api.base.Utility;
import com.api.clients.SingleRepoClient;
import com.api.payload.SingleRepoPayload;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostSingleRepo {

//	private Map<String, String> givenHeaders() {

//	Map<String, String> header = new HashMap<>();
//		header.put("Accept", "application/vnd.github+json");
//		header.put("Authorization", "Bearer " + "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");
//		return header;

//	}
	SingleRepoClient singleRepo=new SingleRepoClient();

	@Test
	private void createSingleRepo() {
//		RestAssured.baseURI = "https://api.github.com";

//		Response response = RestAssured.given().headers(givenHeaders())
//				.body(SingleRepoPayload.createSingleRepo("RestAssuredProject")).when().post("/user/repos").then().log()
//				.all().extract().response();
		Response response = singleRepo.createSingleRepoWithValidAuth();
		
		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, Constants.HTTPS_STATUS_CREATED, "This Repository Is Already Exists");
		
		String value = Utility.readJsonPath(response, JSONPath.JSON_PATH_REPONAME);
		Assert.assertEquals(value, "IPT_REST");
		System.out.println("The Response :" + response.asPrettyString());
	}
	
	

	// negative
	@Test
	@Ignore
	private void notFoundRequest() {

//		RestAssured.baseURI = "https://api.github.com";
//		Response response = RestAssured.given().headers(givenHeaders())
//				.body(SingleRepoPayload.createSingleRepo("IPT_Rest")).when().post("/user").then().log().all().extract()
//				.response();
		Response response = singleRepo.createSingleRepoWithInvalidEndpoint();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Constants.HTTPS_STATUS_CREATED, "This repository already exists");
		System.err.println("The Response is:");
		System.out.println(response.asPrettyString());

	}

}
