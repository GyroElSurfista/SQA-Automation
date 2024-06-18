package step_definitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class verTotal {
    private WebDriver driver;

    @Given("The client user is at {string}")
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

    @And("The user logs in with the credentials {string} and {string}")
    public void introduces_at_user_email_field(String email, String pass) {
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.xpath("//form/button")).click();
    }

    @And("The user selects a friend from the list in {string}")
    public void selects_a_friend(String sec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement verPerfilButton = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"lista_amigos\"]/div[3]/div/div[1]/div/div[2]/div/div[2]/a")));
        
        verPerfilButton.click();

        // Espera hasta que el botón 'Solicitar Cita' esté visible y habilitado
        WebElement solicitarCitaButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Solicitar Cita']")));
        
        // Hacer clic en el botón 'Solicitar Cita'
        solicitarCitaButton.click();
    }

    @And("The user enters a {string} of the meeting")
    public void enters_duration_of_meeting(String duration){
        WebElement duracionInput = driver.findElement(By.name("duracion"));
        duracionInput.clear(); // Limpiar el campo de entrada antes de ingresar la duración
        duracionInput.sendKeys(duration);
    }

    @Then("The system calculates and shows the total cost of the meeting")
    public void calculates_shows_total_cost_meeting() {
        WebElement precioPorHoraElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/p/h4"));

        // Extraer el texto y procesarlo para obtener el precio por hora
        String precioPorHoraText = precioPorHoraElement.getText();
        int precioPorHora = Integer.parseInt(precioPorHoraText.replace("Precio:", "").replace("Bs/hr", "").trim());

        // Obtener la duración de la reunión ingresada
        int duracion = Integer.parseInt(driver.findElement(By.name("duracion")).getAttribute("value"));
        int totalEsperado = precioPorHora * duracion;

        // Localizar el elemento que contiene el costo total
        WebElement costoTotalElement = driver.findElement(By.id("texto-precio"));
        int totalCalculado = Integer.parseInt(costoTotalElement.getText().replace("Total:", "").replace("Bs", "").trim());

        // Verificar que el cálculo sea correcto
        assert totalEsperado == totalCalculado;

        //driver.close();
    }
}

