package com.api.clients;

import java.util.HashMap;
import java.util.Map;

import com.api.base.EndPoints;
import com.api.base.HttpMethods;
import com.api.payload.SingleRepoPayload;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SingleRepoClient {
	
	private static Map<String, String> validHeader=new HashMap<>();
	private static Map<String, String> invalidHeader=new HashMap<>();
	
	public SingleRepoClient(){
		
		try {
			validHeader.put("Accept", "application/vnd.github+json");
			validHeader.put("Authorization", "Bearer " + "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");
			
			invalidHeader.put("Accept", "application/vnd.github+json");
			invalidHeader.put("Authorization", "Bearer " + "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123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Map<String, String> getValidHeader() {
		return validHeader;
	}
	
	public Map<String, String> getInvalidHeader() {
		return invalidHeader;
	}
	
	public Response createSingleRepoWithValidAuth() {
		
		String endpoint = EndPoints.SingleRepo.CREATE_REPO;

//		Response response = RestAssured.given().headers(validHeader)
//				.body(SingleRepoPayload.createSingleRepo(payloadrepo)).when().post(endpoint).then().log()
//				.all().extract().response();
//		
		return HttpMethods.doPostCallWithBody(validHeader, SingleRepoPayload.createSingleRepo("IPT_REST"), endpoint);
	}
	
	public Response createSingleRepoWithInvalidAuth() {
		
		String endpoint = EndPoints.SingleRepo.CREATE_REPO;

//		Response response = RestAssured.given().headers(invalidHeader)
//				.body(SingleRepoPayload.createSingleRepo(payloadrepo)).when().post(endpoint).then().log()
//				.all().extract().response();
		
		return HttpMethods.doPostCallWithBody(invalidHeader,SingleRepoPayload.createSingleRepo("IPT_REST"), endpoint);

	}

	public Response createSingleRepoWithInvalidEndpoint() {

		String endpoint = EndPoints.SingleRepo.GET_REPO;
		return HttpMethods.doPostCallWithBody(validHeader,SingleRepoPayload.createSingleRepo("IPT_REST"), endpoint);

	}
	
	public Response deleteSingleRepoWithValidAuth() {
		String endpoint = EndPoints.SingleRepo.DELETE_REPO;
		return HttpMethods.deleteRepo(validHeader,SingleRepoPayload.createSingleRepo("IPT_REST"), endpoint);
	}

}
