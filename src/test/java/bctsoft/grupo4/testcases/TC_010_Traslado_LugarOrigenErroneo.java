package bctsoft.grupo4.testcases;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPagoPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC_010_Traslado_LugarOrigenErroneo extends TestBase{

    protected JetSmartHomePage jsHomePage;
    protected JetSmartReservaTrasladoPage jsReservaPago;
    protected JetSmartReservaTrasladoPagoPage jsValidarPago;
    protected JetSmartReservaTrasladoInformacionPage jsInformacionPago;

    @Test
    public void TC_010_test() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jsReservaPago = new JetSmartReservaTrasladoPage(driver);
        jsValidarPago = new JetSmartReservaTrasladoPagoPage(driver);
        jsInformacionPago = new JetSmartReservaTrasladoInformacionPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.ClickTraslado();
        jsHomePage.cambiarDeFrame();
        jsHomePage.clickCasillaIda();
        jsHomePage.IngresarOrigen("aeropuerto arturo merino benitez");
        jsHomePage.IngresarDestino("llano subercaseaux 2909");
        jsHomePage.SaltarFechaTraslado();
        jsHomePage.seleccionarHoraDeIda("3:00 AM");
        jsHomePage.seleccionarNumerPasajero("1 pasajero");
        jsHomePage.botonBuscarTraslado();
        Assert.assertEquals("faltan datos por rellenar", jsHomePage.cambiarVentana());
    }
}