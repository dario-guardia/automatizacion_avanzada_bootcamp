package automationcraft.testcreation.jetsmart.G4.steps;

import automationcraft.engine.selenium.DriverFactory;
import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepModuloVuelo_CasoBajoG4 {
    JetSmartHomePage jsHomePage;
    JetSmartReservaVuelosPage jsReservaVuelosPage;
    JetSmartReservaVuelosInformacionPage jsReservaReservasVuelosInformacionPage;
    @Given("Que soy un usuario e ingreso a la pagina JetSmart caso bajo")
    public void que_soy_un_usuario_e_ingreso_a_la_pagina_jet_smart_caso_bajo() {
        jsHomePage = new JetSmartHomePage(DriverFactory.getDriver());
        jsReservaVuelosPage = new JetSmartReservaVuelosPage(DriverFactory.getDriver());
        jsReservaReservasVuelosInformacionPage = new JetSmartReservaVuelosInformacionPage(DriverFactory.getDriver());
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
    }

    @When("Ingreso al formulario vuelo")
    public void ingreso_al_formulario_vuelo()throws InterruptedException {
        jsHomePage.cerrarModuloSuscribete();
    }

    @Then("selecciono {string} en campo origen se muestra leyenda que el lugar no existe")
    public void selecciono_en_campo_origen_se_muestra_leyenda_que_el_lugar_no_existe(String string) throws InterruptedException {
        Assert.assertEquals("No hay resultados.",jsHomePage.validarIngresarMalOrigenVuelos("Inglaterra"));
    }
}
