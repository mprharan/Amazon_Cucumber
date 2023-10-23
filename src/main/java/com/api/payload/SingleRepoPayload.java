package com.api.payload;

public class SingleRepoPayload {

	public static String createSingleRepo(String repo) {
		String payload = "{\r\n" + "    \"name\": \"" + repo + "\",\r\n"
				+ "    \"description\": \"This is for API practice!\",\r\n"
				+ "    \"homepage\": \"https://github.com\",\r\n" + "    \"private\": true,\r\n"
				+ "    \"is_template\": true\r\n" + "}";
		return payload;
	}

	public static String updateSingleRepo() {
		String payload = "{\r\n" + "    \"names\": [\r\n" + "        \"get\",\r\n" + "        \"put\",\r\n"
				+ "        \"post\",\r\n" + "        \"delete\"\r\n" + "    ]\r\n" + "}";
		return payload;
	}
}
