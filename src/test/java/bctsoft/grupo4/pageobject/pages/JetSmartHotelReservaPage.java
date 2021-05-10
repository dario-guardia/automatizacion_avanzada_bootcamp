package bctsoft.grupo4.pageobject.pages;

import jetsmart_exercises_grupo4.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartHotelReservaPage extends SeleniumBase {

    public JetSmartHotelReservaPage(WebDriver driver) {
        super(driver);
    }

    private By SelecNumHabitacionesHotel = By.id("no_rooms");
    private By btn5Estrellas = By.xpath("//*[@id=\"filter_class\"]/div[2]/a[4]/label/div");
    private By btnSheraton = By.xpath("//a[@data-click-store-id='sr-compset-174756']");


    public void cambiarVentana() throws InterruptedException{
        switchVentana(1);
        Thread.sleep(5000);
    }

    public String verificarHabitaciones(String habitaciones){
        String verificarHabitacion = findElement(SelecNumHabitacionesHotel).getText();
        String resultado = "";
        if(!(verificarHabitacion.equals(habitaciones))){
            resultado = "No hay "+habitaciones+" disponibles";
        }else{
            resultado = "Se encontraron habitaciones";
        }
        return resultado;
    }

    public void filtrar5Estrellas() throws InterruptedException{
        Thread.sleep(7000);
        click(btn5Estrellas);
        System.out.println("se hizo click");
        esperar(10);
        Thread.sleep(7000);
    }

    public void clickSheraton()throws InterruptedException{
      click(btnSheraton);
      Thread.sleep(5000);
        System.out.println("click sheraton");
    }






}
