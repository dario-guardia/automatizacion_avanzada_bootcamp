package automationcraft.testcreation.jetsmart.G4.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.jetsmart.G4.pages.JetSmartHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepModuloHotelesCasoBajoG4 {

    WebDriver driver;
    JetSmartHomePage jsHomePage;


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




}
