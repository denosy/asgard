package com.tor.step_defenitions;

import com.tor.pages.DropDownsPAge;
import com.tor.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTable_stepDef {

    @Then("user should see below list")
    public void user_should_see_below_list(List<String> fruits) {

        System.out.println("fruits = " + fruits);
        System.out.println("fruits.get(1) = " + fruits.get(1));
    }

    @Then("user should see any data he wants")
    public void user_should_see_any_data_he_wants(Map<String, String> avengerInfo) {

        System.out.println("avengerInfo = " + avengerInfo);
        System.out.println("avengerInfo.get(\"address\") = " + avengerInfo.get("address"));
    }


    @Given("User is on the dropDowns page")
    public void user_is_on_the_drop_downs_page() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    DropDownsPAge dropDownsPAge = new DropDownsPAge();

    @Then("user should see below info in month dropDown")
    public void user_should_see_below_info_in_month_drop_down(List<String> expectedMoth) {

        Select month = new Select(dropDownsPAge.monthDropDown);

        List<WebElement> actualMonth_As_WebElement = month.getOptions();
        List<String> actualMonth_As_String = new ArrayList<>();

        for (WebElement each : actualMonth_As_WebElement) {

            actualMonth_As_String.add(each.getText());
        }

        Assert.assertEquals(expectedMoth, actualMonth_As_String);

    }


}
