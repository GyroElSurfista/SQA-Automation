package pages;

import base.Base;
import org.openqa.selenium.WebDriver;

public class LoginFriender extends Base
{
    public LoginFriender(WebDriver webDriver){
        super(webDriver);
    }

    private String mainMessage = "//div[2]/p";
    private String email = "username";
    private String password = "password";
    private String loginButton = "//form/button";

    public boolean checkMainMessage(String msg){
        return findElement("xpath", mainMessage).getText().equals(msg);
    }

    public void setEmailText(String text){
        findElement("id", email).sendKeys(text);
    }

    public void setPasswordText(String text){
        findElement("id", password).sendKeys(text);
    }

    public void clickLoginButton(){
        findElement("xpath", loginButton).click();
    }

}
