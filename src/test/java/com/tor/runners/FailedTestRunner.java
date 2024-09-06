package com.tor.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "@target/rerun.txt", // will read rerun.txt what ever inside and rerun
        glue = "com/tor/step_defenitions"

)
public class FailedTestRunner { }
