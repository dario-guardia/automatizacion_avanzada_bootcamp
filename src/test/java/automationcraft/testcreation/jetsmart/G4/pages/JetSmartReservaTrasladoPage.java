package automationcraft.testcreation.jetsmart.G4.pages;




import bctsoft.grupo4.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartReservaTrasladoPage extends SeleniumBase {
    public JetSmartReservaTrasladoPage(WebDriver driver) {
        super(driver);
    }

    private By btnReservaTraslado = By.xpath("(//button [@class = 'ct-btn ct-btn-p '])[1]");


//Keyword Driver

    public void esperaClickeablebotonTraslado() throws InterruptedException {
        esperar(5);
        click(btnReservaTraslado);
    }
}

