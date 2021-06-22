package practicasFalabella.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import practicasFalabella.pageobject.base.SeleniumBase;

public class casoOrganigramaPage extends SeleniumBase {

    public casoOrganigramaPage(WebDriver driver) {
        super(driver);
    }

    private By btnCasoOrganigrama = By.xpath("//*[contains(text(),'GSCRHEC-470')]");
    private By opcInformacionEmpresa = By.xpath("//a[contains(text(),'Información de la empresa')]");



    public void clickCaso(){
        waitDisplayed(btnCasoOrganigrama,5);
        click(btnCasoOrganigrama);
        String titulo = getTitle().toString();
        if(titulo.contains("EC-470")){
            System.out.println(titulo);
        }else{
            System.out.println("no se encontro el caso");
        }
        goToUrl("https://performancemanager4.successfactors.com/login?company=adessafalaD1&username=fjmunozr@Falabella.cl#/login");
    }



    public void clickOpcOrganigrama(){
        waitDisplayed(opcInformacionEmpresa,5);
        click(opcInformacionEmpresa);
    }




}
