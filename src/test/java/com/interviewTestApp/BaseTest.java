package com.interviewTestApp;

import com.interviewTestApp.api.spec.Specifications;
import com.interviewTestApp.utils.FrameworkConfig;
import com.interviewTestApp.utils.LoggerUtil;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.lang.invoke.MethodHandles;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

@Listeners({AllureTestNg.class})
public class BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected static final FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
    protected static RequestSpecification requestSpecification;

    @BeforeClass
    public void setup() {
        requestSpecification = Specifications.requestSpec(config.baseUrl());
        LOGGER.info("Base URL set to: {}", config.baseUrl());
    }

    public static ValidatableResponse checkStatusCodeAndSchemaInResponse(String url, int code, String schema) {
        LoggerUtil.attachTextLog(String.format("Checking that response on GET request %s has status code %d.", url, code));
        LoggerUtil.attachTextLog(String.format("Validating response with schema in '%s'", schema));
        return RestAssured.given(requestSpecification)
                .get(url)
                .then()
                .statusCode(code)
                .body(matchesJsonSchemaInClasspath(schema))
                .time(lessThan(1500L));
    }
}
