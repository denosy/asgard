package com.tor.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    /*
        This method will accept int (in seconds)
        and execute Thread.sleep method for given duration
         */


    public static void sleep(int second) {
        second *= 100;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void SwitchWindowAndVerify(String expectedUrl, String expectedTitle) {

        Set<String> AllWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : AllWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            Driver.getDriver().getCurrentUrl();
            if (Driver.getDriver().getCurrentUrl().contains(expectedUrl)) {
                break;
            }
        }

        String actualTile = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTile.contains(expectedTitle));
    }


    public static void verifyTitle( String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(String expectedTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

/*
This method accepts WbElement target
and waits for that WebElement not to be displayed on the page
 */

    public static void waitForInvisibilityOf(WebElement target) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }


    /*
    This method accepts the String title
    and waits for that title tp contain given String value
     */

    public static void waitForTitleContains(String title) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains(title));
    }


    public static List<String> dropDownOptions_as_STRING(WebElement dropdownWebElement){

        Select month = new Select(dropdownWebElement);
        //Storing all options into a list of a WebElements
        List<WebElement> actualMonth_as_WebElement = month.getOptions();

        //Creating an Empty List of String to store ACTUAL <options> as String
        List<String> actualMonth_as_STRING = new ArrayList<>();

        //looping through , the List <WebElement>, getting all options texts and storing into  List<String>
        for (WebElement each : actualMonth_as_WebElement){

            actualMonth_as_STRING.add(each.getText());

        }

        return actualMonth_as_STRING;
    }


    public static void expectedInURL(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));

    }





}
