package seleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PatymTest {
WebDriver driver;

public void InvokeBrowser(String url) {
	try {
		System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
public void GetUrl() {
	try {
		InvokeBrowser("https://paytm.com");
		driver.findElement(By.linkText("Electricity")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.id("radio0")).isSelected()) {
			driver.findElement(By.tagName("input")).sendKeys("andhrapradesh");
			Thread.sleep(2000);
			//driver.findElement(By.linkText("Log In/Sign Up")).click();		
			
		}
		else {
			System.out.println("this test scenario is failed");
			
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public static void main(String[] args) {
	PatymTest obj= new PatymTest();
	obj.GetUrl();
	

}

}

