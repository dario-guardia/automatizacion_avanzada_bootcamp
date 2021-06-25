package practicasFalabella.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import practicasFalabella.pageobject.pages.jiraLoginPage;
import utils.impresion.utilizaFile;

import java.awt.*;
import java.io.IOException;

public class LoginJira extends TestBase {
    protected jiraLoginPage jHomePage;
    @Test
    public void LogIn() throws AWTException, InvalidFormatException, IOException {
        utilizaFile imprimeEvidencia = new utilizaFile();
        jHomePage = new jiraLoginPage(driver);
        imprimeEvidencia.InicializaFile();
        jHomePage.goToUrl("https://jira.falabella.com/login.jsp");
        jHomePage.ingresarUsuario("ext_aagalimbertif");
        jHomePage.ingresarPassword("Tsoft-21");
        jHomePage.clickLogIn();
        imprimeEvidencia.GeneraEvidencia("LoginJira.docx");

    }


}
