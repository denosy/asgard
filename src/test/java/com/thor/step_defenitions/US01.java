package com.thor.step_defenitions;

import com.thor.utilities.ConfigurationReader;
import com.thor.utilities.LibraryAPI_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

public class US01 {

    RequestSpecification givenPart;
    Response response;
    ValidatableResponse thenPart;
    RequestSpecification id;


    @Given("I logged Library api as a {string}")
    public void i_logged_library_api_as_a(String userType) {

        givenPart = given().log().uri()
                .header("x-library-token", LibraryAPI_Util.getToken(userType));
    }

    @Given("Accept header is {string}")
    public void accept_header_is(String contentType) {

        givenPart.accept(contentType);

    }

    @When("I send GET request to {string} endpoint")
    public void i_send_get_request_to_endpoint(String endPoint) {

        response = givenPart.when().get(ConfigurationReader.getProperty("library.baseUri") + endPoint).prettyPeek();
        thenPart = response.then();

    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer statusCode) {

        thenPart.statusCode(statusCode);

    }

    @Then("Response Content type is {string}")
    public void response_content_type_is(String contentType) {

        thenPart.contentType(contentType);
    }

    @Then("{string} field should not be null")
    public void field_should_not_be_null(String path) {

            thenPart.body(path,everyItem(notNullValue()));

    }




    /**
     *** ------------------------------------ US2 ---------------------------------- ***
     */

    @Given("Path param is {string}")
    public void path_param_is(String pathParam) {

        id = givenPart.pathParam("id", pathParam);

    }
    @Then("{string} field should be same with path param")
    public void field_should_be_same_with_path_param(String sameAsParam) {

            thenPart.body(sameAsParam,is(equalTo(id)));

    }
    @Then("following fields should not be null")
    public void following_fields_should_not_be_null(io.cucumber.datatable.DataTable dataTable) {

        //Разобраться как дата тейбл делать асоршен - посмотреть урок кукумбер АРI




    }


}
