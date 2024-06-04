package step_definitions;

import base.ChromeDriverCreator;
import base.WebDriverCreator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class Login {

    private final WebDriverCreator webDriverCreator = new ChromeDriverCreator();
    private final LoginPage loginPage = new LoginPage(webDriverCreator.createWebDriver());

    @Given("The user is at {string}")
    public void the_user_is_at(String testPage) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.openLoginPage(testPage);
        //throw new io.cucumber.java.PendingException();
    }

    @When("The user introduces {string} as username")
    public void the_user_introduces_as_username(String userName) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.setUsernameText(userName);
        //throw new io.cucumber.java.PendingException();
    }

    @When("The user introduces {string} as password")
    public void the_user_introduces_as_password(String pass) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.setPasswordText(pass);

        //throw new io.cucumber.java.PendingException();
    }

    @When("The user pushes the {string} button")
    public void the_user_pushes_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLoginButton();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("The message {string} is shown")
    public void the_message_is_shown(String msg) {
        // Write code here that turns the phrase above into concrete actions
        if(!loginPage.verifyMessage(msg)) {
            throw new io.cucumber.java.PendingException();
        }
        loginPage.close();
    }
}