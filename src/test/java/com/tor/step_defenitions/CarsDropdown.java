package com.tor.step_defenitions;

import com.tor.pages.DropDownsPAge;
import com.tor.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CarsDropdown {

    DropDownsPAge dropDownsPAge = new DropDownsPAge();

    @Then("user should see below info in cars dropDown")
    public void user_should_see_below_info_in_cars_drop_down(List<String> carsDrop) {

        Driver.getDriver().get("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");

        Select select = new Select(dropDownsPAge.carsElements);

        List<WebElement> carsAsWeb = select.getOptions();
        List<String> carsAsString = new ArrayList<>();

        for (WebElement eachCar : carsAsWeb) {
            carsAsString.add(eachCar.getText());
        }


        System.out.println("carsAsString = " + carsAsString);
        Assert.assertEquals(carsDrop,carsAsString);





    }


}
