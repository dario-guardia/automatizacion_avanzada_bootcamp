package practicasFalabella.testcases;
import org.testng.annotations.Test;

import practicasFalabella.pageobject.pages.casoDependenciaInformePage;
import practicasFalabella.pageobject.pages.jiraLoginPage;
import practicasFalabella.pageobject.pages.successfactorsPage;

public class casoDependenciaInforme extends TestBase {
    protected jiraLoginPage jHomePage;
    protected casoDependenciaInformePage casoDependencia;
    protected successfactorsPage SF;
    @Test
    public void casoDependencia() throws InterruptedException{
        jHomePage = new jiraLoginPage(driver);
        casoDependencia = new casoDependenciaInformePage(driver);
        SF = new successfactorsPage(driver);
        jHomePage.goToUrl("https://jira.falabella.com/login.jsp");
        jHomePage.ingresarUsuario("ext_aagalimbertif");
        jHomePage.ingresarPassword("Tsoft-21");
        jHomePage.clickLogIn();
        jHomePage.clickPruebas();
        jHomePage.clickEjecutarPruebas();
        jHomePage.clickBacklog4();
        jHomePage.click3558();

        casoDependencia.click4671();
        casoDependencia.goToUrl("https://performancemanager4.successfactors.com/login?company=adessafalaD1&username=fjmunozr@Falabella.cl#/login");
        SF.verificarTitulo("Iniciar sesión");
        SF.ingresarUsuario("44");
        SF.ingresarPassword("Noviembre2020");
        SF.clickIngresar();
        SF.verificarTitulo("inicio");
        SF.clickInicio();
        casoDependencia.seleccionarInformes();
        casoDependencia.opcTodosInformes();
        casoDependencia.buscarInforme("Dependencia de colaboradores");
        casoDependencia.clickDependenciaV2();
        casoDependencia.filtrarEmpresa();
        casoDependencia.insertarCodigoEmpresa("C029");

        jHomePage.esperar();




    }

}
