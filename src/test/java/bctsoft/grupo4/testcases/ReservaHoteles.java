package bctsoft.grupo4.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ReservaHoteles {


    WebDriver driver;

    // WebDriverWait wait = new WebDriverWait(driver,30);

    //constructor
    public ReservaHoteles(){
      //  this.driver = new ChromeDriver();
    }

    private boolean lugarHospedajeValido(String lugarHospedaje){
        boolean valor;
        if (lugarHospedaje.length() < 3) {
            valor = false;
        } else {
            boolean existeLugar = driver.findElements(By.id("b_destination")).size() > 0;
            if (existeLugar) {
                valor = true;
            } else {
                valor = false;
            }
        }
        return valor;

    }

    public String casoBajaPrioridad(String lugarHospedaje, String fechaEntrada, String fechaSalida)throws InterruptedException, ParseException{
        String resultado = "";
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//*[@aria-label='Close'])[4]")).click();
        driver.findElement(By.xpath("//*[@for='sbHotels']")).click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iFrame[@title='Buscar alojamiento en Santiago']")));
        WebElement textBoxLugar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_destination")));


        if(lugarHospedajeValido(lugarHospedaje)){
            textBoxLugar.clear();
            textBoxLugar.sendKeys(lugarHospedaje);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-2")));//esperar desplegable resultados
            driver.findElement(By.id("ui-id-2")).click(); //click resultados
        }else{
            resultado = "Lugar no valido";
        }

        //validacion fecha de entrada al hotel
        driver.findElement(By.xpath("//*[@id=\"b_checkin_wrapper\"]/button/span")).click();//click fecha ida
        Thread.sleep(2000);

        String fecha[] = fechaEntrada.split("-");//dividir el string en cada -
        int fechaEntradaInt[]= new int[fecha.length];
        for (int i = 0; i < fechaEntradaInt.length; i++) {
            fechaEntradaInt[i]= Integer.parseInt(fecha[i]);
        }


        int diaActual = 5;
        int mesActual = 5;
        int anoActual = 2021;

        if(fechaEntradaInt[2]<diaActual){
            resultado = "dia no disponible, inserte un dia valido";

        }else{

            List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table//td"));
            int total_nodes = dates.size();

            for (int i = 0; i < total_nodes; i++) {
                String date = dates.get(i).getText();

                if(date.equals(fecha[2])) {
                    dates.get(i).click();
                    break;
                }
            }

        }

        //validar fecha de salida del hotel
        driver.findElement(By.id("checkOutDate")).click();//click fecha vuelta
        Thread.sleep(2000);
        String mesAnio = driver.findElement(By.className("ui-datepicker-title")).getText();

        String mes = mesAnio.split(" ")[0].trim();
        String anio = mesAnio.split(" ")[1].trim();

        String fechaVuelta[] = fechaSalida.split("-");


        //click hasta encontrar mes y año
        while( !(mes.equals(fechaVuelta[1]) && anio.equals(fechaVuelta[0])) ){
            //System.out.println("Click next");
            driver.findElement(By.xpath("//a[@title='>']")).click();
            mesAnio = driver.findElement(By.className("ui-datepicker-title")).getText();
            mes = mesAnio.split(" ")[0].trim();
            anio = mesAnio.split(" ")[1].trim();
        }
        //listar dias y elegir
        List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table//td"));
        int total_nodes = dates.size();



        for (int i = 0; i < total_nodes; i++) {
            String date = dates.get(i).getText();

            if (date.equals(fechaVuelta[2])) {
                dates.get(i).click();
                if(driver.findElement(By.xpath("//*[@id=\"b_checkout_wrapper\"]/div")).isDisplayed()){
                    resultado = "No se puede realizar reservaciones por mas de 30 noches";
                }
                break;
            }else{

            }
        }


        return resultado;
    }

    public String casoMediaPrioridad(String lugarHospedaje, String fechaEntrada, String fechaSalida, String habitaciones, String adultos)throws InterruptedException, ParseException{
        String resultado = "";
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//*[@aria-label='Close'])[4]")).click();
        driver.findElement(By.xpath("//*[@for='sbHotels']")).click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iFrame[@title='Buscar alojamiento en Santiago']")));
        WebElement textBoxLugar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_destination")));


        if(lugarHospedajeValido(lugarHospedaje)){
            textBoxLugar.clear();
            textBoxLugar.sendKeys(lugarHospedaje);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-2")));//esperar desplegable resultados
            driver.findElement(By.id("ui-id-2")).click(); //click resultados
        }else{
            resultado = "Lugar no valido";
        }

        //validacion fecha de entrada al hotel
        driver.findElement(By.xpath("//*[@id=\"b_checkin_wrapper\"]/button/span")).click();//click fecha ida
        Thread.sleep(2000);

        String fecha[] = fechaEntrada.split("-");//dividir el string en cada -
        int fechaEntradaInt[]= new int[fecha.length];
        for (int i = 0; i < fechaEntradaInt.length; i++) {
            fechaEntradaInt[i]= Integer.parseInt(fecha[i]);
        }


        int diaActual = 7;
        int mesActual = 5;
        int anoActual = 2021;

        if(fechaEntradaInt[2]<diaActual){
            resultado = "dia no disponible, inserte un dia valido";

        }else{

            List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table//td"));
            int total_nodes = dates.size();

            for (int i = 0; i < total_nodes; i++) {
                String date = dates.get(i).getText();

                if(date.equals(fecha[2])) {
                    dates.get(i).click();
                    break;
                }
            }

        }

        //validar fecha de salida del hotel
        driver.findElement(By.id("checkOutDate")).click();//click fecha vuelta
        Thread.sleep(2000);
        String mesAnio = driver.findElement(By.className("ui-datepicker-title")).getText();

        String mes = mesAnio.split(" ")[0].trim();
        String anio = mesAnio.split(" ")[1].trim();

        String fechaVuelta[] = fechaSalida.split("-");


        //click hasta encontrar mes y año
        while( !(mes.equals(fechaVuelta[1]) && anio.equals(fechaVuelta[0])) ){
            System.out.println("Click next");
            driver.findElement(By.xpath("//a[@title='>']")).click();
            mesAnio = driver.findElement(By.className("ui-datepicker-title")).getText();
            mes = mesAnio.split(" ")[0].trim();
            anio = mesAnio.split(" ")[1].trim();
        }
        //listar dias y elegir
        List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table//td"));
        int total_nodes = dates.size();

        for (int i = 0; i < total_nodes; i++) {
            String date = dates.get(i).getText();

            if (date.equals(fechaVuelta[2])) {
                dates.get(i).click();
                break;
            }
        }

        //seleccionar habitaciones y adultos
        driver.findElement(By.xpath("//select//option[@aria-label='"+habitaciones+"']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select//option[@aria-label='"+adultos+"']")).click();
        Thread.sleep(1000);
        //obtener handles
        Set<String> handles = driver.getWindowHandles();

        //validar boton de busqueda
        if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit"))).isEnabled()){
            resultado = "se hizo la busqueda";
            driver.findElement(By.name("submit")).click();
        }else{
            resultado = "ocurrio un error";
        }

        //SWITCH VENTANA
        //recorrer handles para ver cual ventana esta activa y trabajar ahi
        for(String handle : driver.getWindowHandles()){
            if(!handles.contains(handle)) {
                driver.switchTo().window(handle);
            }
        }
        //validar habitaciones
        Select opcionHabitaciones = new Select(driver.findElement(By.id("no_rooms")));
        String muestraPaginaCargada = opcionHabitaciones.getFirstSelectedOption().getText();

        if(!(muestraPaginaCargada.equals(habitaciones))){
            resultado = "No hay "+habitaciones+" para una sola persona";
        }else{
            resultado = "Habitaciones encontradas";
        }


        return resultado;
    }

    public String casoAltaPrioridad(String lugarHospedaje, String fechaEntrada, String fechaSalida, String habitaciones, String adultos) throws InterruptedException, ParseException { //, , , String ninos){

        WebDriverWait wait = new WebDriverWait(driver, 20);
        String resultado = "";

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Close'])[4]")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@aria-label='Close'])[4]")).click();
        driver.findElement(By.xpath("//*[@for='sbHotels']")).click();

        //esperar iframe trabajable
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iFrame[@title='Buscar alojamiento en Santiago']")));
        WebElement textBoxLugar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_destination")));

        //cargar lugar hospedaje
        if(lugarHospedajeValido(lugarHospedaje)){
            textBoxLugar.clear();
            textBoxLugar.sendKeys(lugarHospedaje);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-2")));//esperar desplegable resultados
            driver.findElement(By.id("ui-id-2")).click(); //click resultados
        }else{
            resultado = "Lugar no valido";
        }

        //validacion fecha de entrada al hotel
        driver.findElement(By.xpath("//*[@id=\"b_checkin_wrapper\"]/button/span")).click();//click fecha ida
        Thread.sleep(2000);

        String fecha[] = fechaEntrada.split("-");//dividir el string en cada -
        int fechaEntradaInt[]= new int[fecha.length];
        for (int i = 0; i < fechaEntradaInt.length; i++) {
            fechaEntradaInt[i]= Integer.parseInt(fecha[i]);
        }


        int diaActual = 7;
        int mesActual = 5;
        int anoActual = 2021;

        if(fechaEntradaInt[2]<diaActual){
            resultado = "dia no disponible, inserte un dia valido";

        }else{

            List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table//td"));
            int total_nodes = dates.size();

            for (int i = 0; i < total_nodes; i++) {
                String date = dates.get(i).getText();

                if(date.equals(fecha[2])) {
                    dates.get(i).click();
                    break;
                }
            }

        }


        //validar fecha de salida del hotel
        driver.findElement(By.id("checkOutDate")).click();//click fecha vuelta
        Thread.sleep(2000);
        String mesAnio = driver.findElement(By.className("ui-datepicker-title")).getText();

        String mes = mesAnio.split(" ")[0].trim();
        String anio = mesAnio.split(" ")[1].trim();

        String fechaVuelta[] = fechaSalida.split("-");


        //click hasta encontrar mes y año
        while( !(mes.equals(fechaVuelta[1]) && anio.equals(fechaVuelta[0])) ){
            System.out.println("Click next");
            driver.findElement(By.xpath("//a[@title='>']")).click();
            mesAnio = driver.findElement(By.className("ui-datepicker-title")).getText();
            mes = mesAnio.split(" ")[0].trim();
            anio = mesAnio.split(" ")[1].trim();
        }
        //listar dias y elegir
        List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table//td"));
        int total_nodes = dates.size();

        for (int i = 0; i < total_nodes; i++) {
            String date = dates.get(i).getText();

            if (date.equals(fechaVuelta[2])) {
                dates.get(i).click();
                break;
            }
        }

        //seleccionar habitaciones y adultos
        driver.findElement(By.xpath("//select//option[@aria-label='"+habitaciones+"']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select//option[@aria-label='"+adultos+"']")).click();
        Thread.sleep(1000);
        //obtener handles
        Set<String> handles = driver.getWindowHandles();

        //validar boton de busqueda
        if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit"))).isEnabled()){
            resultado = "se hizo la busqueda";
            driver.findElement(By.name("submit")).click();
        }else{
            resultado = "ocurrio un error";
        }

        //SWITCH VENTANA
        //recorrer handles para ver cual ventana esta activa y trabajar ahi
        for(String handle : driver.getWindowHandles()){
            if(!handles.contains(handle)) {
                driver.switchTo().window(handle);
            }
        }
        //validar habitaciones
        Select opcionHabitaciones = new Select(driver.findElement(By.id("no_rooms")));
        String muestraPaginaCargada = opcionHabitaciones.getFirstSelectedOption().getText();

        if(!(muestraPaginaCargada.equals(habitaciones))){
            resultado = "No hay "+habitaciones+" para una sola persona";
        }else{
            resultado = "Habitaciones encontradas";
        }


        driver.findElement(By.xpath("(//span[contains(text(),'5 estrellas')])[2]")).click(); //click 5 estrellas
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@data-click-store-id='sr-compset-174756']")).click(); //click opcion sheraton


        //switchear a la pagina que se abre
        for(String handle : driver.getWindowHandles()){
            if(!handles.contains(handle)) {
                driver.switchTo().window(handle);
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.id("hcta")).click();//click reservar
        //seleccionar habitacion
        Thread.sleep(1000);
        String divHabitaciones[] = habitaciones.split(" ");
        Select opcionHabitacionAdv = new Select(driver.findElement(By.name("nr_rooms_17475607_244937953_2_2_0")));
        opcionHabitacionAdv.selectByValue(divHabitaciones[0]);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
        if((driver.getTitle().toString()).equals("JetSmart: tus datos")){
            resultado = "Se hizo la reserva con exito";
        }


        return resultado;
    }

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jetsmart.com/cl/es/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @Test
    public void TC001() throws ParseException, InterruptedException {
        Assert.assertEquals("No se puede realizar reservaciones por mas de 30 noches", casoBajaPrioridad("santiago de chile", "2021-5-5","2021-junio-6"));
    }

    @Test
    public void TC002() throws ParseException, InterruptedException{
        Assert.assertEquals("No hay 30 habitaciones para una sola persona",
                casoMediaPrioridad("santiago de chile", "2021-5-5",
                        "2021-mayo-8", "30 habitaciones", "2 adultos"));
    }

    @Test
    public void TC003() throws ParseException, InterruptedException{
       Assert.assertEquals("Se hizo la reserva con exito",
               casoAltaPrioridad("santiago de chile",
                       "2021-5-5","2021-mayo-8",
                       "1 habitación", "2 adultos"));
    }


    @After
    public void close(){
        driver.quit();
    }




}


/*

    public static void main(String[] args) throws InterruptedException, ParseException {


        WebDriverManager.chromedriver().setup();
        ReservaHoteles vf = new ReservaHoteles();
        vf.driver.get("https://jetsmart.com/cl/es/");

        //TC-001
        // System.out.println(vf.hospedajeHotel("santiago de chile","2021-5-2","2021-mayo-5","30 habitaciones", "1 adulto"));


        // TC-002
        // System.out.println(vf.hospedajeHotel("santiago de chile","2021-5-7","2021-junio-8"));

        //TC-003
        //System.out.println(vf.hospedajeHotel("santiago de chile","2021-5-2","2021-mayo-5","1 habitación", "2 adultos"));

        //casobajonivel
        //System.out.println(vf.casoBajaPrioridad("santiago de chile", "2021-5-5","2021-junio-6"));

        //caso medio nivel
        //System.out.println(vf.casoMediaPrioridad("santiago de chile", "2021-5-5","2021-mayo-8", "30 habitaciones", "2 adultos"));

        //caso alto nivel nivel
        System.out.println(vf.casoAltaPrioridad("santiago de chile", "2021-5-5","2021-mayo-8", "1 habitación", "2 adultos"));

        WebDriverWait wait = new WebDriverWait(vf.driver,30);

    }


}

 */