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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ReservaVuelos {


    WebDriver driver;

    //constructor
    public ReservaVuelos() {
        //this.driver = new ChromeDriver();
    }


    public String casoBajaPrioridad(String lugarOrigen) throws InterruptedException {
        String resultado = "";
        //Cerrar cartel
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@aria-label='Close'])[4]")).click();
        Thread.sleep(2000);
        //seleccionar lugar origen
        WebElement lugarVueloOrigen = driver.findElement(By.xpath("//input[@placeholder='Origen']"));
        lugarVueloOrigen.click(); //Hacer click en text
        lugarVueloOrigen.sendKeys(lugarOrigen);
        Thread.sleep(2000);
        resultado = (driver.findElement(By.xpath("//label[contains(text(),'No hay resultados.')]")).getText());
        return resultado;
    }


    public boolean casoMediaPrioridad(String lugarOrigen, String lugarDestino, String fechaIda, String adultos) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String resultado = "";
        //Cerrar cartel
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@aria-label='Close'])[4]")).click();
        Thread.sleep(2000);
        //SELECCIONAR CHECK IDA
        WebElement seleccionarCheckIda = driver.findElement(By.xpath("//label[@for='sbOneWayJourney']"));
        seleccionarCheckIda.click();
        Thread.sleep(2000);
        //seleccionar lugar origen
        WebElement lugarVueloOrigen = driver.findElement(By.xpath("//input[@placeholder='Origen']"));
        lugarVueloOrigen.click(); //Hacer click en text
        lugarVueloOrigen.sendKeys(lugarOrigen);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@data-citycode='SCL'])[2]")).click();
        //seleccionar lugar destino
        WebElement lugarVueloDestino = driver.findElement(By.xpath("//input[@placeholder = 'Destino']"));
        lugarVueloDestino.click();
        lugarVueloDestino.sendKeys(lugarDestino);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@data-citycode='IQQ'])[2]")).click();
        //CARGAR FECHAS DE IDA
        String fechaIdaSplit[] = fechaIda.split(" ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div//span[@aria-label='" + fechaIda + "'])[1]")).click();
        Thread.sleep(2000);
        //click textbox adulto
        driver.findElement(By.xpath("//input[@value='1 Adulto']")).click();
        Thread.sleep(2000);
        //click en el boton Smart
        driver.findElement(By.id("rt_button")).click();
        //Click en el boton disponible de horario (Dinero)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='text-center nowrap']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bundle-container ']/div[@class='bundle-footer']")));
        boolean resultadofinal = false;
        if (driver.findElement(By.xpath("//div[@class='bundle-container ']/div[@class='bundle-footer']")).isDisplayed()) {
            resultadofinal = true;
        } else {
            resultadofinal = false;
        }
        return resultadofinal;
    }

    public boolean casoAltaPrioridad(String lugarOrigen, String lugarDestino, String fechaIda, String fechaVuelta, String adultos) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String resultado = "";
        //Cerrar cartel
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@aria-label='Close'])[4]")).click();
        Thread.sleep(2000);
        //seleccionar lugar origen
        WebElement lugarVueloOrigen = driver.findElement(By.xpath("//input[@placeholder='Origen']"));
        lugarVueloOrigen.click(); //Hacer click en text
        lugarVueloOrigen.sendKeys(lugarOrigen);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@data-citycode='SCL'])[2]")).click();
        //seleccionar lugar destino
        Thread.sleep(2000);
        WebElement lugarVueloDestino = driver.findElement(By.xpath("//input[@placeholder = 'Destino']"));
        lugarVueloDestino.click();
        lugarVueloDestino.sendKeys(lugarDestino);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@data-citycode='IQQ'])[2]")).click();
        //CARGAR FECHAS DE IDA Y VUELTA
        Thread.sleep(2000);
        String fechaIdaSplit[] = fechaIda.split(" ");
        driver.findElement(By.xpath("(//div//span[@aria-label='" + fechaIda + "'])[1]")).click();
        Thread.sleep(2000);
        String fechaVueltaSplit[] = fechaVuelta.split(" ");
        //driver.findElement(By.xpath("(//div//span[@aria-label='" + fechaVuelta + "'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div//span[@aria-label='" + fechaVuelta + "'])[4]")).click();
        Thread.sleep(1000);
        //click textbox adulto
        driver.findElement(By.xpath("//input[@value='1 Adulto']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("rt_button")).click();
        //selecciona primera hora opcion
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='fee-selector'])[1]//div[@class='smart-fee nowrap big ']")));
        driver.findElement(By.xpath("(//div[@class='fee-selector'])[1]//div[@class='smart-fee nowrap big ']")).click();
        //selecciona paquete
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='bundle-button'])[3]")));
        driver.findElement(By.xpath("(//button[@class='bundle-button'])[3]")).click();
        Thread.sleep(2000);
        //selecciona primera opcion VUELTA
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='fee-selector'])[2]//div[@class='smart-fee nowrap big ']")));
        driver.findElement(By.xpath("(//div[@class='fee-selector'])[2]//div[@class='smart-fee nowrap big ']")).click();
        //selecciona paquete VUELTA
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='bundle-button'])[7]")));
        driver.findElement(By.xpath("(//button[@class='bundle-button'])[7]")).click();
        //Seleccionar boton CONTINUAR
        driver.findElement(By.xpath("//*[@id='availabilityForm']/div[4]/button[1]")).click();
        //Validar ultimo paso
        driver.findElement(By.xpath("//h2[contains(text(),'Detalles del Pasajero')]"));
        boolean resultadofinal = false;
        if (driver.findElement(By.xpath("//h2[contains(text(),'Detalles del Pasajero')]")).isDisplayed()) {
            resultadofinal = true;
        } else {
            resultadofinal = false;
        }
        return resultadofinal;
    }
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jetsmart.com/cl/es/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void casoBajoPrioridadTest() throws InterruptedException {
        Assert.assertEquals("No hay resultados.", casoBajaPrioridad("Inglaterra"));
    }
    @Test
    public void casoMediaPrioridadTest() throws InterruptedException {
        Assert.assertTrue("Se encontro paquete de IDA", casoMediaPrioridad("SCL", "IQQ", "Junio 9, 2021", "1"));
    }
    @Test
    public void casoAltaPrioridadTest() throws InterruptedException {
        Assert.assertTrue("Se encontro paquetes de IDA y VUELTA", casoAltaPrioridad("SCL", "IQQ", "Mayo 9, 2021", "Junio 1, 2021", "1"));
    }
    @After
    public void after() {
        driver.quit();
    }
}


