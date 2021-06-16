package practicasFalabella.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import practicasFalabella.pageobject.base.SeleniumBase;

public class EC464Page extends SeleniumBase {

        public EC464Page(WebDriver driver){
            super(driver);
        }



        private By btnCasoAcceso = By.xpath("//*[contains(text(),'GSCRHEC-464')]");
        private By linkPaginaFalabella = By.className("external-link");
        private By txtUsuarioFalabella = By.xpath("//*[contains(@name,'username')]");
        private By txtPasswordFalabella = By.xpath("//*[contains(@name,'password')]");
        private By btnLoginFalabella = By.id("__button2-inner");


        public void clickCasoLoginFalabella(){
                waitDisplayed(btnCasoAcceso,5);
                click(btnCasoAcceso);
        }

        public void clickLink(){
                waitDisplayed(linkPaginaFalabella,5);
                click(linkPaginaFalabella);
        }

        public void switchVentana(){
                switchVentana(1);
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
