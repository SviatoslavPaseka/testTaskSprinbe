package com.interviewTestApp.apiTests;

import com.interviewTestApp.BaseTest;
import com.interviewTestApp.api.entities.requests.PlayerCreateData;
import com.interviewTestApp.api.entities.requests.PlayerGetByIdRq;
import com.interviewTestApp.constants.ApiEndPoints;
import com.interviewTestApp.utils.LoggerUtil;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

import static io.restassured.RestAssured.given;

public class PlayerNegativeApiTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @Description("Negative test to check create player with missing required parameter API functionality")
    public void testNegativeCreatePlayer() {
        PlayerCreateData playerCreateData = PlayerCreateData.builder()
                .age(21)
                .gender("male")
                .login("testUser123")
                .role("player")
                .screenName("TEST_USER_123")
                .build();
        LoggerUtil.attachTextLog(String.format("Creating new player: %s", playerCreateData.toString()));
        given(requestSpecification)
            .queryParam("gender", playerCreateData.getGender())
            .queryParam("login", playerCreateData.getLogin())
            .queryParam("role", playerCreateData.getRole())
            .queryParam("screenName", playerCreateData.getScreenName())
        .when()
            .get(String.format(ApiEndPoints.GET_CREATE_PLAYER, "admin"))
        .then()
            .statusCode(400);
    }
    @Test
    @Description("Negative test to check get player by id with not existed id API functionality")
    public void testNegativeGetByIdPlayer() {
        Integer idToTest = Integer.MAX_VALUE - 1;
        PlayerGetByIdRq playerGetByIdRq = PlayerGetByIdRq.builder()
            .playerId(idToTest)
            .build();
        LoggerUtil.attachTextLog(String.format("Verifying player with id: %d has been updated", idToTest));
        given(requestSpecification)
            .body(playerGetByIdRq)
        .when()
            .post(ApiEndPoints.POST_GET_PLAYER_BY_ID)
        .then()
            .statusCode(415)
                .log().all();
    }
}
