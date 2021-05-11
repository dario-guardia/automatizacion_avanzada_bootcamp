package automationcraft.testcreation.jetsmart.G4.steps;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPagoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepModuloTransporteCasoMedioG4 {

    protected JetSmartHomePage jsHomePage;
    protected JetSmartReservaTrasladoPage jsReservaPago;
    protected JetSmartReservaTrasladoPagoPage jsValidarPago;
    protected JetSmartReservaTrasladoInformacionPage jsInformacionPago;

    @Given("Ingreso a la pagina JetSmart e ingreso al modulo de transporte")
    public void ingreso_a_la_pagina_jet_smart_e_ingreso_al_modulo_de_transporte() {
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
    }

    @When("Se cierra ventana emergente de suscribir")
    public void se_cierra_ventana_emergente_de_suscribir() throws InterruptedException {
        jsHomePage.cerrarModuloSuscribete();

    }

    @When("Ingreso al modulo de vuelo")
    public void ingreso_al_modulo_de_vuelo() throws InterruptedException {
        jsHomePage.ClickTraslado();
        jsHomePage.cambiarDeFrame();
    }


    @When("Selecciono recuadro de solo {string}")
    public void selecciono_recuadro_de_solo(String string) throws InterruptedException {
        jsHomePage.clickCasillaIda();
    }

    @When("Escribo en la casilla lugar de origen de traslado {string}")
    public void escribo_en_la_casilla_lugar_de_origen_de_traslado(String string) throws InterruptedException {
        jsHomePage.IngresarOrigen("aeropuerto arturo merino benitez");
    }

    @When("Escribo en la casilla lugar de Destino de traslado {string}")
    public void escribo_en_la_casilla_lugar_de_destino_de_traslado(String string) throws InterruptedException {
        jsHomePage.IngresarDestino("llano subercaseaux 2909");
    }

    @When("No se selecciona la fecha de recogida")
    public void no_se_selecciona_la_fecha_de_recogida() {
        jsHomePage.SaltarFechaTraslado();
    }

    @When("Selecciono con un click la hora de recogida")
    public void selecciono_con_un_click_la_hora_de_recogida() throws InterruptedException {
        jsHomePage.seleccionarHoraDeIda("3:00 AM");
    }

    @When("Selecciono el numero de pasajeros con un click {string}")
    public void selecciono_el_numero_de_pasajeros_con_un_click(String string) throws InterruptedException {
        jsHomePage.seleccionarNumerPasajero("1 pasajero");
    }

    @When("Click en el botono {string}")
    public void click_en_el_botono(String string) throws InterruptedException {
        jsHomePage.botonBuscarTraslado();
    }

    @Then("No avanza a la siguiente ventana porque falta rellenar campo de fecha")
    public void no_avanza_a_la_siguiente_ventana_porque_falta_rellenar_campo_de_fecha() throws InterruptedException {
        Assert.assertEquals("faltan datos por rellenar", jsHomePage.cambiarVentana());
    }
}
