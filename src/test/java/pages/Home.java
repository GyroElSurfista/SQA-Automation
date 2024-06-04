package pages;


import base.Base;
import org.openqa.selenium.WebDriver;

public class Home extends Base {

    public Home(WebDriver webDriver){
        super(webDriver);
    }

    private String loginButton = "//a[text()='Iniciar Sesión']";

    public void openHomePage(String url){
        driver.get(url);
    }

    public void clickLoginButton(){
        findElement("xpath", loginButton);
    }

}
