package com.thor.pages;

import com.thor.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {


        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(tagName = "h3")
    public WebElement pageHeader;

    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountHolderName;

    @FindBy(linkText = "Log Out")
    public WebElement logOutLink;

    public void logOut() {
        accountHolderName.click();
        logOutLink.click();
    }

    public void navigateModule(String moduleName) {
        Driver.getDriver().findElement(By.xpath("//span[@class='title'][.='" + moduleName + "']")).click();
    }
}