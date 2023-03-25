package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.pages.LogoutPage;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.URL;

public class LogoutStepDefinitions {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @Given("User is logged in and is on the dashboard page")
    public void user_is_logged_in_and_is_on_the_dashboard_page() {
        Driver.getDriver().get( ConfigurationReader.getProperty("URL") );
        loginPage.inputUsername.sendKeys( ConfigurationReader.getProperty("Username") );
        loginPage.inputPassword.sendKeys( ConfigurationReader.getProperty("Password") );
        loginPage.loginButton.click();
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard - Symund - QA";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @When("User click to the account name dropdown")
    public void user_click_to_the_account_name_dropdown() {
        logoutPage.accountButton.click();
    }
    @When("User see and click the Log out button")
    public void user_see_and_click_the_log_out_button() {
        logoutPage.logoutButton.isDisplayed();
        logoutPage.logoutButton.click();
    }
    @Then("User logged out and see the login page")
    public void user_logged_out_and_see_the_login_page() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Symund - QA";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


}
