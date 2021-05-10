package bctsoft.grupo4.testcases;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartHotelReservaPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaHotelPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC_005_Hotel_NochesErroneo extends TestBase{
protected JetSmartHomePage jsHomePage;
protected JetSmartHotelReservaPage jsHotelReservaPage;
protected JetSmartReservaHotelPage jsReservaHotelPage;

@Test
public void TC005()throws InterruptedException{
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
    jsHomePage.setFechavueltaHotel("2021-junio-9");
    jsHomePage.setHabitacionesHotel("1 habitación");
    jsHomePage.setAdultos("1 adulto");
    Assert.assertEquals("Lo sentimos, no es posible realizar reservas para más de 30 noches", jsHomePage.buscarHotelDeshabilitado());


}

}
