package bctsoft.grupo4.testcases;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPagoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_012_Traslado_ValidarHastaPago extends TestBase{

    protected JetSmartHomePage jsHomePage;
    protected JetSmartReservaTrasladoPage jsReservaPago;
    protected JetSmartReservaTrasladoPagoPage jsValidarPago;
    protected JetSmartReservaTrasladoInformacionPage jsInformacionPago;

    @Test
    public void TC_012_test() throws InterruptedException {
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
        jsHomePage.seleccionarFechaIda("11 Mayo 2021");
        jsHomePage.seleccionarHoraDeIda("3:00 PM");
        jsHomePage.seleccionarNumerPasajero("1 pasajero");
        jsHomePage.botonBuscarTraslado();
        jsHomePage.SwitchVentana();
        jsReservaPago.esperaClickeablebotonTraslado();
        jsInformacionPago.rellenarNombreApellidoTraslado("Marcelo Letelier");
        jsInformacionPago.correoTraslado("mletelierpalomares@gmail.com");
        jsInformacionPago.ValidarcorreoTraslado("mletelierpalomares@gmail.com");
        jsInformacionPago.NumeroPersonalTraslado("964567406");
        jsInformacionPago.CodigoVueloTraslado("AB147");
        jsInformacionPago.ClickContinuarBotonTraslado();
        Assert.assertEquals("se cargaron los datos con exito",jsInformacionPago.resumenPago());


    }
}