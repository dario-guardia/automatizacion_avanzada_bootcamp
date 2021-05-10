package bctsoft.grupo4.pageobject.pages;

import jetsmart_exercises_grupo4.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartReservaVuelosInformacionPage extends SeleniumBase {
    public JetSmartReservaVuelosInformacionPage(WebDriver driver) {
        super(driver);
    }
    //Pagina Numero 3 de vuelos

    private By validarInfoDeVuelos = By.xpath("//h2[contains(text(),'Detalles del Pasajero')]");

    //Keyword Driver
    public boolean validarInformacionDeVuelos()throws InterruptedException{
        Thread.sleep(2000);
        boolean resultado = false;
        if (isDisplayed(validarInfoDeVuelos)){
            resultado = true;
        } else{
            resultado = false;
        }
    return resultado;
    }
}
