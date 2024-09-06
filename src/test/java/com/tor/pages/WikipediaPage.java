package com.tor.pages;

import com.tor.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPage {

     public WikipediaPage(){
         PageFactory.initElements(Driver.getDriver(),this);
     }


     @FindBy (xpath = "//a[@data-mw='interface']//span[contains(text(),'Log in')]")
     public WebElement LogInBtn;


    @FindBy(id ="searchInput" )
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='wpName1']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='wpPassword1']")
    public WebElement passWordBox;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[2]/nav[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/a[1]/span[1]")
    public WebElement loginBtnAuth;

    @FindBy(xpath = "//input[@title='Search Wikipedia [alt-shift-f]']")
    public WebElement getSearchBoxAuth;

    @FindBy(xpath = "(//button[@class='cdx-button cdx-button--action-default cdx-button--weight-normal cdx-button--size-medium cdx-button--framed cdx-search-input__end-button'])[1]")
    public WebElement searchButtonLogin;








     @FindBy(xpath ="//button[@type='submit']")
    public WebElement searchButton;
    @FindBy(id ="firstHeading" )
    public WebElement mainHeader;
    @FindBy(xpath ="//div[@class='fn']" )
    public WebElement imgHeader;


}
