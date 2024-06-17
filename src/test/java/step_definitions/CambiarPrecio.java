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
    public void the_friend_user_is_at(String testPage) {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(testPage);
        pauseForSeconds(3); // Pausa de 3 segundos para observar la carga inicial
    }

    @When("The user pushes the {string} button at navbar")
    public void the_user_pushes_the_button_at_navbar(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Iniciar Sesión']")));
        button.click();
        pauseForSeconds(2); // Pausa de 2 segundos después de hacer clic en el botón de Iniciar Sesión
    }

    @And("Introduces {string} at user\\/email field")
    public void introduces_at_user_email_field(String email) {
        driver.findElement(By.id("username")).sendKeys(email);
        pauseForSeconds(1); // Pausa de 1 segundo después de introducir el email
    }

    @And("Introduces {string} at password field")
    public void introduces_at_password_field(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        pauseForSeconds(1); // Pausa de 1 segundo después de introducir la contraseña
    }

    @And("Pushes {string} button")
    public void pushes_button(String buttonName) {
        driver.findElement(By.xpath("//form/button")).click();
        pauseForSeconds(3); // Pausa de 3 segundos después de hacer clic en el botón de Iniciar Sesión
    }

    @Then("The user is redirected to Mi Perfil section")
    public void user_is_redirected_to_mi_perfil_section() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement perfilLink = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mi Perfil']")));
        perfilLink.click();
        pauseForSeconds(6); // Pausa de 3 segundos después de hacer clic en el enlace de Mi Perfil
    }

    @When("The user pushes the {string} button at sidebar")
    public void the_user_pushes_the_button_at_sidebar(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sidebarButton = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[1]/div[2]/ul/li[4]")));
        sidebarButton.click();
        pauseForSeconds(2); // Pausa de 2 segundos después de hacer clic en el botón de Cuenta de Amigo en
                            // la barra lateral
    }

    @When("The user changes the price to {string}")
    public void the_user_changes_the_price_to(String newPrice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Tiempo de espera más largo
        WebElement priceField = wait.until(ExpectedConditions.elementToBeClickable(By.id("precio")));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        priceField.clear(); // Borrar el valor actual del campo
        priceField.sendKeys(newPrice); // Ingresar el nuevo precio

        try {
            Thread.sleep(2000); // Pausa de 2 segundos después de ingresar el nuevo precio
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("The user pushes the {string} button")
    public void the_user_pushes_the_button(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cambiarPrecioButton = wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[1]")));
        cambiarPrecioButton.click();
        pauseForSeconds(1);
    }

    @And("The user pushes the {string} button at profile sidebar")
    public void the_user_pushes_the_button_at_profile_sidebar(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sidebarButton = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[1]/div[2]/ul/li[1]/p")));
        sidebarButton.click();
    }

    // Método para pausar la ejecución por un número específico de segundos
    private void pauseForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convertir segundos a milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
