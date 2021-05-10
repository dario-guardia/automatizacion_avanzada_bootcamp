package bctsoft.grupo4.pageobject.pages;

import jetsmart_exercises_grupo4.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartReservaTrasladoInformacionPage extends SeleniumBase {
    public JetSmartReservaTrasladoInformacionPage(WebDriver driver) {
        super(driver);
    }
    private By txtNombrePersonaTraslado = By.cssSelector("#gt-customer-name");
    private By txtEmailPersonaTraslado = By.cssSelector("#gt-customer-email");
    private By txtConfEmailPersonaTraslado = By.cssSelector("#gt-customer-confirm-email");
    private By txtNumPersonalTraslado = By.cssSelector("#gt-customer-mobile-number");
    private By txtNumVueloTraslado = By.cssSelector("#gt-pickup-flight-number");
    private By btnIrCajaTraslado = By.xpath("//button [@class='ctc-button ctc-button--full ctc-button--primary']");
    private By txtDetallesPago = By.xpath("//h3[@class='gt-header gtg-strong']");
    //Keyword Driver

    public void rellenarNombreApellidoTraslado(String NombreApellido) {
        type(NombreApellido, txtNombrePersonaTraslado);
    }

    public void correoTraslado(String Correo) {

        type(Correo, txtEmailPersonaTraslado);
    }

    public void ValidarcorreoTraslado(String ValCorreo) {

        type(ValCorreo, txtConfEmailPersonaTraslado);
    }

    public void NumeroPersonalTraslado(String Numero) {

        type(Numero, txtNumPersonalTraslado);
    }

    public void CodigoVueloTraslado(String CodigoVuelo) {

        type(CodigoVuelo, txtNumVueloTraslado);
    }

    public void ClickContinuarBotonTraslado(){

        click(btnIrCajaTraslado);
    }

    public String resumenPago(){
        String resultado = "";
        String confirmar = getText(txtDetallesPago);

        if (confirmar.equals("Resumen del pago")){
            resultado = "se cargaron los datos con exito";
        }

        return resultado;

    }

}

