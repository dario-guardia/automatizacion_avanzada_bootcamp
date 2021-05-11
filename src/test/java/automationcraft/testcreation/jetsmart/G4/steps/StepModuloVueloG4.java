package automationcraft.testcreation.jetsmart.G4.steps;

import automationcraft.engine.selenium.DriverFactory;
import bctsoft.grupo4.pageobject.pages.JetSmartHomePage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosInformacionPage;
import bctsoft.grupo4.pageobject.pages.JetSmartReservaVuelosPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepModuloVueloG4 {
    JetSmartHomePage jsHomePage;
    JetSmartReservaVuelosPage jsReservaVuelosPage;
    JetSmartReservaVuelosInformacionPage jsReservaReservasVuelosInformacionPage;
    ///////////////////Bajo//////////////////
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
    ////////////////////////Medio//////////////////////
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
    ///////////////Alto////////////////////
    @Given("Que soy un usuario e ingreso a la pagina JetSmart")
    public void que_soy_un_usuario_e_ingreso_a_la_pagina_jet_smart() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(DriverFactory.getDriver());
        jsReservaVuelosPage = new JetSmartReservaVuelosPage(DriverFactory.getDriver());
        jsReservaReservasVuelosInformacionPage = new JetSmartReservaVuelosInformacionPage(DriverFactory.getDriver());
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
    }

    @When("selecciono1  {string} en el campo de origen")
    public void selecciono1_en_el_campo_de_origen(String string) throws InterruptedException{
        jsHomePage.ingresarLugarOrigenVuelos("SCL");

    }

    @When("selecciono1  {string} en el campo de destino")
    public void selecciono1_en_el_campo_de_destino(String string)throws InterruptedException {
        jsHomePage.ingresarLugarDestinoVuelos("IQQ");
    }

    @When("selecciono1  {string} como fecha de ida")
    public void selecciono1_como_fecha_de_ida(String string) throws InterruptedException{
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
