package bctsoft.grupo4.testcases;


import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartHotelReservaPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaHotelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004_Hotel_HabitacionErronea extends TestBase {
    protected JetSmartHomePage jsHomePage;
    protected JetSmartHotelReservaPage jsHotelReservaPage;
    protected JetSmartReservaHotelPage jsReservaHotelPage;

    @Test
    public void TC004() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jsHotelReservaPage = new JetSmartHotelReservaPage(driver);
        jsReservaHotelPage = new JetSmartReservaHotelPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.seleccionarPestañaHotel();
        jsHomePage.setHospedaje("santiago");
        jsHomePage.clickFechaIda();
        jsHomePage.setFechaIdaHotel("2021-5-11");
        jsHomePage.clickFechaVuelta();
        jsHomePage.setFechavueltaHotel("2021-mayo-12");
        jsHomePage.setHabitacionesHotel("30 habitaciones");
        jsHomePage.setAdultos("2 adultos");
        jsHomePage.buscarHotel();
        jsHomePage.switchVentana(1);
        Assert.assertEquals("No hay 30 habitaciones disponibles",jsHotelReservaPage.verificarHabitaciones("30 habitaciones"));

    }

}
