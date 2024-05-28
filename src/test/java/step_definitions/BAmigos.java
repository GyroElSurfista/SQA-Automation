package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BAmigos {

    private WebDriver driver;

    @When("The user pushes the {string} button at navbar")
    public void the_user_pushes_the_button_at_navbar(String string) {
        driver = new ChromeDriver();
        driver.get("https://friender.vercel.app/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Iniciar Sesión']")));
        button.click();
    }

    @When("Introduces {string} at user\\/email field")
    public void introduces_at_user_email_field(String email) {
        driver.findElement(By.id("username")).sendKeys(email);
    }

    @When("Introduces {string} at password field")
    public void introduces_at_password_field(String pass) {
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("Pushes {string} button")
    public void pushes_button(String string) {
        driver.findElement(By.xpath("//form/button")).click();
    }

    @Then("The {string} section is shown")
    public void the_section_is_shown(String sect) {
        if (!driver.findElement(By.xpath("//li[2]/a")).getText().equals(sect)) {
            throw new io.cucumber.java.PendingException();
        }
    }

    @Then("The user looks for {string} name on every list result and doesn't find anything")
    public void the_user_looks_for_name_on_every_list_result_and_doesn_t_find_anything(String string) {
        throw new io.cucumber.java.PendingException();
    }
}
