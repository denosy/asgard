package com.tor.step_defenitions;

import com.tor.pages.vyTruckPage;
import com.tor.utilities.ConfigurationReader;
import com.tor.utilities.Driver;
import com.tor.utilities.ExcelUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class vyTruck {

    String path = "VyTrackQa2Users.xlsx";
    vyTruckPage vyTruckPage = new vyTruckPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));

    }

    @When("the user login with given credentials from {string} and {int}")
    public void the_user_login_with_given_credentials_from_and(String sheetName, Integer rowNumber) {

        ExcelUtil excelUtil = new ExcelUtil(path,sheetName);

        String username = excelUtil.getCellData(rowNumber,0);
        String password = excelUtil.getCellData(rowNumber,1);
        String firstname = excelUtil.getCellData(rowNumber,2);
        String lastname = excelUtil.getCellData(rowNumber,3);

        vyTruckPage.login(username,password);

    }

    @Then("the user should be able to log in and see their name")
    public void the_user_should_be_able_to_log_in_and_see_their_name() {


    }



}
