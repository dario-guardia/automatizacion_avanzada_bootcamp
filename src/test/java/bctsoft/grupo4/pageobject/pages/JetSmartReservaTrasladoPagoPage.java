package bctsoft.grupo4.pageobject.pages;

import jetsmart_exercises_grupo4.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartReservaTrasladoPagoPage extends SeleniumBase {
    public JetSmartReservaTrasladoPagoPage(WebDriver driver) {
        super(driver);
    }
        private By txtConfirmacionPago = By.xpath("//h3[@class='gt-header gtg-strong']");
        //Keyword Driver
        public void ValidarIngresoDatosCorrectoTraslado() {
            String resultado = "";
            getText(txtConfirmacionPago);
            if (txtConfirmacionPago.equals("Resumen del pago")) {
                resultado = "se cargaron los datos con exito";
            }
        }
    }

