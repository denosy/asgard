package com.tor.step_defenitions;

/*
In this class we are able to crate "pre" and "post" condition for all the scenarios and steps
 */


import com.tor.utilities.ConfigurationReader;
import com.tor.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before (value = "@parameterization2")  //- and it`s going to be applied only for specific scenario, and specified order for executing
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url_wiki"));
    }

    @After                         //keeping track the scenario that is currently being executed;
    public void teardownMethod(Scenario scenario) {

        if (scenario.isFailed()){

            //It`s coming from another interface, and we have to cast our Driver to be able to use this method
            byte[]screenshot =((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());

        }

       // System.out.println("--> @After : RUNNING AFTER EACH SCENARIO");
        Driver.closeDriver();

    }


    @BeforeStep
    public void setupStep(){

      //  System.out.println("before STep");

    }

    @AfterStep
    public void teardownStep(){

      //  System.out.println("after STep");

    }

}
