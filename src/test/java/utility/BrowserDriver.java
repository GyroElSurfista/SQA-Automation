package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {

    public static WebDriver driver;
    public static ChromeOptions options;

    public BrowserDriver() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/resources/chromeDriver.exe");
        BrowserDriver.driver = new ChromeDriver(options); // Utiliza BrowserDriver.driver para variables estáticas
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void close() {
        if (BrowserDriver.driver != null) {
            BrowserDriver.driver.close();
        }
    }
}