package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BAmigos {

    private WebDriver driver;

    @When("The user pushes the {string} button at navbar")
    public void the_user_pushes_the_button_at_navbar(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.findElement(By.xpath("//a[1]")).click();


    }

    @When("Introduces {string} at user\\/email field")
    public void introduces_at_user_email_field(String email) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("username")).sendKeys(email);

    }
    @When("Introduces {string} at password field")
    public void introduces_at_password_field(String pass) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("Pushes {string} button")
    public void pushes_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//form/button")).click();
    }

    @Then("The {string} section is shown")
    public void the_section_is_shown(String sect) {
        // Write code here that turns the phrase above into concrete actions
        if(!driver.findElement(By.xpath("//li[2]/a")).getText().equals(sect)){
            throw new io.cucumber.java.PendingException();
        }
    }
    @Then("The user looks for {string} name on every list result and doesn't find anything")
    public void the_user_looks_for_name_on_every_list_result_and_doesn_t_find_anything(String string) {
        // Write code here that turns the phrase above into concrete actions

        throw new io.cucumber.java.PendingException();
    }
}
