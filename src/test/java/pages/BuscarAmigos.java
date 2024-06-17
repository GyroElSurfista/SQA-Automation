package pages;

import base.Base;
import org.openqa.selenium.WebDriver;

public class BuscarAmigos extends Base {
    public BuscarAmigos(WebDriver webDriver){
        super(webDriver);
    }

    private String profileButton = "//div[2]/ul/li/a";
    private String mainText = "//ul/li[2]/a";
    private String pageNumbers = ".page-link.bg-azul-fuerte";
    private String leftPaginationButton = "//*[@id=\"lista_amigos\"]/div[3]/nav/ul/li[1]/button";
    private String rightPaginationButton = "//*[@id=\"lista_amigos\"]/div[3]/nav/ul/li[3]/button";

    public void openBuscarAmigosPage(String url){
        driver.get(url);
    }

    public boolean checkMainText(String text){
        return findElementWaitClickable(10,"xpath", mainText).getText().equals(text);
    }
    public void clickProfileButton(){
        findElementWaitClickable(10,"xpath", profileButton).click();
    }

    public boolean checkSinglePageNumber(){
        return findElementsWaitVisibility(10,"css",pageNumbers).size()==1;
    }

    private boolean paginationButtonIsEnabled(String locatorType, String locator){
        return findElementWaitVisibility(10, locatorType, locator).isEnabled();
    }

    public boolean leftPaginationButtonIsEnabled(){
        return paginationButtonIsEnabled("xpath",leftPaginationButton);
    }

    public boolean rightPaginationButtonIsEnabled(){
        return paginationButtonIsEnabled("xpath",rightPaginationButton);
    }
}
