package UItest;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class UIdriver {
	
	public static WebDriver driver;


	public static void main(String[] args) {
		
		driverConfig();
		
		navigate();
		
		searchFunction();
		
		

	}
	
	public static void driverConfig() {
		
		System.setProperty("webdriver.chrome.driver","C:\\auto_setup\\chromedriver_win32\\85.0.4183.102\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	public static void navigate() {
		
		driver.navigate().to(investectUItest.InvesttecURL);
		driver.manage().window().maximize();
		

	}
	
	public static void searchFunction() {
		
		
		try {
			
		driver.findElement(By.xpath(investectUItest.Search_Icon)).click();
		
		
			Thread.sleep(100);
			
		
	    driver.findElement(By.xpath("//*[@id='s-header']/div[3]")).click();
			
		driver.findElement(By.xpath(investectUItest.Search_field)).click();
		driver.findElement(By.xpath(investectUItest.Search_field)).sendKeys(investectUItest.Search_Word);
		driver.findElement(By.xpath(investectUItest.Search_field)).sendKeys(Keys.ENTER);
		
		Thread.sleep(100);
		
		List<WebElement> textClick = driver.findElements(By.xpath(investectUItest.GetToPage));
		
		textClick.get(0).click();
		
		Thread.sleep(100);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		}
	
	public static void register() {
		
		try {
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
			
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(investectUItest.SignUp)) );
		
		driver.findElement(By.xpath(investectUItest.SignUp)).click();
		
		driver.findElement(By.xpath(investectUItest.Name)).sendKeys("Koena");
		
		driver.findElement(By.xpath(investectUItest.SignUp)).sendKeys("maphakela");
		
		driver.findElement(By.xpath(investectUItest.Email)).sendKeys("test@investec.com");
		
		driver.findElement(By.xpath(investectUItest.MyselfBox)).click();
		
		driver.findElement(By.xpath(investectUItest.Submit)).click();
		
		
			Thread.sleep(100);

		
		if(driver.findElement(By.xpath(investectUItest.testPF)).isDisplayed())
			JOptionPane.showMessageDialog(null,"Test case: Pass"); 
		
		
		driver.quit();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
