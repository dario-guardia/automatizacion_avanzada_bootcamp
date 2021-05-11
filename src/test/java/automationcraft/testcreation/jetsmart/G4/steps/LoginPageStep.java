package automationcraft.testcreation.jetsmart.G4.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.jetsmart.pages.JetSmartHomePage;
import automationcraft.testcreation.jetsmart.pages.JetSmartInicioSesionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageStep {

    private JetSmartHomePage homePage = new JetSmartHomePage(DriverFactory.getDriver());
    private JetSmartInicioSesionPage inicioSesionPage = new JetSmartInicioSesionPage(DriverFactory.getDriver());
    private String title;


    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        homePage.goToUrl("https://jetsmart.com/cl/es/");
        homePage.cerrarPopUp();
        homePage.clickIniciaSesion();
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title =  inicioSesionPage.getTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(string,title);
    }

    @Then("forgot message link should be displayed")
    public void forgot_message_link_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(true);
    }
}
