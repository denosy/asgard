package com.thor.step_defenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;  //

import static io.restassured.RestAssured.*;

public class ApiFaker1_stepDef {


    String url = "https://fakerapi.it/api/v2/books";
    Response response;
    JsonPath jsonPath;


    @Given(": I`m sending request with Query Parameter {string} with value {string}")
    public void i_m_sending_request_with_query_parameter_with_value(String queryParam, String queryValue) {

        response = given()
                .accept(ContentType.JSON)
                .queryParam(queryParam, queryValue)
                .when()
                .get(url).prettyPeek();

    }

    @Given(": I should verify status code is {string}")
    public void i_should_verify_status_code_is(String expectedStatusCodeStr) {

        int expectedStatusCode = Integer.parseInt(expectedStatusCodeStr);
        Assert.assertEquals(expectedStatusCode,response.getStatusCode());

    }

    @Given(": I should verify header Content-Type is equal to {string}")
    public void i_should_verify_header_content_type_is_equal_to(String expectedHeader) {

        String actualHeader = response.getHeader("Content-Type");
        Assert.assertEquals(expectedHeader, actualHeader);

        System.out.println("actualHeader = " + actualHeader);

    }

    @Then(": I Should get status in body response {string}")
    public void i_should_get_status_in_body_response(String expectedStatusInBodyResponse) {

        jsonPath = response.jsonPath();

        String actualStatusInBodyResponse = jsonPath.getString("status");
        Assert.assertEquals(expectedStatusInBodyResponse, actualStatusInBodyResponse);

        System.out.println("actualStatusInBodyResponse = " + actualStatusInBodyResponse);


        String titleIs = jsonPath.getString("data[0].title");
        System.out.println("titleIs = " + titleIs);

    }


    @And(": I Should get seed null")
    public void iShouldGetSeedNull() {

        response.then()
                .assertThat()
                .body("seed",nullValue());
    }



    @Then(": I should see title in response body is not empty")
    public void iShouldSeeTitleInResponseBodyIsNotEmpty() {

            response.then()
                    .assertThat()
                    .body("title",nullValue());

    }


}



