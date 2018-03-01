package seleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkartselect {
	WebDriver driver;
	
	public void BrowserLaunch(String url) {
		System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);		
	}
	public void Navigation(String uid, String pwd) {
		BrowserLaunch("https://www.flipkart.com/");
		//driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div/div/div/div[2]/div[1]/a")).click();
		driver.findElement(By.xpath("//div[@class='mCRfo9']/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(uid);
		driver.findElement(By.xpath("//div[@class='mCRfo9']/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(pwd);
		driver.findElement(By.xpath("//div[@class='mCRfo9']/div/div/div/div/div[2]/div/form/div[3]/button")).submit();
		if (driver.findElement(By.xpath("//div[@class='mCRfo9']/div/div/div/div/div[2]/div/form/div[1]/span[@class='ZAtlA-']/span")).isDisplayed()) {
			System.out.println("test pass");
		}
		else {
			System.out.println("test fail");
		}
	}

	public static void main(String[] args) {
		Flipkartselect test=new Flipkartselect();
		test.Navigation("revanth@gmail.com","revanth");
		

	}

}
