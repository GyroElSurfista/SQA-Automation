package pages;

import base.Base;
import org.openqa.selenium.WebDriver;

public class Perfil extends Base {
    public Perfil(WebDriver webDriver){
        super(webDriver);
    }

    private String pageTitle = "//h1";
    private String strayButton = "//div[2]/ul/li[2]";

    public void clickStrayButton(){
        findElementWaitClickable(10, "xpath", strayButton).click();
    }

    public boolean checkPageTitle(String title){
        return findElementWaitVisibility(30,"xpath", pageTitle).getText().equals(title);
    }
}
