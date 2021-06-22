package practicasFalabella.testcases;

import org.testng.annotations.Test;
import practicasFalabella.pageobject.pages.casoOrganigramaPage;
import practicasFalabella.pageobject.pages.jiraLoginPage;
import practicasFalabella.pageobject.pages.successfactorsPage;

public class casoOrganigrama extends TestBase {
    protected jiraLoginPage jHomePage;
    protected casoOrganigramaPage casoOrganigrama;
    protected successfactorsPage SF;

    @Test
    public void EC470() throws InterruptedException{
        jHomePage = new jiraLoginPage(driver);
        casoOrganigrama = new casoOrganigramaPage(driver);
        SF = new successfactorsPage(driver);
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

        casoOrganigrama.clickCaso();
        SF.verificarTitulo("Iniciar sesión");
        SF.ingresarUsuario("44");
        SF.ingresarPassword("Noviembre2020");
        SF.clickIngresar();
        SF.verificarTitulo("inicio");
        SF.clickInicio();
        casoOrganigrama.clickOpcOrganigrama();
        SF.verificarTitulo("Organigrama");

        jHomePage.esperar();




    }




}
