package bctsoft.grupo4.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ReservaTraslados {
    WebDriver driver;

    public ReservaTraslados() {
        //this.driver = new ChromeDriver();
    }

    public boolean validarLugarOrigen(String lugarOrigen) {
        boolean valor = false;

        if (lugarOrigen.length() < 3) {
            valor = false;
        } else {
            boolean existeLugar = driver.findElements(By.xpath("//*[@id=\"input-pickup\"]")).size() > 0;
            if (existeLugar) {
                valor = true;
            } else {
                valor = false;
            }

        }

        return valor;
    }

    public boolean validarLugarDestino(String lugarDestino) {
        boolean valor = false;

        if (lugarDestino.length() < 3) {
            valor = false;
        } else {
            boolean existeLugar = driver.findElements(By.xpath("//*[@id=\"input-dropoff\"]")).size() > 0;
            if (existeLugar) {
                valor = true;
            } else {
                valor = false;
            }

        }

        return valor;
    }
    public String casoBajaPrioridad(String opcion, String lugarOrigen, String lugarDestino, String horarioIda, String pasajeros) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        String resultado = "";
        Thread.sleep(2000);
        Set<String> handles = driver.getWindowHandles();
        driver.findElement(By.xpath("//*[@id=\"modalReg\"]/div/div/div[1]/button/span")).click();
        driver.findElement(By.xpath("//label[@for='sbTransfers']")).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iFrame)[3]")));


        driver.findElement(By.xpath("//span[@ng-bind='labelOneWay']")).click();
        WebElement lugarVueltaOrigen = driver.findElement(By.xpath("//*[@id=\"input-pickup\"]"));
        lugarVueltaOrigen.sendKeys(lugarOrigen); //Hacer click en text
        Thread.sleep(2000);
        lugarVueltaOrigen.sendKeys(Keys.ARROW_DOWN);
        lugarVueltaOrigen.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //seleccionar lugar destino
        WebElement lugarVueltaDestino = driver.findElement(By.xpath("//*[@id=\"input-dropoff\"]"));

        lugarVueltaDestino.sendKeys(lugarDestino);
        Thread.sleep(2000);
        lugarVueltaDestino.sendKeys(Keys.ARROW_DOWN);
        lugarVueltaDestino.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //String fecha = "";
        driver.findElement(By.cssSelector("#input-pickup-date")).sendKeys(Keys.TAB);
        //System.out.println(fecha);


        //selecciona hora de ida
        driver.findElement(By.id("ct-pickup-hour")).click();
        WebElement hora_ida = driver.findElement(By.id("ct-time-picker-pick-up-option-container"));
        hora_ida.findElement(By.xpath("//*[contains(@aria-label,'" + horarioIda + "')]")).click();

        Thread.sleep(1000);

        Thread.sleep(1000);
        driver.findElement(By.id("passenger-number-input")).click();
        WebElement pasajerosList = driver.findElement(By.xpath("//ul[contains(@class,'ct-list-container')]"));
        pasajerosList.findElement(By.xpath("//li[contains(text(),'" + pasajeros + "')]")).click();

        driver.findElement(By.id("ct-button-search")).click();
        System.out.println("test fue realizado");

        //SWITCH VENTANA
        //recorrer handles para ver cual ventana esta activa y trabajar ahi
        for (String handle : driver.getWindowHandles()) {
            if (!handles.contains(handle)) {
                driver.switchTo().window(handle);
            }
            else {
                resultado = "faltan datos por rellenar";
            }
        }
        return resultado;
    }

    public String casoMedioPrioridad(String opcion, String lugarOrigen) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String resultado = "";
        Thread.sleep(2000);
        Set<String> handles = driver.getWindowHandles();
        driver.findElement(By.xpath("//*[@id=\"modalReg\"]/div/div/div[1]/button/span")).click();
        driver.findElement(By.xpath("//label[@for='sbTransfers']")).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iFrame)[3]")));
        WebElement lugarVueltaOrigen = driver.findElement(By.xpath("//*[@id=\"input-pickup\"]"));
        Thread.sleep(2000);


        driver.findElement(By.xpath("//span[@ng-bind='labelOneWay']")).click();


        lugarVueltaOrigen.sendKeys(lugarOrigen); //Hacer click en text
        Thread.sleep(2000);
        lugarVueltaOrigen.sendKeys(Keys.ARROW_DOWN);
        lugarVueltaOrigen.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        String origenErroneo = driver.findElement(By.xpath("//span[@class='ct-palette-w-color']")).getText();
        if (origenErroneo.equals("No hay resultados.")) {
            resultado = "lugar de origen erroneo";
        }
        return resultado;
    }


    public String casoAltaPrioridad(String opcion, String lugarOrigen, String lugarDestino, String fechaIda, String horarioIda, String pasajeros, String NombreApellido, String Correo, String ValCorreo, String Numero, String CodigoVuelo) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String resultado = "";
        Thread.sleep(2000);
        Set<String> handles = driver.getWindowHandles();
        driver.findElement(By.xpath("//*[@id=\"modalReg\"]/div/div/div[1]/button/span")).click();
        driver.findElement(By.xpath("//label[@for='sbTransfers']")).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iFrame)[3]")));

            driver.findElement(By.xpath("//span[@ng-bind='labelOneWay']")).click();
            WebElement lugarVueltaOrigen = driver.findElement(By.xpath("//*[@id=\"input-pickup\"]"));


            if (validarLugarOrigen(lugarOrigen)) {
                lugarVueltaOrigen.sendKeys(lugarOrigen); //Hacer click en text
                Thread.sleep(2000);
                lugarVueltaOrigen.sendKeys(Keys.ARROW_DOWN);
                lugarVueltaOrigen.sendKeys(Keys.ENTER);
                Thread.sleep(2000);

            } else {
                resultado = "Ingrese al menos 3 letras en Lugar de Origen";
            }

            //seleccionar lugar destino
            WebElement lugarVueltaDestino = driver.findElement(By.xpath("//*[@id=\"input-dropoff\"]"));
            if (validarLugarDestino(lugarDestino)) {
                lugarVueltaDestino.sendKeys(lugarDestino);
                Thread.sleep(2000);
                lugarVueltaDestino.sendKeys(Keys.ARROW_DOWN);
                lugarVueltaDestino.sendKeys(Keys.ENTER);
                Thread.sleep(2000);
            } else {
                resultado = "Ingrese al menos 3 letras en lugar de destino";
            }
            //seleccionar fecha ida
            WebElement calendario_ida = driver.findElement(By.cssSelector("#input-pickup-date"));

            String fechaTrim = fechaIda.split(" ")[0].trim();
            int fechaSplit = Integer.parseInt(fechaTrim);

            int fechaActual = 4;
            int fechaDeseada = fechaSplit;
            while (fechaActual < fechaDeseada) {
                calendario_ida.sendKeys(Keys.ARROW_RIGHT);
                fechaActual++;
            }
            calendario_ida.sendKeys(Keys.ENTER);

            //selecciona hora de ida
            driver.findElement(By.id("ct-pickup-hour")).click();
            WebElement hora_ida = driver.findElement(By.id("ct-time-picker-pick-up-option-container"));
            hora_ida.findElement(By.xpath("//*[contains(@aria-label,'" + horarioIda + "')]")).click();

            Thread.sleep(1000);
            //driver.findElement(By.xpath("//*[@id=\"ct-container\"]")).click(); //CLICK CONTAINER SALTEAR FECHA
            Thread.sleep(1000);
            driver.findElement(By.id("passenger-number-input")).click();
            WebElement pasajerosList = driver.findElement(By.xpath("//ul[contains(@class,'ct-list-container')]"));
            pasajerosList.findElement(By.xpath("//li[contains(text(),'" + pasajeros + "')]")).click();

            driver.findElement(By.id("ct-button-search")).click();

            //SWITCH VENTANA
            //recorrer handles para ver cual ventana esta activa y trabajar ahi
            for (String handle : driver.getWindowHandles()) {
                if (!handles.contains(handle)) {
                    driver.switchTo().window(handle);
                }
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button [@class = 'ct-btn ct-btn-p '])[1]")));
            driver.findElement(By.xpath("//button [@class = 'ct-btn ct-btn-p ']")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#gt-customer-name")).sendKeys(NombreApellido);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#gt-customer-email")).sendKeys(Correo);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#gt-customer-confirm-email")).sendKeys(ValCorreo);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#gt-customer-mobile-number")).sendKeys(Numero);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#gt-pickup-flight-number")).sendKeys(CodigoVuelo);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button [@class='ctc-button ctc-button--full ctc-button--primary']")).click();
            Thread.sleep(2000);
            String confirmar = driver.findElement(By.xpath("//h3[@class='gt-header gtg-strong']")).getText();
            if (confirmar.equals("Resumen del pago")){
                resultado = "se cargaron los datos con exito";
        }
        return resultado;
    }

   @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jetsmart.com/cl/es/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void casoBajaPrioridadTest() throws InterruptedException {

        Assert.assertEquals("faltan datos por rellenar", casoBajaPrioridad("Ida","aeropuerto arturo merino benitez","llano subercaseaux 2909", "11:00 PM","1 pasajero"));

    }

    @Test
    public void casoMedioPrioridadTest() throws InterruptedException {
        Assert.assertEquals("lugar de origen erroneo",casoMedioPrioridad("Ida","9999999999999"));
    }

    @Test
    public void casoAltaPrioridadTest() throws InterruptedException {
        Assert.assertEquals("se cargaron los datos con exito",casoAltaPrioridad("Ida", "aeropuerto arturo merino benitez","llano subercaseaux 2909","6 Mayo 2021","11:00 PM","1 pasajero","Marcelo Letelier","mletelierpalomares@gmail.com","mletelierpalomares@gmail.com","964567406","AB147"));
    }

    @After
    public void close(){
        driver.quit();
    }
}