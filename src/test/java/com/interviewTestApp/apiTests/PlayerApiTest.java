package com.interviewTestApp.apiTests;

import com.interviewTestApp.BaseTest;
import com.interviewTestApp.api.entities.requests.PlayerCreateData;
import com.interviewTestApp.api.entities.requests.PlayerDeleteRq;
import com.interviewTestApp.api.entities.requests.PlayerGetByIdRq;
import com.interviewTestApp.api.entities.requests.PlayerUpdateRq;
import com.interviewTestApp.api.entities.responses.PlayerCreateRs;
import com.interviewTestApp.api.entities.responses.PlayerUpdateRs;
import com.interviewTestApp.constants.ApiEndPoints;
import com.interviewTestApp.api.entities.responses.PlayerGetAllRs;
import com.interviewTestApp.utils.LoggerUtil;
import com.interviewTestApp.utils.PlayerComparator;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PlayerApiTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @Description("Test to get all users and validate the response")
    public void testGetAllPlayers() {
        //test will fail because response has wrong schema
        checkStatusCodeAndSchemaInResponse(ApiEndPoints.GET_ALL, 200, "schemas/player-get-all-rs.json");
    }

    @Test
    @Description("Positive test to check create player API functionality")
    public void testCreatePlayer() {
        PlayerCreateData playerCreateData = PlayerCreateData.builder()
                .age(21)
                .gender("male")
                .login("testUser123")
                .role("player")
                .screenName("TEST_USER_123")
                .build();
        LoggerUtil.attachTextLog(String.format("Creating new player: %s", playerCreateData.toString()));
        PlayerCreateRs playerCreateRs = given(requestSpecification)
            .queryParam("age", playerCreateData.getAge())
            .queryParam("gender", playerCreateData.getGender())
            .queryParam("login", playerCreateData.getLogin())
            .queryParam("role", playerCreateData.getRole())
            .queryParam("screenName", playerCreateData.getScreenName())
        .when()
            .get(String.format(ApiEndPoints.GET_CREATE_PLAYER, "admin"))
        .then()
            .statusCode(200)
            .extract().as(PlayerCreateRs.class);
        Assert.assertTrue(PlayerComparator.isEqual(playerCreateData, playerCreateRs));
    }

    @Test
    @Description("Positive test to check delete player API functionality")
    public void testDeletePlayer() {
        PlayerCreateData playerCreateData = PlayerCreateData.builder()
            .age(21)
            .gender("male")
            .login("testUser123")
            .role("player")
            .screenName("TEST_USER_123")
            .build();
        LoggerUtil.attachTextLog(String.format("Creating new player: %s", playerCreateData.toString()));
        PlayerCreateRs playerCreateRs = given(requestSpecification)
                .queryParam("age", playerCreateData.getAge())
                .queryParam("gender", playerCreateData.getGender())
                .queryParam("login", playerCreateData.getLogin())
                .queryParam("role", playerCreateData.getRole())
                .queryParam("screenName", playerCreateData.getScreenName())
            .when()
                .get(String.format(ApiEndPoints.GET_CREATE_PLAYER, "admin"))
            .then()
                .statusCode(200)
                .extract().as(PlayerCreateRs.class);
        Long idToDelete = playerCreateRs.getId();
        PlayerDeleteRq playerDeleteRq = PlayerDeleteRq.builder()
            .playerId(idToDelete)
            .build();
        LoggerUtil.attachTextLog(String.format("Deleting player with id: %d", idToDelete));
        given(requestSpecification)
            .body(playerDeleteRq)
        .when()
            .delete(String.format(ApiEndPoints.DELETE_DELETE_PLAYER_BY_ID, "admin"))
        .then()
            .statusCode(200);
        LoggerUtil.attachTextLog(String.format("Verifying that player with id: %d does not exist", idToDelete));
        PlayerGetAllRs playerGetAllRs = given(requestSpecification)
            .when()
                .get(ApiEndPoints.GET_ALL)
            .then()
                .extract().as(PlayerGetAllRs.class);
        Assert.assertTrue(playerGetAllRs.getPlayers()
                .stream()
                .noneMatch(playerItem -> playerItem.getId().equals(idToDelete)));
    }

    @Test
    @Description("Positive test to check update player API functionality")
    public void testUpdatePlayer() {
        String updatedPasswordData = "UPDATED_PASSWORD123123";
        PlayerCreateData playerCreateData = PlayerCreateData.builder()
                .age(21)
                .gender("male")
                .login("testUser123")
                .role("player")
                .screenName("TEST_USER_123")
                .build();
        LoggerUtil.attachTextLog(String.format("Creating new player: %s", playerCreateData.toString()));
        PlayerCreateRs playerCreateRs = given(requestSpecification)
                .queryParam("age", playerCreateData.getAge())
                .queryParam("gender", playerCreateData.getGender())
                .queryParam("login", playerCreateData.getLogin())
                .queryParam("role", playerCreateData.getRole())
                .queryParam("screenName", playerCreateData.getScreenName())
                .when()
                .get(String.format(ApiEndPoints.GET_CREATE_PLAYER, "admin"))
                .then()
                .statusCode(200)
                .extract().as(PlayerCreateRs.class);
        PlayerUpdateRq playerUpdateRq = PlayerUpdateRq.builder()
                .role(playerCreateRs.getRole())
                .age(playerCreateRs.getAge())
                .gender(playerCreateRs.getGender())
                .login(playerCreateRs.getLogin())
                .password(updatedPasswordData)
                .screenName(playerCreateRs.getScreenName())
                .build();
        Integer idToUpdate = Integer.parseInt(playerCreateRs.getId().toString());
        LoggerUtil.attachTextLog(String.format("Updating player with id: %d", idToUpdate));
        PlayerUpdateRs playerUpdateRs = given(requestSpecification)
                .body(playerUpdateRq)
            .when()
                .patch(String.format(ApiEndPoints.PATCH_UPDATE_PLAYER, "admin", idToUpdate))
            .then()
                .statusCode(200)
                .body("password", equalTo(updatedPasswordData))
                .extract().as(PlayerUpdateRs.class);
        LoggerUtil.attachTextLog(String.format("Verifying player with id: %d has been updated", idToUpdate));
        PlayerGetByIdRq playerGetByIdRq = PlayerGetByIdRq.builder()
                .playerId(idToUpdate)
                .build();
        given(requestSpecification)
            .body(playerGetByIdRq)
        .when()
            .get(ApiEndPoints.POST_GET_PLAYER_BY_ID)
        .then()
            .statusCode(200)
            .body("password", equalTo(updatedPasswordData));
    }
}
