package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    protected WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public Boolean launchWebPage(String url, String title){
        try{
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(url);

            return (driver.getTitle().equals(title));
        }
        catch (Exception e){
            System.out.println("the page does not found " + title);
            return false;
        }
    }
    public By getLocatorType(String locatorType, String locator){
        switch (locatorType){
            case "id":
                return By.id(locator);
            case "name":
                return By.name(locator);
            case "class":
                return By.className(locator);
            case "xpath":
                return By.xpath(locator);
            case "css":
                return By.cssSelector(locator);
            case "tag":
                return By.tagName(locator);
            case "link":
                return By.linkText(locator);
            case "plink":
                return By.partialLinkText(locator);
            default:
                System.out.println("The locator type is not valid " + locatorType);
                return null;
        }

    }

    public WebElement findElement(String locatorType, String locator){
        return driver.findElement(getLocatorType(locatorType, locator));
    }

    public WebElement findElementWaitClickable(long seconds, String locatorType, String locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(getLocatorType(locatorType, locator)));
    }

    public WebElement findElementWaitVisibility(long seconds, String locatorType, String locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorType(locatorType, locator)));
    }

    public void close(){
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
