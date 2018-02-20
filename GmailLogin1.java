package basicprog;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLogin
{

	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://gmail.com");
		//driver.findElement(By.id("Sign in")).click();
		driver.findElement(By.name("Email")).sendKeys("gopal25jyothi@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.name("Passwd")).sendKeys("revanthgopaljyothi");
		driver.findElement(By.id("signIn")).click();
		
		if (driver.findElement(By.partialLinkText("Inbox")).isDisplayed()) 
		{
			System.out.println("Gmail test passed");
			
		} else
		{
			System.out.println("Gmail test failed");

		}	
		
		driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		driver.findElement(By.id("gb_71")).click();
		driver.close();
		}

}



