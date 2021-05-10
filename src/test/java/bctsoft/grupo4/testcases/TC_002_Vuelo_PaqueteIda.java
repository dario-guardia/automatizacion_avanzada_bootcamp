package bctsoft.grupo4.testcases;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC_002_Vuelo_PaqueteIda extends TestBase{

    protected JetSmartHomePage jsHomePage;
    protected JetSmartReservaVuelosPage jsReservaVuelosPage;
    protected JetSmartReservaVuelosInformacionPage jsReservaReservasVuelosInformacionPage;

    @Test

    public void TC_002Test()throws InterruptedException{

        jsHomePage = new JetSmartHomePage(driver);
        jsReservaVuelosPage = new JetSmartReservaVuelosPage(driver);
        jsReservaReservasVuelosInformacionPage = new JetSmartReservaVuelosInformacionPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.seleccionarCheckIda();
        jsHomePage.ingresarLugarOrigenVuelos("SCL");
        jsHomePage.ingresarLugarDestinoVuelos("IQQ");
        jsHomePage.ingresarFechaIdaVuelos("Junio 9, 2021");
        jsHomePage.ingresarPasajerosVuelos("1");
        jsHomePage.apretarBoton();
        jsReservaVuelosPage.seleccionarHorarioDisponible();
        Assert.assertTrue(jsReservaVuelosPage.validarCasoIntermedio());
    }
}
