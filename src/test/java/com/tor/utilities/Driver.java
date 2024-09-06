package com.tor.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    // create a private constructor to remove access to this object
    //we make the webDriver private because we want to close access from outside the class
    //We are making it static, because we will use it in a static method


    // private static WebDriver driver; // default value = null

    public static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which return the same driver instance once we call it
    - If an instance doesn`t exists, it will create first, and then it will always returm same instance
     */

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            /*
            We will read our browserType from configuration.properties file.
            This way, we can control which browser is opened from outside out code
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType reurnded from the configuration.properties switch
            statement will determine the "case" and open the matching browser
             */

            switch (browserType) {
                case "chrome":
                    // WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //  WebDriverManager.chromedriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "headless-chrome":
                    // WebDriverManager.chromedriver().setup();
                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(option));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
                /*
                This line will terminate the currently existing driver completely. It will be non
                - exist
                 */
            driverPool.get().quit();

                /*
                we assign the value back to null so that my "singleton/threads" can create a newer one if needed
                 */

            driverPool.remove();
            //  driver = null;


        }
    }


}
