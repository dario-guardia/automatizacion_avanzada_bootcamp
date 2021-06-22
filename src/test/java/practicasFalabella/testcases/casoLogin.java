package practicasFalabella.testcases;
import org.testng.annotations.Test;
import practicasFalabella.pageobject.pages.casoLoginPage;
import practicasFalabella.pageobject.pages.jiraLoginPage;

public class casoLogin extends TestBase{
    protected jiraLoginPage jHomePage;
    protected casoLoginPage casoLogin;
    @Test
    public void EC464() throws InterruptedException{
        jHomePage = new jiraLoginPage(driver);
        casoLogin = new casoLoginPage(driver);
        jHomePage.goToUrl("https://jira.falabella.com/login.jsp");
        jHomePage.ingresarUsuario("ext_aagalimbertif");
        jHomePage.ingresarPassword("Tsoft-21");
        jHomePage.clickLogIn();
        jHomePage.clickPruebas();
        jHomePage.clickEjecutarPruebas();
        jHomePage.clickSprint1();
        jHomePage.clickSprint1Ciclo1();
        jHomePage.clickCiclo1();
        jHomePage.clickOrdenarPorId();

        casoLogin.clickCasoLoginFalabella();
        casoLogin.clickLink();
        casoLogin.switchVentana();
        casoLogin.ingresarUsuario("44");
        casoLogin.ingresarPassword("Noviembre2021");
        casoLogin.clickIngresar();


        jHomePage.esperar();


    }
}
