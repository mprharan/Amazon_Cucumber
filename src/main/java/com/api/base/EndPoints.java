package com.api.base;

public class EndPoints {
	public static final String BASE_URI = "https://api.github.com";

	public static class SingleRepo {
		private SingleRepo() {
		}

		public static final String CREATE_REPO = BASE_URI + "/user/repos";
		public static final String GET_REPO = BASE_URI + "/repos/{owner}/{repo}";
		public static final String UPDATE_REPO = BASE_URI + "/repos/{owner}/{repo}/topics";
		public static final String DELETE_REPO = BASE_URI + "/repos/{owner}/{repo}";
		public static final String PATCH_REPO = BASE_URI + "repos/{owner}/{repo}";

	}

	public static class ListOfRepo {
		private ListOfRepo() {
		}

	}

}
