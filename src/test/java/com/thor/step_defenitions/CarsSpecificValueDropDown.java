package com.thor.step_defenitions;

import com.thor.pages.DropDownsPAge;
import com.thor.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;



public class CarsSpecificValueDropDown {

    DropDownsPAge dropDownsPAge = new DropDownsPAge();

    @Given("User is on the dropDowns page and")
    public void user_is_on_the_drop_downs_page_and() throws InterruptedException {

        Driver.getDriver().get("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");

        Thread.sleep(2000);


    }
    @Then("user should see below in the list one name {string}")
    public void user_should_see_below_in_the_list_one_name(String LookingCar) {

        Select select = new Select(dropDownsPAge.carsElements);
        select.selectByVisibleText("Audi");

        String ActualCar = select.getFirstSelectedOption().getText();
        Assert.assertEquals(LookingCar,ActualCar);

    }

}
