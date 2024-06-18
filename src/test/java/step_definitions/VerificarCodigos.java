package step_definitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class VerificarCodigos {
    private WebDriver driver;

    @Dado("Un usuario cliente registrándose en {string}")
    public void unUsuarioClienteRegistrandoseEn(String url) {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @Cuando("Llena parcialmente el formulario con los datos {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void llenaParcialmenteElFormularioConLosDatos(String nombre, String apPaterno, String apMaterno,
                                                         String fechaNacimiento, String genero, String ubicacion,
                                                         String nomUsuario, String correo, String password) {
        Map<String, String> fieldData = new HashMap<>();
        fieldData.put("nombre", nombre);
        fieldData.put("apellido_paterno", apPaterno);
        fieldData.put("apellido_materno", apMaterno);
        fieldData.put("fecha_nacimiento", fechaNacimiento);
        fieldData.put("genero", genero);
        fieldData.put("ubicacion", ubicacion);
        fieldData.put("nombre_usuario", nomUsuario);
        fieldData.put("correo_electronico", correo);
        fieldData.put("contraseña", password);

        for (Map.Entry<String, String> entry : fieldData.entrySet()) {
            WebElement input = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id(entry.getKey())));
            input.sendKeys(entry.getValue());
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.findElement(By.id("confirmar_contraseña")).sendKeys(password);
    }


    @Y("Pulsa el botón 'Siguiente'")
    public void pulsaElBotonSiguiente() {
        driver.findElement(By.xpath("//button[contains(@class, 'false')]")).click();
    }

    @Y("Ingresa un {string} aleatorio")
    public void pulsaElBotonEnviarCodigo(String codigo) {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder, 'Codigo')]")));
        button.sendKeys(codigo);
    }

    @Entonces("Recibe códigos de verificación en la bandeja de su {string} en {string} usando su {string}")
    public void recibeCodigosDeVerificacionEnLaBandejaDeSuEnUsandoSu(String email, String urlGmail, String password) {
        driver.findElement(By.xpath("//button[contains(@class, 'btn-verde')]")).click();
        WebElement message = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div/p[6]")));

        Assert.assertEquals(message.getText(), "Código de verificación incorrecto.");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}