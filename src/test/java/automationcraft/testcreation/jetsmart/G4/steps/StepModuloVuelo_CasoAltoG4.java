package automationcraft.testcreation.jetsmart.G4.steps;

import automationcraft.engine.selenium.DriverFactory;
import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepModuloVuelo_CasoAltoG4 {
    JetSmartHomePage jsHomePage;
    JetSmartReservaVuelosPage jsReservaVuelosPage;
    JetSmartReservaVuelosInformacionPage jsReservaReservasVuelosInformacionPage;

    @Given("Que soy un usuario e ingreso a la pagina JetSmart")
    public void que_soy_un_usuario_e_ingreso_a_la_pagina_jet_smart() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(DriverFactory.getDriver());
        jsReservaVuelosPage = new JetSmartReservaVuelosPage(DriverFactory.getDriver());
        jsReservaReservasVuelosInformacionPage = new JetSmartReservaVuelosInformacionPage(DriverFactory.getDriver());
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
    }

    @When("selecciono  {string} en el campo de origen")
    public void selecciono_en_el_campo_de_origen(String string) throws InterruptedException{
        jsHomePage.ingresarLugarOrigenVuelos("SCL");

    }

    @When("selecciono  {string} en el campo de destino")
    public void selecciono_en_el_campo_de_destino(String string)throws InterruptedException {
        jsHomePage.ingresarLugarDestinoVuelos("IQQ");
    }

    @When("selecciono  {string} como fecha de ida")
    public void selecciono_como_fecha_de_ida(String string) throws InterruptedException{
        jsHomePage.ingresarFechaIdaVuelos("Mayo 12, 2021");
    }

    @When("selecciono  {string} como fecha de vuelta")
    public void selecciono_como_fecha_de_vuelta(String string) throws InterruptedException{
        jsHomePage.ingresarFechaVueltaVuelos("Junio 1, 2021");
    }

    @When("selecciono {string} pasajero en el campo de pasajeros")
    public void selecciono_pasajero_en_el_campo_de_pasajeros(String string) throws InterruptedException{
        jsHomePage.ingresarPasajerosVuelos("1");
    }

    @When("presiono el boton smart")
    public void presiono_el_boton_smart()throws InterruptedException {
        jsHomePage.apretarBoton();
    }

    @When("selecciono la hora de ida disponible")
    public void selecciono_la_hora_de_ida_disponible()throws InterruptedException {
        jsReservaVuelosPage.seleccionarHoraIda();
    }

    @When("selecciono el paquete ida paquete ligero")
    public void selecciono_el_paquete_ida_paquete_ligero()throws InterruptedException {
        jsReservaVuelosPage.seleccionarPaqueteIdaLigero();
    }

    @When("selecciono la hora de vuelta disponible")
    public void selecciono_la_hora_de_vuelta_disponible() throws InterruptedException{
        jsReservaVuelosPage.seleccionarHoraVuelta();
    }

    @When("selecciono el paquete vuelta paquete ligero vuelta")
    public void selecciono_el_paquete_vuelta_paquete_ligero_vuelta() throws InterruptedException{
        jsReservaVuelosPage.seleccionarPaqueteVueltaLigero();
    }

    @When("presiono el boton Continuar")
    public void presiono_el_boton_continuar()throws InterruptedException {
        jsReservaVuelosPage.seleccionarBotonFinal();
    }

    @Then("se encuentran paquetes disponibles")
    public void se_encuentran_paquetes_disponibles()throws InterruptedException {
        Assert.assertTrue(jsReservaReservasVuelosInformacionPage.validarInformacionDeVuelos());
    }
}