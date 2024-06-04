package pages;

import base.Base;
import org.openqa.selenium.WebDriver;

public class Perfil extends Base {
    public Perfil(WebDriver webDriver){
        super(webDriver);
    }

    private String strayButton = "//div[2]/ul/li[2]";

    public void clickStrayButton(){
        findElement("xpath", strayButton);
    }
}
