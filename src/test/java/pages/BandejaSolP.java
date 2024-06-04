package pages;

import base.Base;
import org.openqa.selenium.WebDriver;

public class BandejaSolP extends Base {

    public BandejaSolP(WebDriver webDriver){
        super(webDriver);
    }

    private String message = "//div[2]/p";

    public void openHomePage(String url){
        driver.get(url);
    }

    public boolean checkMessageForEmpty(String msg){
        return findElement("xpath", message).getText().equals(msg);
    }
}
