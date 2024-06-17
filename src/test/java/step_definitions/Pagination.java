package step_definitions;

import base.ChromeDriverCreator;
import base.WebDriverCreator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import static org.junit.Assert.assertTrue;

public class Pagination {
    private final WebDriverCreator webDriverCreator = new ChromeDriverCreator();
    private Home homePage;
    private LoginFriender loginFriender;
    private BuscarAmigos buscarAmigos;
    private Perfil perfil;
    private BandejaSolP bandeja;

    @Given("The user is located at {string} home page")
    public void the_user_is_located_at_home_page(String url) {
        homePage = new Home(webDriverCreator.createWebDriver());
        homePage.openHomePage(url);
    }
    @When("The user clicks on login button at Home's navbar")
    public void the_user_clicks_on_login_button_at_home_s_navbar() {
        homePage.clickLoginButton();
    }
    @When("The login form is shown")
    public void the_login_form_is_shown() {
        loginFriender = new LoginFriender(homePage.getDriver());
        assert(loginFriender.checkMainMessage("Inicia sesión en Friender"));
    }
    @When("The user enters the email {string} at email's field")
    public void the_user_enters_the_email_at_email_s_field(String string) {
        loginFriender.setEmailText(string);
    }
    @When("The user enters the password {string} at password's field")
    public void the_user_enters_the_password_at_password_s_field(String string) {
        loginFriender.setPasswordText(string);
    }
    @When("The user clicks on login button in the form")
    public void the_user_clicks_on_login_button_in_the_form() {
        loginFriender.clickLoginButton();
    }
    @When("The user is redirected to Buscar Amigos section")
    public void the_user_is_redirected_to_buscar_amigos_section() {
        buscarAmigos = new BuscarAmigos(loginFriender.getDriver());
        assertTrue(buscarAmigos.checkMainText("Buscar Amigos"));
    }
    @When("There is just one pagination number")
    public void there_is_just_one_pagination_number(){
        assertTrue(buscarAmigos.checkSinglePageNumber());
    }
    @Then("The navigation buttons are disabled")
    public void the_navigation_buttons_are_disabled() {
        assertTrue(!buscarAmigos.leftPaginationButtonIsEnabled() && !buscarAmigos.rightPaginationButtonIsEnabled());
        buscarAmigos.close();
    }
}
