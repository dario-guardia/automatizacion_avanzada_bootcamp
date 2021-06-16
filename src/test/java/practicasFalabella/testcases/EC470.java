package practicasFalabella.testcases;

import org.testng.annotations.Test;
import practicasFalabella.pageobject.pages.EC464Page;
import practicasFalabella.pageobject.pages.EC470Page;
import practicasFalabella.pageobject.pages.jiraLoginPage;

public class EC470 extends TestBase {
    protected jiraLoginPage jHomePage;
    protected EC470Page casoOrganigrama;

    @Test
    public void EC470() throws InterruptedException{
        jHomePage = new jiraLoginPage(driver);

        casoOrganigrama = new EC470Page(driver);
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
        casoOrganigrama.goToUrl("https://performancemanager4.successfactors.com/login?company=adessafalaD1&username=fjmunozr@Falabella.cl#/login");
        casoOrganigrama.ingresarUsuario("44");
        casoOrganigrama.ingresarPassword("Noviembre2021");
        casoOrganigrama.clickIngresar();
        casoOrganigrama.clickInicio();
        casoOrganigrama.clickOpcOrganigrama();



        jHomePage.esperar();




    }




}
