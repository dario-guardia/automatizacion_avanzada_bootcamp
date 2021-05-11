package automationcraft.testcreation.jetsmart.steps;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPagoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepModuloTransporteCasoBajoG4 {

    protected JetSmartHomePage jsHomePage;
    protected JetSmartReservaTrasladoPage jsReservaPago;
    protected JetSmartReservaTrasladoPagoPage jsValidarPago;
    protected JetSmartReservaTrasladoInformacionPage jsInformacionPago;


    @Given("Ingreso a la pagina JetSmart e ingreso al modulo de transporte")
    public void ingreso_a_la_pagina_jet_smart_e_ingreso_al_modulo_de_transporte() {
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        throw new io.cucumber.java.PendingException();
    }
    @When("Se cierra ventana emergente de suscribir")
    public void se_cierra_ventana_emergente_de_suscribir() throws InterruptedException {
        jsHomePage.cerrarModuloSuscribete();
        throw new io.cucumber.java.PendingException();
    }

    @When("Ingreso al modulo de vuelo")
    public void ingreso_al_modulo_de_vuelo() throws InterruptedException {
        jsHomePage.ClickTraslado();
        throw new io.cucumber.java.PendingException();
    }

    @When("Selecciono recuadro de solo {string}")
    public void selecciono_recuadro_de_solo(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Escribo en la casilla lugar de origen de traslado {string}")
    public void escribo_en_la_casilla_lugar_de_origen_de_traslado(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Valido leyenda {string}")
    public void valido_leyenda(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
