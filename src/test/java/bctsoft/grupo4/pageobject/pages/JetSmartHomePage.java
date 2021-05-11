package bctsoft.grupo4.pageobject.pages;

import bctsoft.grupo4.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class JetSmartHomePage extends SeleniumBase {

    public JetSmartHomePage(WebDriver driver) {
        super(driver);
    }

    //repositorio objetos JetSmartHomePage
    private By btnPopUpClose = By.xpath("//div[@class='modal-header']//button[@type='button']");

    //reserva de hoteles
    private By btnVentanaHoteles = By.xpath("//*[@for='sbHotels']");
    private By SelecFrameHotel = By.xpath("//iFrame[@title='Buscar alojamiento en Santiago']");
    private By txtDestinoHotel = By.id("b_destination");
    private By clickDestinoHoteles = By.id("ui-id-2");
    private By clickcalendarioHoteles = By.xpath("//*[@id=\"b_checkin_wrapper\"]/button/span");
    private By diaDelCalendarioHoteles = By.xpath("//div[@id='ui-datepicker-div']/table//td");
    private By calendarioVueltaHoteles = By.id("checkOutDate");
    private By mesyAñoCalendarioHoteles = By.className("ui-datepicker-title");
    private By btnSiguienteMesCalendarioHoteles = By.xpath("//a[@title='>']");
    private By btnBusquedaHoteles = By.name("submit");
    private By numHabitacionesHoteles = By.xpath("//select//option[@aria-label='habitaciones']");
    private By numAdultosHoteles = By.xpath("//select//option[@aria-label='adultos']");
    private By txtMaxNoches = By.id("b_checkout_wrapper");
    private By btnBuscarDeshabilitado = By.className("b-aff__submit--button disabled");
    //private
    //reserva de vuelo
    private By txtIngresarOrigenVuelo = By.xpath("//input[@placeholder='Origen']");
    private By clickIngresarOrigenVuelo = By.xpath("//li[contains(@class,'dg-typing-results-list-item')]");
    private By txtIngresarDestinoVuelo = By.xpath("//input[@placeholder = 'Destino']");
    private By clickIngresarDestinoVuelo = By.xpath("//li[contains(@class,'dg-typing-results-list-item')]");
    private By clickCheckIda = By.xpath("//label[@for='sbOneWayJourney']");
    private By clickFechaIdaVuelo = By.xpath("(//div//span[@aria-label='fechaIda'])[1]");
    private By clickFechaVueltaVuelo = By.xpath("(//div//span[@aria-label='fechaVuelta'])[4]");
    private By selectPasajerosVuelo = By.xpath("//input[@value='1 Adulto']");
    private By btnBuscarSmartVuelo = By.xpath("//*[@id='rt_button']");
    private By txtNoHayResultados = By.xpath("//label[contains(text(),'No hay resultados.')]");
    private By btnOkPasajeros = By.xpath("//button[@class='dg-button dg-pax-btn']");
    //Reserva Traslado
    private By txtLugarRecogidaTraslado = By.xpath("//*[@id=\"input-pickup\"]");
    private By txtlugarDestinoTraslado = By.xpath("//*[@id=\"input-dropoff\"]");
    private By clickCalendarioTraslado = By.cssSelector("#input-pickup-date");
    private By clickHoraTraslado = By.id("ct-pickup-hour");
    private By clickSeleccionarHoraIdaTraslado = By.xpath("//*[contains(@aria-label,'horarioIda')]");
    private By SelectPasajerosTraslado = By.id("passenger-number-input");
    private By SelectNumPasajerosTraslado = By.xpath("//li[contains(text(),'pasajeros')]");
    private By btnBuscarTraslado = By.id("ct-button-search");
    private By btnSoloIdaTransporte = By.xpath("//span[@ng-bind='labelOneWay']");
    private By listPasajerosTraslado = By.xpath("//ul[contains(@class,'ct-list-container')]");
    private By CartErrorLugarOrigenTraslado = By.xpath("//span[@class='ct-palette-w-color']");
    private By ClickTraslado = By.xpath("//label[@for='sbTransfers']");
    private By ClickVentanaTraslado = By.xpath("(//iFrame)[3]");
    private By CerrarVentanaSub = By.xpath("//*[@id=\"modalReg\"]/div/div/div[1]/button/span");
    private By clickVentanaHoraTraslado = By.id("ct-pickup-hour");
    private By ListHorasTraslado = By.id("ct-time-picker-pick-up-option-container");
    private By ReservarTraslado = By.xpath("//button [@class = 'ct-btn ct-btn-p ']");
    //Keyword Driver
    //////////////////////////////Vuelos
    public void cerrarModuloSuscribete() throws InterruptedException {
        Thread.sleep(2000);
            click(btnPopUpClose);
    }
    public void seleccionarCheckIda() {
        click(clickCheckIda);
    }
    public String validarIngresarMalOrigenVuelos(String lugarOrigen)throws InterruptedException {
        click(txtIngresarOrigenVuelo);
        type(lugarOrigen, txtIngresarOrigenVuelo);
        Thread.sleep(2000);
        String resultado = "";
        resultado = findElement(txtNoHayResultados).getText();
        return resultado;
    }
    public void ingresarLugarOrigenVuelos(String lugarOrigen)throws InterruptedException {
        click(txtIngresarOrigenVuelo);
        type(lugarOrigen, txtIngresarOrigenVuelo);
        Thread.sleep(2000);
        click(clickIngresarOrigenVuelo);
    }
    public void ingresarLugarDestinoVuelos(String lugarDestino)throws InterruptedException {
        click(txtIngresarDestinoVuelo);
        type(lugarDestino, txtIngresarDestinoVuelo);
        Thread.sleep(2000);
        click(clickIngresarDestinoVuelo);

    }
    public void ingresarFechaIdaVuelos(String fechaIda) throws InterruptedException{
        Thread.sleep(2000);
        this.clickFechaIdaVuelo = By.xpath("(//div//span[@aria-label='" + fechaIda + "'])[1]");
        //String fechaIdaSplit[] = fechaIda.split(" ");
        findElement(clickFechaIdaVuelo).findElement(By.xpath("(//div//span[@aria-label='" + fechaIda + "'])[1]")).click();
        //type(fechaIda, clickFechaIdaVuelo);
        //click(clickFechaIdaVuelo);
    }

    public void ingresarFechaVueltaVuelos(String fechaVuelta)throws InterruptedException {
        Thread.sleep(2000);
        //String fechaIdaSplit[] = fechaVuelta.split(" ");
        this.clickFechaVueltaVuelo = By.xpath("(//div//span[@aria-label='" + fechaVuelta + "'])[4]");
        findElement(clickFechaVueltaVuelo).findElement(By.xpath("(//div//span[@aria-label='" + fechaVuelta + "'])[4]")).click();
        //type(fechaVuelta, clickFechaVueltaVuelo);
    }
    public void ingresarPasajerosVuelos(String pasajeros)throws InterruptedException {
        Thread.sleep(2000);
        click(selectPasajerosVuelo);
        Thread.sleep(2000);
        click(btnOkPasajeros);

    }
    public void apretarBoton()throws InterruptedException {
        Thread.sleep(2000);
        click(btnBuscarSmartVuelo);
    }
    ////////////////////////////////Funciones Traslado
    public void clickCasillaIda() throws InterruptedException {
        Thread.sleep(2000);
        click(btnSoloIdaTransporte);
    }
    public void ClickTraslado() throws InterruptedException {
        //wait(2000,ClickTraslado);
        click(ClickTraslado);
    }
    public void cambiarDeFrame() throws InterruptedException {
        waitFrame(2, ClickVentanaTraslado);
    }
    public void IngresarOrigen(String lugarOrigen) throws InterruptedException {
        click(txtLugarRecogidaTraslado);
        type(lugarOrigen, txtLugarRecogidaTraslado);
        Thread.sleep(2000);
        sendKey(Keys.ARROW_DOWN, txtLugarRecogidaTraslado);
        sendKey(Keys.ENTER, txtLugarRecogidaTraslado);
        Thread.sleep(2000);
    }
    public void IngresarDestino(String lugarDestino) throws InterruptedException {
        click(txtlugarDestinoTraslado);
        type(lugarDestino, txtlugarDestinoTraslado);
        Thread.sleep(2000);
        sendKey(Keys.ARROW_DOWN, txtlugarDestinoTraslado);
        sendKey(Keys.ENTER, txtlugarDestinoTraslado);
        Thread.sleep(2000);
    }
    public void SaltarFechaTraslado() {
        sendKey(Keys.TAB, clickCalendarioTraslado);
        System.out.println("click tab");
    }
    public void seleccionarHoraDeIda(String horarioIda) throws InterruptedException {
        click(clickVentanaHoraTraslado);
        findElement(ListHorasTraslado).findElement(By.xpath("//*[contains(@aria-label,'" + horarioIda + "')]")).click();
        Thread.sleep(1000);
    }
    public void seleccionarNumerPasajero(String pasajeros) throws InterruptedException {
        click(SelectPasajerosTraslado);
        findElement(listPasajerosTraslado).findElement(By.xpath("//li[contains(text(),'" + pasajeros + "')]")).click();

    }
    public void botonBuscarTraslado() throws InterruptedException {
        click(btnBuscarTraslado);
        Thread.sleep(10000);
    }
    public String cambiarVentana() throws InterruptedException {
        Set<String> handles = driver.getWindowHandles();
        String resultado = "";
        for (String handle : driver.getWindowHandles()) {
            if (!handles.contains(handle)) {
                switchFramePadre();
                driver.switchTo().window(handle);
            } else {
                resultado = "faltan datos por rellenar";
            }
        }
        return resultado;
    }
    public void SwitchVentana() throws InterruptedException {
        switchVentana(1);
        Thread.sleep(2000);
    }
    public String lugarDestinoErroneo()throws InterruptedException {
        String confirmar = getText(CartErrorLugarOrigenTraslado);
        String resultado = "";
        if (confirmar.equals("No hay resultados.")) {
            resultado = "lugar de origen erroneo";
        } return resultado;
    }
    public void seleccionarFechaIda(String fechaIda) throws InterruptedException {
        String fechaTrim = fechaIda.split(" ")[0].trim();
        int fechaSplit = Integer.parseInt(fechaTrim);
        int fechaActual = 10;
        int fechaDeseada = fechaSplit;
        while (fechaActual < fechaDeseada) {
            findElement(clickCalendarioTraslado).sendKeys(Keys.ARROW_RIGHT);
            fechaActual++;
        }
        findElement(clickCalendarioTraslado).sendKeys(Keys.ENTER);
    }

    ////////////////////////////////////////////FUNCIONES HOTELES

    public void seleccionarPestañaHotel(){
        click(btnVentanaHoteles);
    }

    public void switchFrameHoteles(){
        switchFrame(0);
    }

    public void setHospedaje(String lugar){
        switchFrame(0);
        click(txtDestinoHotel);
        clearText(txtDestinoHotel);
        type(lugar, txtDestinoHotel);

    }

    public void clickFechaIda(){
        click(clickcalendarioHoteles);
    }

    public void setFechaIdaHotel(String fechaEntrada){
        String fecha[] = fechaEntrada.split("-");
        int fechaEntradaInt[]= new int[fecha.length];
        for (int i = 0; i < fechaEntradaInt.length; i++) {
            fechaEntradaInt[i]= Integer.parseInt(fecha[i]);
        }
        int diaActual = 6;
        int mesActual = 5;
        int anoActual = 2021;

        if(fechaEntradaInt[2]<diaActual){
            System.out.println("dia no disponible, inserte un dia valido");
        }else{
            List<WebElement> dates = driver.findElements(diaDelCalendarioHoteles);
            int total_nodes = dates.size();

            for (int i = 0; i < total_nodes; i++) {
                String date = dates.get(i).getText();

                if(date.equals(fecha[2])) {
                    dates.get(i).click();
                    break;
                }
            }

        }

    }


    public void clickFechaVuelta() throws InterruptedException {
        click(calendarioVueltaHoteles);
        Thread.sleep(2000);
    }
    public void setFechavueltaHotel(String fechaSalida) throws InterruptedException {
        Thread.sleep(2000);
        String mesAnio = driver.findElement(mesyAñoCalendarioHoteles).getText();
        String mes = mesAnio.split(" ")[0].trim();
        String anio = mesAnio.split(" ")[1].trim();
        String fechaVuelta[] = fechaSalida.split("-");

        //click hasta encontrar mes y año
        while( !(mes.equals(fechaVuelta[1]) && anio.equals(fechaVuelta[0])) ){
            System.out.println("Click next");
            driver.findElement(btnSiguienteMesCalendarioHoteles).click();
            mesAnio = driver.findElement(mesyAñoCalendarioHoteles).getText();
            mes = mesAnio.split(" ")[0].trim();
            anio = mesAnio.split(" ")[1].trim();
        }
        //listar dias y elegir
        List<WebElement> dates = driver.findElements(diaDelCalendarioHoteles);
        int total_nodes = dates.size();

        for (int i = 0; i < total_nodes; i++) {
            String date = dates.get(i).getText();

            if (date.equals(fechaVuelta[2])) {
                dates.get(i).click();
                break;
            }
        }
    }

    public void setAdultos(String numAdultos){
        this.numAdultosHoteles = By.xpath("//select//option[@aria-label='"+ numAdultos +"']");
        click(numAdultosHoteles);

    }

    public void setHabitacionesHotel(String habitaciones) throws InterruptedException {
        Thread.sleep(1000);
        this.numHabitacionesHoteles = By.xpath("//select//option[@aria-label='"+habitaciones+"']");
        click(numHabitacionesHoteles);
        Thread.sleep(1000);

    }

    public String buscarHotelDeshabilitado(){
        String verificar = getText(txtMaxNoches);
        return verificar;
    }

    public void buscarHotel(){
        click(btnBusquedaHoteles);
    }





}