package com.test.api;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.Constants;
import com.api.clients.SingleRepoClient;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DelSingleRepo {
	/*
	 * @Test private Map<String, String> givenHeaders() {
	 * 
	 * Map<String, String> header = new HashMap<>(); header.put("Accept",
	 * "application/vnd.github+json"); header.put("Authorization", "Bearer " +
	 * "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"); return header;
	 * 
	 * }
	 */
	SingleRepoClient singleRepo=new SingleRepoClient();
	@Test
	private void deleteSingleRepo() {
		/*
		 * RestAssured.baseURI = "https://api.github.com";
		 * 
		 * Response response = RestAssured.given().headers(givenHeaders()).when()
		 * .delete("/repos/hariharanmpr/RestAssuredProject").then().log().all().extract(
		 * ).response();
		 */
		
		Response response=singleRepo.deleteSingleRepoWithValidAuth();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Constants.HTTPS_STATUS_NOCONTENT);
		System.out.println(response.asPrettyString());
	}

}
