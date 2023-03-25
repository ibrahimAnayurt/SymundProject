package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends LoginPage {

    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@aria-label='Settings']")
    public WebElement accountButton;

    @FindBy(xpath = "//nav[@class='settings-menu menu']/ul/li[4]/a")
    public WebElement logoutButton;


}
