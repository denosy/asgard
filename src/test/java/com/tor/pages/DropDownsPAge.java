package com.tor.pages;

import com.tor.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownsPAge {


    public DropDownsPAge(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


   @FindBy(id = "month")
    public WebElement monthDropDown;




    @FindBy(id = "Carlist")
    public WebElement carsElements;

}