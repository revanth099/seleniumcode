package seleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApsdclElecBill {
	static WebDriver driver;
	
	static void LaunchBrowser(String url) {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
			driver =new ChromeDriver();
			//System.setProperty("webdriver.gecko.driver","C:\\selenium jar file\\geckodriver\\geckodriver.exe");
			//driver =new FirefoxDriver();
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			driver.get(url);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	static void NavtoApsdcl(String value1) {
		try {
			LaunchBrowser("https://www.google.com");
			driver.findElement(By.id("sb_ifc0")).sendKeys(value1);
			driver.findElement(By.xpath(".//*[@name='btnK']")).submit();
			Thread.sleep(2000);
			driver.findElement(By.linkText("APSPDCL - BillDesk")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void GetDetails(String serviceno) {
		try {
			NavtoApsdcl("apsdcl");
			driver.findElement(By.id("txtCustomerID")).sendKeys(serviceno);
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@name='btn2']")).submit();
			String payment =driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/table/tbody/tr[7]/td[2]")).getText();
			if (payment == "0.0") {
				System.out.println("You have no current demand at pesent");
				
			}
			else {
				System.out.println("You have the current demand of" + payment);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApsdclElecBill obj= new ApsdclElecBill();
		ApsdclElecBill.GetDetails("5522309000103");

	}

}
