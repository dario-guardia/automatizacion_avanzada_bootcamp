package automationcraft.testcreation.jetsmart.G4.steps;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class StepModuloTransporteCasoBajoG4 {

    protected JetSmartHomePage jsHomePage;

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
        jsHomePage.cambiarDeFrame();
        throw new io.cucumber.java.PendingException();
    }

    @When("Selecciono recuadro de solo {string}")
    public void selecciono_recuadro_de_solo(String string) throws InterruptedException {
        jsHomePage.clickCasillaIda();
        throw new io.cucumber.java.PendingException();
    }

    @When("Escribo en la casilla lugar de origen de traslado {string}")
    public void escribo_en_la_casilla_lugar_de_origen_de_traslado(String string) throws InterruptedException {
        jsHomePage.IngresarOrigen("999999999");
        throw new io.cucumber.java.PendingException();
    }

    @Then("Valido leyenda {string}")
    public void valido_leyenda(String string) throws InterruptedException {
        Assert.assertEquals("lugar de origen erroneo",jsHomePage.lugarDestinoErroneo());
        throw new io.cucumber.java.PendingException();
    }
}
