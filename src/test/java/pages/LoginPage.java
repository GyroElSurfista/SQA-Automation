package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

public class LoginPage extends Base {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //localizadores para elementos del login
    private String username = "username";
    private String password = "password";
    private String logiButton = "//*[@id=\"login\"]/button/i";
    private String message = "//h4";


    public void openLoginPage(String url){
        driver.get(url);
    }

    public void setUsernameText(String text){
        findElement("id", username).sendKeys(text);
    }

    public void setPasswordText(String text){
        findElement("id", password).sendKeys((text));
    }

    public void clickLoginButton(){
        findElement("xpath", logiButton).click();
    }

    public boolean verifyMessage(String msg){
        return findElement("xpath", message).getText().equals(msg);
    }
}
