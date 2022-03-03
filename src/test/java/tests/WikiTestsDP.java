package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class WikiTestsDP {
	
  @DataProvider (name = "Data Provider Wiki")
  public Object[][] metodoDP(){
	  return new Object[][] { {"River Plate"},{"Boca Juniors"},{"Talleres de Cordoba"} };
  }
	
  @Test(dataProvider = "Data Provider Wiki",description = "Validar Uso de DP en Wiki")
  public void ValidarUsoDataProv(String texto) throws Exception {
	  System.setProperty("webdriver.edge.driver", "D:\\Instaladores/msedgedriver.exe");
	  WebDriver driver = new EdgeDriver();
	    driver.get("http://wikipedia.org");
	    WebElement searchInput = driver.findElement(By.id("searchInput"));
	    Assert.assertTrue(searchInput.isDisplayed(), "Input no Visible");
	    
	    searchInput.sendKeys(texto);
	    searchInput.submit();
	    Thread.sleep(2000);
	    
	    WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
	    
	    Assert.assertTrue(tituloResultado.isDisplayed(), "El titulo no es visible");
	    
  }
}
