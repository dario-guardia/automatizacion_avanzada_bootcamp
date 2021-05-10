package bctsoft.grupo4.pageobject.pages;

import bctsoft.grupo4.pageobject.base.SeleniumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class JetSmartReservaHotelPage extends SeleniumBase {
    public JetSmartReservaHotelPage(WebDriver driver) {
        super(driver);
    }
    //repositorio objetos JetSmartHomePage
    private By btnReservareHotel = By.xpath("(//button[@type='submit'])[5]");
    private By btnReservarAhoraHotel = By.id("hcta");
    private By btnConfirmarHabitaciones = By.name("nr_rooms_17475607_244937953_2_2_0");

    public void reservarHotel(){
        click(btnReservarAhoraHotel);
        System.out.println("click reservar hotel");
    }

    public void confirmarHabitaciones(String habitaciones){
        String divHabitaciones[] = habitaciones.split(" ");
        Select opcHabitacion = new Select(driver.findElement(btnConfirmarHabitaciones));
        opcHabitacion.selectByValue(divHabitaciones[0]);
        System.out.println("click habitaciones");

    }

    public void confirmarReserva(){
        click(btnReservareHotel);
        System.out.println("reserva final");
    }

    public String verificarTitulo(){
        String resultado = "";
        if((getTitle().toString()).equals("JetSmart: tus datos")){
            resultado = "Se hizo la reserva con exito";
        }
        return resultado;
    }


}
