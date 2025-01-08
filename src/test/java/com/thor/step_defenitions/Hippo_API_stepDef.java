package com.thor.step_defenitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class Hippo_API_stepDef {

    Response response;
    String url = "https://api.zippopotam.us/us/";


    @Given(": User is on the zippoptam Page and User sending zip code {string}")
    public void user_is_on_the_zippoptam_page_and_user_sending_zip_code(String zipCode) {

        response = given()
                .accept(ContentType.JSON)
                .when()
                .get(url + zipCode);

    }

    @Given(": Accept header is {string}")
    public void accept_header_is(String expectedHeader) {

        String ActualHeader = response.getHeader("Content-Type");
        Assert.assertEquals(expectedHeader, ActualHeader);

    }

    @Given(": User should see in response state - {string}")
    public void user_should_see_in_response_state(String expectedState) {

        JsonPath jsonPath = response.jsonPath();

        String actualState = jsonPath.getString("places[0].state");
        Assert.assertEquals(expectedState, actualState);


    }

    @Then(": status code should be {int}")
    public void status_code_should_be(int actual_statusCode) {

        Assert.assertEquals(actual_statusCode, response.getStatusCode());

    }


}
