package practicasFalabella.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import practicasFalabella.pageobject.base.SeleniumBase;

public class successfactorsPage extends SeleniumBase {

    public successfactorsPage(WebDriver driver) {
        super(driver);
    }

    private By txtUsuarioFalabella = By.xpath("//*[contains(@name,'username')]");
    private By txtPasswordFalabella = By.xpath("//*[contains(@name,'password')]");
    private By btnLoginFalabella = By.id("__button2-inner");
    private By btnInicio = By.id("customHeaderModulePickerBtn-inner");


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

    public void verificarTitulo(String verificar){
        String titulo = getTitle().toString();
        if(titulo.contains(verificar)){
            System.out.println(titulo);
        }else{
            System.out.println("Login fallido");
        }
    }

    public void clickInicio(){
        click(btnInicio);
    }

}
