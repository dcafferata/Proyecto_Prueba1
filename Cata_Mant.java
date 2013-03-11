package Login;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cata_Mant{

  WebDriver driver = null;
  
  @Before
  public void setUp() throws Exception {
  
  	driver = new FirefoxDriver();
  	driver.get("http://localhost:8780/konakartadmin/#kk_panel_welcome");
  }

  @After
  public void tearDown() throws Exception {
  	driver.quit();
  	
  }
  
  private void waitForElement(String elemento, int tiempo){
  	final By by = By.xpath(elemento);
  	org.openqa.selenium.support.ui.Wait<WebDriver> wait2 = new WebDriverWait(driver,tiempo);
  	wait2.until(new ExpectedCondition<WebElement>() {
  		public WebElement apply(WebDriver driver){
  			WebElement element = driver.findElement(by);
  			return element.isDisplayed() ? element:null;
  		}
  	});
  	
  }
  @Test
  public void test() {

  	String txtFieldUserName = "//html/body/div[3]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td[2]/input";
  	String txtFieldPassWord = "//html/body/div[3]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[4]/td[2]/input";
  	String btnLogin = "//html/body/div[3]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[5]/td/table/tbody/tr/td/button";
  	
  	
  	//Definicion de credenciales
  	String user = "cat@konakart.com";
  	String pass = "princess";
  	String valorMessage = "Enterprise Extensions Only";
  	String valorDesc = "This feature is only available in the Enterprise Extensions version";
  	
  	waitForElement (txtFieldUserName, 35);
  			
  	
  	//Llenando los campos de texto;
  	//Definir los elementos web;
  	WebElement userName = driver.findElement(By.xpath(txtFieldUserName));
  	WebElement passWord = driver.findElement(By.xpath(txtFieldPassWord));
  	WebElement login = driver.findElement(By.xpath(btnLogin));
  	
  	
  	//Realizando acciones envio d caracteres y d comandos;
  	userName.sendKeys(user);
  	passWord.sendKeys(pass);
  	login.click();
  	
  	String products = "//html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div";
  	waitForElement (products, 35);
  	//String link = "//html/body/div[2]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td";
  	//waitForElement (link, 35);
  	
  	String btnMisc = "//html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td/table/tbody/tr/td/div/button[7]";
  	WebElement misc = driver.findElement(By.xpath(btnMisc));
  	
  	misc.click();
  	String eEO = "//html/body/div[3]/div/table/tbody/tr/td[2]/div/div";
  	waitForElement (eEO, 13);
  	
  	String lblEnterMessage = "//html/body/div[3]/div/table/tbody/tr/td[2]/div/div";
  	String lblEnterDesc = "//html/body/div[3]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div";
  	//String lblEnterLogo = "/html/body/div[3]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/img";
  	//String lblEnterButt = "/html/body/div[3]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td/table/tbody/tr[2]/td/button";
  	
  	WebElement enterMessage = driver.findElement(By.xpath(lblEnterMessage));
  	WebElement enterDesc = driver.findElement(By.xpath(lblEnterDesc));
  	//WebElement enterLogo = driver.findElement(By.xpath(lblEnterLogo));
  	//WebElement enterButt = driver.findElement(By.xpath(lblEnterButt));
  	
  	String okEnterMessage = enterMessage.getText();
  	String okEnterDesc = enterDesc.getText();
  	//String OkEnterLogo = enterLogo.getText();
  	//String OkEnterButt = enterButt.getText();
  	
  	assertEquals(valorMessage, okEnterMessage);
  	assertEquals(valorDesc, okEnterDesc);
  	
  	//String lblFailedMessage = "/html/body/div[3]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td/div";
  	//WebElement failedMessage = driver.findElement(By.xpath(lblFailedMessage));
  	
  	//String mensajeError = failedMessage.getText();
  
  	
  	//assertEquals(valorEsperado, mensajeError);
  }

}
