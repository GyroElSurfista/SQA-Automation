package step_definitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CambiarPrecio {

    private WebDriver driver;

    @Given("The friend user is at {string}")
    public void the_friend_user_is_at(String testPage) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(testPage);
        Thread.sleep(3000);
    }

    @When("The user pushes the {string} button at navbar")
    public void the_user_pushes_the_button_at_navbar(String buttonName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Iniciar Sesión']")));
        button.click();
        Thread.sleep(2000);
    }

    @And("Introduces {string} at user\\/email field")
    public void introduces_at_user_email_field(String email) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(email);
        Thread.sleep(1000);
    }

    @And("Introduces {string} at password field")
    public void introduces_at_password_field(String password) throws InterruptedException {
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
    }

    @And("Pushes {string} button")
    public void pushes_button(String buttonName) throws InterruptedException {
        driver.findElement(By.xpath("//form/button")).click();
        Thread.sleep(3000);
    }

    @Then("The user is redirected to Mi Perfil section")
    public void user_is_redirected_to_mi_perfil_section() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement perfilLink = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mi Perfil']")));
        perfilLink.click();
        Thread.sleep(6000);
    }

    @When("The user pushes the {string} button at sidebar")
    public void the_user_pushes_the_button_at_sidebar(String buttonName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sidebarButton = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[1]/div[2]/ul/li[4]")));
        sidebarButton.click();
        Thread.sleep(2000);
    }

    @When("The user changes the price to {string}")
    public void the_user_changes_the_price_to(String newPrice) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Tiempo de espera más largo
        WebElement priceField = wait.until(ExpectedConditions.elementToBeClickable(By.id("precio")));

        Thread.sleep(1000);

        priceField.clear();
        priceField.sendKeys(newPrice);

        Thread.sleep(2000);

    }

    @And("The user pushes the {string} button")
    public void the_user_pushes_the_button(String buttonName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cambiarPrecioButton = wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[1]")));
        cambiarPrecioButton.click();
        Thread.sleep(1000);
    }

    @And("The user pushes the {string} button at profile sidebar")
    public void the_user_pushes_the_button_at_profile_sidebar(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sidebarButton = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[1]/div[2]/ul/li[1]/p")));
        sidebarButton.click();
    }
}
