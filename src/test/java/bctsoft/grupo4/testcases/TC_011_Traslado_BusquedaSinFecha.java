package bctsoft.grupo4.testcases;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPagoPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TC_011_Traslado_BusquedaSinFecha extends bctsoft.grupo4.testcases.TestBase {

    protected JetSmartHomePage jsHomePage;
    protected JetSmartReservaTrasladoPage jsReservaPago;
    protected JetSmartReservaTrasladoPagoPage jsValidarPago;
    protected JetSmartReservaTrasladoInformacionPage jsInformacionPago;

    @Test
    public void TC_011_test() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jsReservaPago = new JetSmartReservaTrasladoPage(driver);
        jsValidarPago = new JetSmartReservaTrasladoPagoPage(driver);
        jsInformacionPago = new JetSmartReservaTrasladoInformacionPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.ClickTraslado();
        jsHomePage.cambiarDeFrame();
        jsHomePage.clickCasillaIda();
        jsHomePage.IngresarOrigen("999999999999999");
        //jsHomePage.lugarDestinoErroneo();
        Assert.assertEquals("lugar de origen erroneo",jsHomePage.lugarDestinoErroneo());
    }
}
