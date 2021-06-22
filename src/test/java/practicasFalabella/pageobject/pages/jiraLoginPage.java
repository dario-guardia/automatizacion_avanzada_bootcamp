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
    private By btnBacklog4 = By.xpath("//*[@id=\"version-27222\"]/i");
    private By btn3558 = By.xpath("//*[contains(text(),'GSCRHEC-3558')]");



    public void ingresarUsuario(String usuario){
        waitDisplayed(txtUserName,5);
        click(txtUserName);
        type(usuario, txtUserName);
    }

    public void ingresarPassword(String password)  {
        waitDisplayed(txtPassword,5);
        click(txtPassword);
        type(password, txtPassword);
    }

    public void clickLogIn(){
        wait(5, btnLogIn);
        click(btnLogIn);
    }

    public void clickPruebas(){
        if((getTitle().toString().equals("Cuadro de mando - Bugs - Jira Falabella"))) {
            click(opcPruebas);
            System.out.println("Login Exitoso");
        }else{
            System.out.println("Login Fallido");
        }

    }

    public void clickEjecutarPruebas(){
            click(opcEjecutarPruebas);
        if((getTitle().toString().equals("Employee Central - Jira Falabella"))) {
            System.out.println(getTitle().toString());
        }else{
            System.out.println("Error al abrir ciclo de pruebas");
        }
    }

    public void clickSprint1(){
        waitDisplayed(btnSprint1,5);
        click(btnSprint1);
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

    public void clickBacklog4(){
        waitDisplayed(btnBacklog4, 5);
        click(btnBacklog4);
    }

    public void click3558(){
        waitDisplayed(btn3558, 5);
        click(btn3558);
    }



    public void esperar() throws InterruptedException {
        Thread.sleep(3000);
    }

}
