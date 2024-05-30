package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BAmigos {

    private WebDriver driver;

    @Given("The friend user is at {string}")
    public void the_friend_user_is_at(String testPage) {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(testPage);
        // throw new io.cucumber.java.PendingException();
    }

    @When("The user pushes the {string} button at navbar")
    public void the_user_pushes_the_button_at_navbar(String string) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Iniciar Sesión']")));
        button.click();
    }

    @And("Introduces {string} at user\\/email field")
    public void introduces_at_user_email_field(String email) {
        driver.findElement(By.id("username")).sendKeys(email);
    }

    @And("Introduces {string} at password field")
    public void introduces_at_password_field(String pass) {
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @And("Pushes {string} button")
    public void pushes_button(String string) {
        driver.findElement(By.xpath("//form/button")).click();
    }

    @Then("The {string} section is shown")
    public void the_section_is_shown(String sect) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement section = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/nav/div/div[1]/ul/li[2]/a")));

        if (!section.getText().equals(sect)) {
            throw new io.cucumber.java.PendingException();
        }
    }

    @Then("The user looks for {string} name on every list result and doesn't find anything")
    public void the_user_looks_for_name_on_every_list_result_and_doesn_t_find_anything(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Espera hasta que al menos un elemento con la clase "card-title" sea visible
        List<WebElement> elements = wait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("card-title")));

        boolean nameFound = false;

        // Recorre la lista y verifica si alguno de los elementos contiene el texto
        // especificado
        for (WebElement element : elements) {
            if (element.getText().contains(name)) {
                nameFound = true;
                break;
            }
        }

        if (nameFound) {
            throw new AssertionError("El nombre " + name + " fue encontrado en la lista.");
        }

        driver.close();
    }

}
