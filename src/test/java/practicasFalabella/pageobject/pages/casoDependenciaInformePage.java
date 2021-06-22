package practicasFalabella.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import practicasFalabella.pageobject.base.SeleniumBase;

public class casoDependenciaInformePage extends SeleniumBase {

    public casoDependenciaInformePage(WebDriver driver) {
        super(driver);
    }

    private By btn4671 = By.xpath("//*[contains(text(),'GSCRHEC-4671')]");
    private By opcInformes = By.xpath("//a[contains(text(),'Informes')]");
    private By btnTodosInformes = By.xpath("(//*[contains(text(),'Todos los informes')])[2]");
    private By txtBuscar = By.xpath("//*[@placeholder='Buscar']");
    private By btnInformeDependencia = By.xpath("//*[contains(text(),'Dependencia de colaboradores v2')]");
    private By filtroEmpresa = By.xpath("//*[@id=\"tblRunTimeFilterData\"]/tbody/tr[2]/td[3]/span");
    private By iFrameFiltros = By.id("2_");
    private By iFrameEmpresa = By.xpath("//*[@src='SfMandatoryPromptEditor.aspx']");
    private By labelCodigoEmpresa = By.xpath("//*[@id=\"infohrm_widget_TreeNode_1\"]/div[1]/div/div/div/div/span");
    private By txtCodigoEmpresa = By.xpath("//*[@id=\"infohrm_widget_RuiInputText_0\"]");
    private By btnSeleccionar = By.xpath("//*[@id=\"infohrm_widget_RuiButton_Standard_1\"]");
    private By btnAceptar = By.xpath("//*[@id=\"infohrm_widget_RuiButton_Standard_2\"]");


    public void click4671(){
        waitDisplayed(btn4671, 5);
        click(btn4671);
    }

    public void seleccionarInformes(){
        waitDisplayed(opcInformes, 5);
        click(opcInformes);
    }

    public void opcTodosInformes(){
        waitDisplayed(btnTodosInformes,5);
        click(btnTodosInformes);
    }

    public void buscarInforme(String busqueda){
        waitDisplayed(txtBuscar,5);
        click(txtBuscar);
        type(busqueda, txtBuscar);
        sendKey(Keys.ENTER, txtBuscar);
    }

    public void clickDependenciaV2() throws InterruptedException {
        Thread.sleep(3000);
        waitDisplayed(btnInformeDependencia,20);
        click(btnInformeDependencia);
        System.out.println("click dependencia");
    }

    public void filtrarEmpresa(){
       switchFrameId("reportIframe");
       System.out.println("switch frame");
        waitFrame(20, iFrameFiltros);
        System.out.println("switch frame 2");
        waitFrame(20, iFrameEmpresa);
        System.out.println("switch frame 3");
        waitDisplayed(filtroEmpresa,30);
        click(filtroEmpresa);
        System.out.println("click filtro");
    }

    public void insertarCodigoEmpresa(String codigo){
        esperar(5);
        System.out.println("espero");
        switchFrame(1);
       // switchFrameId("2_");
        //waitFrame(20, iFrameFiltros);
        System.out.println("switch frame 2");
        waitDisplayed(labelCodigoEmpresa,5);
        click(labelCodigoEmpresa);
        System.out.println("click label");
        waitDisplayed(txtCodigoEmpresa,5);
        type(codigo, txtCodigoEmpresa);
        click(btnSeleccionar);
        click(btnAceptar);
    }

}
