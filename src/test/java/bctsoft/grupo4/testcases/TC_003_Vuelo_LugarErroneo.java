package bctsoft.grupo4.testcases;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC_003_Vuelo_LugarErroneo extends bctsoft.grupo4.testcases.TestBase {

    protected JetSmartHomePage jsHomePage;
    protected JetSmartReservaVuelosPage jsReservaVuelosPage;
    protected JetSmartReservaVuelosInformacionPage jsReservaReservasVuelosInformacionPage;

    @Test
    public void TC_003Test() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jsReservaVuelosPage = new JetSmartReservaVuelosPage(driver);
        jsReservaReservasVuelosInformacionPage = new JetSmartReservaVuelosInformacionPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        Assert.assertEquals("No hay resultados.",jsHomePage.validarIngresarMalOrigenVuelos("Inglaterra"));

    }
}