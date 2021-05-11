package bctsoft.grupo4.pageobject.pages;


import bctsoft.grupo4.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class JetSmartReservaTrasladoPage extends SeleniumBase {
    public JetSmartReservaTrasladoPage(WebDriver driver) {
        super(driver);
    }

    private By btnReservaTraslado = By.xpath("//*[@id=\"ct-container\"]/div/div[2]/div[2]/div[3]/ul/li[2]/div/div[1]/div[4]/div/button");


//Keyword Driver

    public void esperaClickeablebotonTraslado() throws InterruptedException {
        Thread.sleep(5000);
        click(btnReservaTraslado);
    }
}


