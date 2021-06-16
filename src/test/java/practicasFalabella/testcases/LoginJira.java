package practicasFalabella.testcases;

import org.testng.annotations.Test;
import practicasFalabella.pageobject.pages.jiraLoginPage;

public class LoginJira extends TestBase {
    protected jiraLoginPage jHomePage;
    @Test
    public void LogIn(){
        jHomePage = new jiraLoginPage(driver);
        jHomePage.goToUrl("https://jira.falabella.com/login.jsp");
        jHomePage.ingresarUsuario("ext_aagalimbertif");
        jHomePage.ingresarPassword("Tsoft-21");
        jHomePage.clickLogIn();

    }


}
