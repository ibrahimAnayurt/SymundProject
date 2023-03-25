package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
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


    @Then("{string} can not logged in and displayed {string}")
    public void user_can_not_logged_in_and_displayed(String username,String string) {

        if (username.isEmpty()) {
            String message = loginPage.inputUsername.getAttribute("validationMessage");
            Assert.assertEquals(string, message);
        } else {
            String message1 = loginPage.inputPassword.getAttribute("validationMessage");
            Assert.assertEquals(string, message1);
        }
    }

    @Then("User should see the password in a form of dots by default")
    public void user_should_see_the_password_in_a_form_of_dots_by_default() {
        Assert.assertTrue(loginPage.inputPassword.getAttribute("type").equals("password"));
    }


    @Then("User can see the password explicitly")
    public void user_can_see_the_password_explicitly() {
        Assert.assertTrue(loginPage.inputPassword.getAttribute("type").equals("text"));
    }

    @When("User click to the eye sign button")
    public void user_click_to_the_eye_sign_button() {
        loginPage.eyeSign.click();
    }

    @When("User can see the forgot password button")
    public void user_can_see_the_forgot_password_button() {
        loginPage.forgotPasswordButton.isDisplayed();
    }
    @When("User click to the forgot password button")
    public void user_click_to_the_forgot_password_button() {
        loginPage.forgotPasswordButton.click();
    }
    @Then("User should see the reset password button")
    public void user_should_see_the_reset_password_button() {
        loginPage.resetPasswordButton.isDisplayed();
    }

    @When("user can see the valid placeholder on {string} field")
    public void user_can_see_the_valid_placeholder_on_field(String string) {
        String actualTextofUsername = loginPage.inputUsername.getAttribute("placeholder");
        Assert.assertEquals(actualTextofUsername,string);
    }
    @When("user should see the valid placeholder on {string} field")
    public void user_should_see_the_valid_placeholder_on_field(String string) {
        String actualTextofPassword = loginPage.inputPassword.getAttribute("placeholder");
        Assert.assertEquals(actualTextofPassword,string);
    }


}
