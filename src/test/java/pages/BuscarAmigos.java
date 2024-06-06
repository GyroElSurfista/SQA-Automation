package pages;

import base.Base;
import org.openqa.selenium.WebDriver;

public class BuscarAmigos extends Base {
    public BuscarAmigos(WebDriver webDriver){
        super(webDriver);
    }

    private String profileButton = "//div[2]/ul/li/a";
    private String mainText = "//ul/li[2]/a";
    public void openBuscarAmigosPage(String url){
        driver.get(url);
    }

    public boolean checkMainText(String text){
        return findElementWaitClickable(10,"xpath", mainText).getText().equals(text);
    }
    public void clickProfileButton(){
        findElementWaitClickable(10,"xpath", profileButton).click();
    }
}
