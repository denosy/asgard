package com.thor.step_defenitions;

import com.thor.pages.DropDownsPAge;
import com.thor.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class JSEexecutorPerfom_stepDef {

    DropDownsPAge dropDownsPAge = new DropDownsPAge();

    @When("user is on the home page")
    public void user_is_on_the_home_page()  {

        Driver.getDriver().get("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");

    }

    @Then("user should be able to scroll down page")
    public void user_should_be_able_to_scroll_down_page() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,750)");

    }

    @Then("see the text {string}")
    public void see_the_text(String ExpectedVisibleText) {

        String visibleText = dropDownsPAge.lastPageElement.getText();

        Assert.assertEquals(ExpectedVisibleText,visibleText);

    }


}
