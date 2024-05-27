package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver driver;

    @Given("The user is at {string}")
    public void the_user_is_at(String testPage) {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(testPage);
        //throw new io.cucumber.java.PendingException();
    }

    @When("The user introduces {string} as username")
    public void the_user_introduces_as_username(String userName) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("username")).sendKeys(userName);
        //throw new io.cucumber.java.PendingException();
    }

    @When("The user introduces {string} as password")
    public void the_user_introduces_as_password(String pass) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("password")).sendKeys(pass);

        //throw new io.cucumber.java.PendingException();
    }

    @When("The user pushes the {string} button")
    public void the_user_pushes_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//button")).click();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("The message {string} is shown")
    public void the_message_is_shown(String msg) {
        // Write code here that turns the phrase above into concrete actions
        if(!driver.findElement(By.xpath("//h4")).getText().equals(msg)) {
            throw new io.cucumber.java.PendingException();
        }
        driver.close();
    }
}
