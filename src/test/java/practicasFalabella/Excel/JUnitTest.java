package practicasFalabella.Excel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class JUnitTest {

    private WebDriver driver;
    private WriteExcelFile writeFile;
    private ReadExcelFile readFile;
    private By txtBusqueda = By.id("search_query_top");
    private By btnBusqueda = By.name("submit_search");
    private By resultTextLocator = By.cssSelector("span.heading-counter");

    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        writeFile = new WriteExcelFile();
        readFile = new ReadExcelFile();
        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void test() throws IOException {
        String filePath = "C:\\Users\\dario.guardia\\Desktop\\Test.xlsx";
        String searchText = readFile.getCellValue(filePath,"Hoja1",0,0);

        driver.findElement(txtBusqueda).sendKeys(searchText);
        driver.findElement(btnBusqueda).click();

        String resultText = driver.findElement(resultTextLocator).getText();
        System.out.println("Page result text: " +resultText);

        readFile.readExcel(filePath,"Hoja1");
        writeFile.writeCellValue(filePath,"Hoja1",0,1,resultText);

        readFile.readExcel(filePath,"Hoja1");


    }


}
