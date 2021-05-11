package automationcraft.testcreation.jetsmart.G4.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.jetsmart.G4.pages.JetSmartHomePage;
import automationcraft.testcreation.jetsmart.G4.pages.JetSmartHotelReservaPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepModuloHotelesCasoMedioG4 {

    JetSmartHomePage jsHomePage;
    JetSmartHotelReservaPage jsHotelReservaPage = new JetSmartHotelReservaPage(DriverFactory.getDriver());

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

}
