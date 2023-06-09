package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement inputUsername;

    @FindBy(xpath ="//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongUserNameOrPasswordText;

    @FindBy(className = "toggle-password")
    public WebElement eyeSign;

    @FindBy(xpath = "//a[@id='lost-password']")
    public WebElement forgotPasswordButton;

    @FindBy (xpath = "//input[@id='reset-password-submit']")
    public WebElement resetPasswordButton;


}
