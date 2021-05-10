package bctsoft.grupo4.pageobject.pages;


import bctsoft.grupo4.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartReservaVuelosPage extends SeleniumBase {
    public JetSmartReservaVuelosPage(WebDriver driver) {
        super(driver);
    }

    //Pagina numero 2 de vuelos
    private By seleccionarPrimeraHoraIda = By.xpath("(//div[@class='fee-selector'])[1]//div[@class='smart-fee nowrap big ']");
    private By paqueteIdaLigero = By.xpath("(//button[@class='bundle-button'])[3]");
    private By seleccionarPrimeraHoraVuelta = By.xpath("(//div[@class='fee-selector'])[2]//div[@class='smart-fee nowrap big ']");
    private By paqueteVueltaLigero = By.xpath("(//button[@class='bundle-button'])[7]");
    private By btnContinuar = By.xpath("//*[@id='availabilityForm']/div[4]/button[1]");
    private By comprobarPag = By.xpath("//h2[contains(text(),'Detalles del Pasajero')]");
    private By comprobarCasoIntermedio = By.xpath("//div[@class='bundle-container ']/div[@class='bundle-footer']");
    private By btnHorarioDisponible = By.xpath("//*[@class='text-center nowrap']");


    //KeyWord Driver

    public void seleccionarHorarioDisponible() throws InterruptedException {
        Thread.sleep(2000);
        click(btnHorarioDisponible);

    }

    public void seleccionarHoraIda() throws InterruptedException {
        Thread.sleep(2000);
        click(seleccionarPrimeraHoraIda);
    }

    public void seleccionarPaqueteIdaLigero() throws InterruptedException {
        Thread.sleep(2000);
        click(paqueteIdaLigero);
    }

    public void seleccionarHoraVuelta() throws InterruptedException {
        Thread.sleep(2000);
        click(seleccionarPrimeraHoraVuelta);
    }

    public void seleccionarPaqueteVueltaLigero() throws InterruptedException {
        Thread.sleep(2000);
        click(paqueteVueltaLigero);
    }

    public void seleccionarBotonFinal() throws InterruptedException {
        Thread.sleep(2000);
        click(btnContinuar);
    }

    public boolean validarCasoIntermedio() throws InterruptedException {
        Thread.sleep(2000);
        boolean resultado = false;
        if (isDisplayed(comprobarCasoIntermedio)) {
            resultado = true;
        } else {
            resultado = false;

        }
        return resultado;
    }
}