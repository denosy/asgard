package com.tor.pages;

import com.tor.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vyTruckPage {


    public vyTruckPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//input[@name='_username']")
    public WebElement username;


    @FindBy (xpath = "//input[@type='password']")
    public WebElement password;


    @FindBy (xpath = "//button[@type='submit']")
    public WebElement logInBtn;


    public void login(String username,String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        logInBtn.click();
    }





}
