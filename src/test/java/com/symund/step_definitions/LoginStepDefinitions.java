package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.net.URL;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page of Symund app")
    public void user_is_on_the_login_page_of_Symund_app() {
        String url = ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(url);
    }

    @When("User enters valid user name")
    public void user_enters_valid_user_name() {
        loginPage.inputUsername.sendKeys( ConfigurationReader.getProperty("Username") );
    }

    @When("User enters valid password")
    public void user_enters_valid_password() {
        loginPage.inputPassword.sendKeys( ConfigurationReader.getProperty("Password"));
    }

    @When("User click to the LOG IN button")
    public void user_click_to_the_log_in_button() {
        loginPage.loginButton.click();
    }

    @Then("user can logged in and see the dashboard")
    public void user_can_logged_in_and_see_the_dashboard() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard - Symund - QA";

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @When("User presses the  ENTER from keyboard")
    public void user_presses_the_enter_from_keyboard() {
        loginPage.inputPassword.sendKeys(Keys.ENTER);
    }

    @When("User enters invalid {string} or invalid {string}")
    public void user_enters_invalid_or_invalid(String username, String password) {
       loginPage.inputUsername.sendKeys(username);
       loginPage.inputPassword.sendKeys(password);
    }

    @Then("user can not logged in and {string} displayed")
    public void user_Can_Not_Logged_In_And_Displayed(String sentence) {
        String actualText = loginPage.wrongUserNameOrPasswordText.getText();

        Assert.assertEquals(actualText,sentence);
    }

}
