package practicasFalabella.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import practicasFalabella.pageobject.base.SeleniumBase;

public class EC470Page extends SeleniumBase {

    public EC470Page(WebDriver driver) {
        super(driver);
    }

    private By btnCasoOrganigrama = By.xpath("//*[contains(text(),'GSCRHEC-470')]");
    private By btnInicio = By.id("customHeaderModulePickerBtn-inner");
    private By opcInformacionEmpresa = By.xpath("//a[contains(text(),'Información de la empresa')]");
    private By txtUsuarioFalabella = By.xpath("//*[contains(@name,'username')]");
    private By txtPasswordFalabella = By.xpath("//*[contains(@name,'password')]");
    private By btnLoginFalabella = By.id("__button2-inner");


    public void clickCaso(){
        waitDisplayed(btnCasoOrganigrama,5);
        click(btnCasoOrganigrama);
    }

    public void clickInicio(){
        click(btnInicio);
    }

    public void clickOpcOrganigrama(){
        waitDisplayed(opcInformacionEmpresa,5);
        click(opcInformacionEmpresa);
    }

    public void ingresarUsuario(String usuario){
        waitDisplayed(txtUsuarioFalabella,5);
        click(txtUsuarioFalabella);
        clearText(txtUsuarioFalabella);
        type(usuario, txtUsuarioFalabella);
    }

    public void ingresarPassword(String password){
        click(txtPasswordFalabella);
        clearText(txtPasswordFalabella);
        type(password,txtPasswordFalabella);
    }

    public void clickIngresar(){
        click(btnLoginFalabella);
    }



}
