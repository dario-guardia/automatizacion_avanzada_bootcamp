package practicasFalabella.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import practicasFalabella.pageobject.base.SeleniumBase;

public class jiraLoginPage extends SeleniumBase {
    public jiraLoginPage(WebDriver driver) {
        super(driver);
    }

    private By txtUserName = By.id("login-form-username");
    private By txtPassword = By.id("login-form-password");
    private By btnLogIn = By.id("login-form-submit");
    private By opcPruebas = By.id("zephyr_je.topnav.tests");
    private By opcEjecutarPruebas = By.xpath("//*[contains(text(),'Ejecutar pruebas')]");
    private By btnSprint1 = By.xpath("//*[@id='version-25425']/i");
    private By btnSprintCiclo1 = By.xpath("//*[@id=\"version-25425-cycle-27388\"]/i");
    private By btnCiclo1 = By.xpath("//*[contains(text(),'CICLO 01 - FIF')]");
    private By btnOrdenarPorId = By.xpath("//*[contains(@data-sortkey,'issueKey')]");


    public void ingresarUsuario(String usuario){
        click(txtUserName);
        type(usuario, txtUserName);
    }

    public void ingresarPassword(String password){
        click(txtPassword);
        type(password, txtPassword);
    }

    public void clickLogIn(){
        click(btnLogIn);
    }

    public void clickPruebas(){
        click(opcPruebas);
    }

    public void clickEjecutarPruebas(){
        click(opcEjecutarPruebas);
    }



    public void clickSprint1(){
        waitDisplayed(btnSprint1,5);
        click(btnSprint1);
        System.out.println("Se hizo click");
    }

    public void clickSprint1Ciclo1(){
        waitDisplayed(btnSprintCiclo1,5);
        click(btnSprintCiclo1);
    }

    public void clickCiclo1(){
        waitDisplayed(btnCiclo1,5);
        click(btnCiclo1);
    }

    public void clickOrdenarPorId(){
        waitDisplayed(btnOrdenarPorId,5);
        click(btnOrdenarPorId);
    }


    public void esperar() throws InterruptedException {
        Thread.sleep(3000);
    }

}
