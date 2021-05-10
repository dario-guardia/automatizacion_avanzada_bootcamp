package bctsoft.grupo4.testcases;


import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosPage;
import org.junit.Assert;
import org.testng.annotations.Test;


public class TC_001_Vuelo_PaqueteIdayVuelta extends TestBase {

    protected JetSmartHomePage jsHomePage;
    protected JetSmartReservaVuelosPage jsReservaVuelosPage;
    protected JetSmartReservaVuelosInformacionPage jsReservaReservasVuelosInformacionPage;
    @Test
    public void TC_001Test ()throws InterruptedException{
        jsHomePage = new JetSmartHomePage(driver);
        jsReservaVuelosPage = new JetSmartReservaVuelosPage(driver);
        jsReservaReservasVuelosInformacionPage = new JetSmartReservaVuelosInformacionPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.ingresarLugarOrigenVuelos("SCL");
        jsHomePage.ingresarLugarDestinoVuelos("IQQ");
        jsHomePage.ingresarFechaIdaVuelos("Mayo 9, 2021");
        jsHomePage.ingresarFechaVueltaVuelos("Junio 1, 2021");
        jsHomePage.ingresarPasajerosVuelos("1");
        jsHomePage.apretarBoton();
        jsReservaVuelosPage.seleccionarHoraIda();
        jsReservaVuelosPage.seleccionarPaqueteIdaLigero();
        jsReservaVuelosPage.seleccionarHoraVuelta();
        jsReservaVuelosPage.seleccionarPaqueteVueltaLigero();
        jsReservaVuelosPage.seleccionarBotonFinal();
        Assert.assertTrue(jsReservaReservasVuelosInformacionPage.validarInformacionDeVuelos());


}
}