package step_definitions;

import base.ChromeDriverCreator;
import base.WebDriverCreator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class BandejaSol {

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
        assert (buscarAmigos.checkMainText("Buscar Amigos"));
    }
    @When("The user clicks on the profile button at navbar")
    public void the_user_clicks_on_the_profile_button_at_navbar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The user is redirected to his profile")
    public void the_user_is_redirected_to_his_profile() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The user clicks on Solicitudes Pendientes Button")
    public void the_user_clicks_on_solicitudes_pendientes_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user is redirected to his requests tray and the message {string} is shown")
    public void the_user_is_redirected_to_his_requests_tray_and_the_message_is_shown(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
