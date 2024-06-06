package pages;


import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home extends Base {

    public Home(WebDriver webDriver){
        super(webDriver);
    }

    private String loginButton = "//a[text()='Iniciar Sesión']";

    public void openHomePage(String url){
        driver.get(url);
    }

    public void clickLoginButton(){
        findElementWaitClickable(10, "xpath", loginButton).click();
    }

}
