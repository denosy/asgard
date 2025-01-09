package com.thor.step_defenitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class ZippoptamAPI2_stepDef {

    Response response;
    String url = "https://api.zippopotam.us/us/";

    @Given(": User is on the reqest Page sending sent request")
    public void user_is_on_the_reqest_page_sending_sent_request() {

        response = given()
                .accept(ContentType.JSON)
                .get( url +"90210");

        Assert.assertEquals(200, response.statusCode());
    }

    @Then(":  I`m getting response")
    public void i_m_getting_response() {

        JsonPath jsonPath = response.jsonPath();

        String actualCountry = jsonPath.getString("country");
        Assert.assertEquals("United States", actualCountry);
    }






}
