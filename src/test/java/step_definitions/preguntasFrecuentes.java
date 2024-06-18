package step_definitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class preguntasFrecuentes {

    private WebDriver driver;

    @Given("The client user is at {string}")
    public void the_client_user_is_at(String testPage) {
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

    @And("The user logs in with the credentials {string} and {string}")
    public void the_user_logs_in_with_the_credentials(String email, String password) {
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//form/button")).click();
        pauseForSeconds(5); // Pausa de 5 segundos después de hacer clic en el botón de Iniciar Sesión
    }

    @And("The user clicks on the {string} tab in the navbar")
    public void the_user_clicks_on_the_tab_in_the_navbar(String tabName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homeTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + tabName + "']")));
        homeTab.click();
        pauseForSeconds(3); // Pausa de 3 segundos después de hacer clic en la pestaña Home
    }

    @And("The user scrolls down to the {string} section")
    public void the_user_scrolls_down_to_the_section(String sectionName) {
        WebElement faqSection = driver.findElement(By.xpath("//h2[text()='" + sectionName + "']"));
        ((ChromeDriver) driver).executeScript("arguments[0].scrollIntoView(true);", faqSection);
        pauseForSeconds(3); // Pausa de 3 segundos después de desplazarse a la sección de Preguntas frecuentes
    }

    @And("The user presses the {string} button below the description of the section")
    public void the_user_presses_the_button_below_the_description_of_the_section(String buttonName) {
        // Esperar a que la sección de Preguntas Frecuentes esté presente en la página
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement faqSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Preguntas Frecuentes')]")));

        // Desplazar la página hacia la sección de Preguntas Frecuentes
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", faqSection);

        // Esperar a que el botón "Leer más..." esté presente y sea clicleable
        WebElement leerMasButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-azul'][text()='Leer más...']")));
        leerMasButton.click();
        pauseForSeconds(5); // Pausa de 5 segundos después de hacer clic en el botón Leer más...
    }




    @Then("The user is redirected to a construction page")
    public void the_user_is_redirected_to_a_construction_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("preguntas-frecuentes"));
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("preguntas-frecuentes")) {
            throw new AssertionError("The user was not redirected to the construction page.");
        }
        driver.quit();
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








