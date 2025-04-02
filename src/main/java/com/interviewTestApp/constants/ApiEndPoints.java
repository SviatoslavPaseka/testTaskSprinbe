package com.interviewTestApp.constants;

public class ApiEndPoints {
    private static final String PLAYER = "/player";
    public static final String GET_ALL = PLAYER + "/get/all";
    public static final String GET_CREATE_PLAYER = PLAYER + "/create/%s";
    public static final String POST_GET_PLAYER_BY_ID = PLAYER + "/get";
    public static final String DELETE_DELETE_PLAYER_BY_ID = PLAYER + "/delete/%s";
    public static final String PATCH_UPDATE_PLAYER = PLAYER + "/update/%s/%s";
}
