package bctsoft.grupo4.testcases;

import bctsoft.grupo4.pageobject.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;


public class TC_006_Hotel_ReservaHastaDatos extends bctsoft.grupo4.testcases.TestBase {
    protected JetSmartHomePage jsHomePage;
    protected JetSmartHotelReservaPage jsHotelReservaPage;
    protected JetSmartReservaHotelPage jsReservaHotelPage;
@Test
    public void TC006() throws InterruptedException{

        jsHomePage = new JetSmartHomePage(driver);
        jsHotelReservaPage = new JetSmartHotelReservaPage(driver);
        jsReservaHotelPage = new JetSmartReservaHotelPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.seleccionarPestañaHotel();
        jsHomePage.setHospedaje("santiago");
        jsHomePage.clickFechaIda();
        jsHomePage.setFechaIdaHotel("2021-5-8");
        jsHomePage.clickFechaVuelta();
        jsHomePage.setFechavueltaHotel("2021-mayo-10");
        jsHomePage.setHabitacionesHotel("1 habitación");
        jsHomePage.setAdultos("2 adultos");
        jsHomePage.buscarHotel();
        jsHomePage.switchVentana(1);
        jsHotelReservaPage.filtrar5Estrellas();
        jsHotelReservaPage.clickSheraton();
        jsHomePage.switchVentana(2);
        jsReservaHotelPage.reservarHotel();
        jsReservaHotelPage.confirmarHabitaciones("1 habitación");
        jsReservaHotelPage.confirmarReserva();
        Assert.assertEquals("Se hizo la reserva con exito", jsReservaHotelPage.verificarTitulo());

    }

}
