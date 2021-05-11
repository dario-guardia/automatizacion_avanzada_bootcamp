package automationcraft.testcreation.jetsmart.G4.steps;

import automationcraft.engine.selenium.DriverFactory;
import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepModuloVuelo_CasoMedioG4 {
    JetSmartHomePage jsHomePage;
    JetSmartReservaVuelosPage jsReservaVuelosPage;
    JetSmartReservaVuelosInformacionPage jsReservaReservasVuelosInformacionPage;

    @Given("Que soy un usuario e ingreso a la pagina JetSmartVuelos")
    public void que_soy_un_usuario_e_ingreso_a_la_pagina_jet_smart_vuelos()throws InterruptedException {
        jsHomePage = new JetSmartHomePage(DriverFactory.getDriver());
        jsReservaVuelosPage = new JetSmartReservaVuelosPage(DriverFactory.getDriver());
        jsReservaReservasVuelosInformacionPage = new JetSmartReservaVuelosInformacionPage(DriverFactory.getDriver());
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
    }

    @When("selecciono el check {string}")
    public void selecciono_el_check(String string) {
        jsHomePage.seleccionarCheckIda();
    }

    @When("selecciono en el campo de origen   {string}")
    public void selecciono_en_el_campo_de_origen(String string)throws InterruptedException {
        jsHomePage.ingresarLugarOrigenVuelos("SCL");
    }

    @When("selecciono en el campo de destino {string}")
    public void selecciono_en_el_campo_de_destino(String string) throws InterruptedException{
        jsHomePage.ingresarLugarDestinoVuelos("IQQ");
    }

    @When("selecciono como fecha de ida  {string}")
    public void selecciono_como_fecha_de_ida(String string)throws InterruptedException {
        jsHomePage.ingresarFechaIdaVuelos("Junio 9, 2021");
    }

    @When("selecciono en el campo de pasajeros {string}")
    public void selecciono_en_el_campo_de_pasajeros(String string) throws InterruptedException {
        jsHomePage.ingresarPasajerosVuelos("1");
    }

    @When("presiono el boton Smart para continuar")
    public void presiono_el_boton_smart_para_continuar() throws InterruptedException {
        jsHomePage.apretarBoton();
    }

    @When("selecciono la hora de ida disponible para salir")
    public void selecciono_la_hora_de_ida_disponible_para_salir()throws InterruptedException {
        jsReservaVuelosPage.seleccionarHorarioDisponible();
    }


    @Then("se encuentran paquetes disponibles de ida")
    public void se_encuentran_paquetes_disponibles_de_ida()throws InterruptedException {
        Assert.assertTrue(jsReservaVuelosPage.validarCasoIntermedio());
    }

}

