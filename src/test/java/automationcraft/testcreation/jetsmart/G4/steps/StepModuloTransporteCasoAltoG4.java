package automationcraft.testcreation.jetsmart.G4.steps;

import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaTrasladoPagoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepModuloTransporteCasoAltoG4 {

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

    @When("Selecciono con un click el la fecha de recogida")
    public void selecciono_con_un_click_el_la_fecha_de_recogida() throws InterruptedException {
        jsHomePage.seleccionarFechaIda("9 Mayo 2021");
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

    @When("switcheo de pagina")
    public void switcheo_de_pagina() throws InterruptedException {
        jsHomePage.SwitchVentana();
    }

    @When("Click boton Reserva ahora.")
    public void click_boton_reserva_ahora() throws InterruptedException {
        jsReservaPago.esperaClickeablebotonTraslado();
    }

    @When("Escribo en la casilla Nombre del pasajero {string}")
    public void escribo_en_la_casilla_nombre_del_pasajero(String string) {
        jsInformacionPago.rellenarNombreApellidoTraslado("Marcelo Letelier");
    }

    @When("Escribo en la casilla Correo electronico del pasajero {string}")
    public void escribo_en_la_casilla_correo_electronico_del_pasajero(String string) {
        jsInformacionPago.correoTraslado("mletelierpalomares@gmail.com");
    }

    @When("Escribo en la casilla Confirmar Correo electronico del pasajero {string}")
    public void escribo_en_la_casilla_confirmar_correo_electronico_del_pasajero(String string) {
        jsInformacionPago.ValidarcorreoTraslado("mletelierpalomares@gmail.com");
    }

    @When("Escribo en la casilla numero de movil {string}")
    public void escribo_en_la_casilla_numero_de_movil(String string) {
        jsInformacionPago.NumeroPersonalTraslado("964567406");
    }

    @When("Escribo en la casilla Numero de vuelo {string}")
    public void escribo_en_la_casilla_numero_de_vuelo(String string) {
        jsInformacionPago.CodigoVueloTraslado("AB147");
    }

    @When("Click en boton Ir a caja")
    public void click_en_boton_ir_a_caja() {
        jsInformacionPago.ClickContinuarBotonTraslado();
    }

    @Then("Valida que este en la vista de Pago con {string}")
    public void valida_que_este_en_la_vista_de_pago_con(String string) {
        Assert.assertEquals("se cargaron los datos con exito",jsInformacionPago.resumenPago());
    }

}
