package com.tor.step_defenitions;

import com.tor.pages.WikipediaPage;
import com.tor.utilities.BrowserUtils;
import com.tor.utilities.ConfigurationReader;
import com.tor.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wikipedia_login {

    WikipediaPage wikipediaPage = new WikipediaPage();


    @Given("User logged as a wikipedia authorized user")
    public void user_logged_as_a_wikipedia_authorized_user() {

        wikipediaPage.loginBtnAuth.click();
        wikipediaPage.userNameBox.sendKeys(ConfigurationReader.getProperty("wiki_username"));
        wikipediaPage.passWordBox.sendKeys(ConfigurationReader.getProperty("wiki_user01_password"));

    }

    @When("User enters {string} in the search box")
    public void user_enters_in_the_search_box(String searchName) {

       wikipediaPage.searchBox.sendKeys(searchName);
    }

    @Then("User clicks wikipedia search button")
    public void user_clicks_wikipedia_search_button() {

            wikipediaPage.searchButtonLogin.click();
    }

    @Then("User has to see {string} is in the image header")
    public void user_has_to_see_is_in_the_image_header(String searchName) {

        String imgHeader = wikipediaPage.imgHeader.getText();
        Assert.assertEquals(searchName,imgHeader);
        System.out.println("imgHeader = " + imgHeader);


    }

    @Then("User has to see {string} is in the wiki title")
    public void user_has_to_see_is_in_the_wiki_title(String searchName) {

        BrowserUtils.verifyTitle(searchName+ " - Wikipedia");

        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

    }

    @Then("User has to see {string} is in the main header")
    public void userhas_to_see_is_in_the_main_header(String searchName) {

        String mainHeader = wikipediaPage.mainHeader.getText();
        Assert.assertEquals(searchName,mainHeader);
        System.out.println("mainHeader = " + mainHeader);

    }


}
