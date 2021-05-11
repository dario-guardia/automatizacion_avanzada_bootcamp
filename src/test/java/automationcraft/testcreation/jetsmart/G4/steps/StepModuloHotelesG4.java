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

public class StepModuloHotelesG4 {
    JetSmartHomePage jsHomePage;
    JetSmartHotelReservaPage jsHotelReservaPage = new JetSmartHotelReservaPage(DriverFactory.getDriver());
    JetSmartReservaHotelPage jsReservaHotelPage = new JetSmartReservaHotelPage(DriverFactory.getDriver());



    @Given("un usuario que ingresa a la pagina {string}")
    public void un_usuario_que_ingresa_a_la_pagina(String string) throws InterruptedException {
        jsHomePage = new JetSmartHomePage(DriverFactory.getDriver());
        jsHomePage.goToUrl("https://jetsmart.com/cl/es");
        jsHomePage.cerrarModuloSuscribete();
    }


    @When("ingresa al formulario de hoteles")
    public void ingresa_al_formulario_de_hoteles() {
        jsHomePage.seleccionarPestañaHotel();
    }

    @When("selecciona lugar de hospedaje {string}")
    public void selecciona_lugar_de_hospedaje(String string) {
        jsHomePage.setHospedaje("santiago");
    }

    @When("selecciona fecha de llegada {string}")
    public void selecciona_fecha_de_llegada(String string) {
        jsHomePage.clickFechaIda();
        jsHomePage.setFechaIdaHotel("2021-5-11");
    }

    @When("selecciona fecha de vuelta {int} dias a la fecha")
    public void selecciona_fecha_de_vuelta_dias_a_la_fecha(Integer int1) throws InterruptedException {
        jsHomePage.clickFechaVuelta();
        jsHomePage.setFechavueltaHotel("2021-junio-12");
    }

    @When("selecciona numero de habitaciones {string}")
    public void selecciona_numero_de_habitaciones(String string) throws InterruptedException {
        jsHomePage.setHabitacionesHotel("1 habitación");
    }

    @When("selecciona numero personas adultas {string}")
    public void selecciona_numero_personas_adultas(String string) {
        jsHomePage.setAdultos("1 adulto");
    }

    @Then("pagina muestra una leyenda con error de reserva")
    public void pagina_muestra_una_leyenda_con_error_de_reserva() {
        Assert.assertEquals("Lo sentimos, no es posible realizar reservas para más de 30 noches", jsHomePage.buscarHotelDeshabilitado());
    }
    ////////////////////////MEDIO///////////////////////
    @Given("una persona que ingresa a la pagina {string}")
    public void una_persona_que_ingresa_a_la_pagina(String string) throws InterruptedException {
        jsHomePage = new JetSmartHomePage(DriverFactory.getDriver());
        jsHomePage.goToUrl("https://jetsmart.com/cl/es");
        jsHomePage.cerrarModuloSuscribete();
    }
    @When("ingresa a la pestaña de hoteles")
    public void ingresa_a_la_pestaña_de_hoteles() {
        jsHomePage.seleccionarPestañaHotel();
    }

    @When("seleccionar lugar de hospedaje {string}")
    public void seleccionar_lugar_de_hospedaje(String string) {
        jsHomePage.setHospedaje(string);
    }

    @When("seleccionar fecha de llegada {string}")
    public void seleccionar_fecha_de_llegada(String string) {
        jsHomePage.clickFechaIda();
        jsHomePage.setFechaIdaHotel(string);
    }



    @When("seleccionar fecha de vuelta {string}")
    public void seleccionar_fecha_de_vuelta(String string) throws InterruptedException {
        jsHomePage.clickFechaVuelta();
        jsHomePage.setFechavueltaHotel(string);
    }

    @When("selecciona {string}")
    public void selecciona(String string) throws InterruptedException {
        jsHomePage.setHabitacionesHotel(string);
    }

    @When("presiono boton buscar")
    public void presiono_boton_buscar() {
        jsHomePage.buscarHotel();
    }

    @When("script cambia de pagina")
    public void script_cambia_de_pagina() {
        jsHomePage.switchVentana(1);
    }

    @Then("script muestra mensaje en consola")
    public void script_muestra_mensaje_en_consola() {
        Assert.assertEquals("No hay 30 habitaciones disponibles",jsHotelReservaPage.verificarHabitaciones("30 habitaciones"));

    }
    ///////////////ALTO///////////////////////
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
