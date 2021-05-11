package automationcraft.testcreation.jetsmart.G4.steps;
import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.jetsmart.G4.pages.JetSmartHomePage;
import automationcraft.testcreation.jetsmart.G4.pages.JetSmartHotelReservaPage;
import automationcraft.testcreation.jetsmart.G4.pages.JetSmartReservaHotelPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class StepModuloHotelesCasoAltoG4 {
    JetSmartHomePage jsHomePage;
    JetSmartHotelReservaPage jsHotelReservaPage = new JetSmartHotelReservaPage(DriverFactory.getDriver());
    JetSmartReservaHotelPage jsReservaHotelPage = new JetSmartReservaHotelPage(DriverFactory.getDriver());

    @Given("un cliente que ingresa a la pagina {string}")
    public void un_cliente_que_ingresa_a_la_pagina(String string) throws InterruptedException {
        jsHomePage = new JetSmartHomePage(DriverFactory.getDriver());
        jsHomePage.goToUrl("https://jetsmart.com/cl/es");
        jsHomePage.cerrarModuloSuscribete();
    }

    @When("ingreso a la pestaña de hoteles")
    public void ingreso_a_la_pestaña_de_hoteles() {
        jsHomePage.seleccionarPestañaHotel();
    }

    @When("selecciono lugar de hospedaje {string}")
    public void selecciono_lugar_de_hospedaje(String string) {
        jsHomePage.setHospedaje(string);
    }

    @When("selecciono fecha de llegada {string}")
    public void selecciono_fecha_de_llegada(String string) {
        jsHomePage.clickFechaIda();
        jsHomePage.setFechaIdaHotel(string);
    }

    @When("selecciono fecha de vuelta {string}")
    public void selecciono_fecha_de_vuelta(String string) throws InterruptedException {
        jsHomePage.clickFechaVuelta();
        jsHomePage.setFechavueltaHotel(string);
    }

    @When("selecciono {string}")
    public void selecciono(String string) throws InterruptedException {
        jsHomePage.setHabitacionesHotel(string);
    }

    @When("selecciono personas {string}")
    public void selecciono_personas(String string) throws InterruptedException {
        jsHomePage.setAdultos(string);
    }

    @When("presionar boton buscar")
    public void presionar_boton_buscar() {
        jsHomePage.buscarHotel();
    }

    @When("script cambio de pagina")
    public void script_cambio_de_pagina() throws InterruptedException {
        jsHomePage.SwitchVentana();
    }

    @When("clickeo filtro {int} estrellas")
    public void clickeo_filtro_estrellas(Integer int1) throws InterruptedException {
       jsHotelReservaPage.filtrar5Estrellas();
    }

    @When("selecciono hotel sheraton")
    public void selecciono_hotel_sheraton() throws InterruptedException {
      jsHotelReservaPage.clickSheraton();
    }

    @When("cambia de pagina nuevamente")
    public void cambia_de_pagina_nuevamente() {
        jsHomePage.switchVentana(2);
    }


    @When("clickeo boton reservar hotel")
    public void clickeo_boton_reservar_hotel() {
      jsReservaHotelPage.reservarHotel();
    }

    @When("confirma {string}")
    public void confirma(String string) {
        jsReservaHotelPage.confirmarHabitaciones(string);
    }

    @When("confirma reserva")
    public void confirma_reserva() {
      jsReservaHotelPage.confirmarReserva();
    }

    @Then("se llega hasta el formulario de datos")
    public void se_llega_hasta_el_formulario_de_datos() {
        Assert.assertEquals("Se hizo la reserva con exito", jsReservaHotelPage.verificarTitulo());

    }
}
