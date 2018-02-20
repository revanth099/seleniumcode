package methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class gmailLogin
{
	//static String url="http://gmail.com";
	static WebDriver driver;
	static String uid,pwd,result;
	

	
	public static void main(String[] args) 
	{
		result=launchApp("http://gmail.com");
		System.out.println("LaunchApp test"+result);
		result=userLogin("gopal25jyothi@gmail.com","revanthgopaljyothi");
		System.out.println("UserLogin Test "+result);
		result=userLogout();
		System.out.println("UserLogout test "+result);
		closeApp();
	}
	public static String launchApp(String url)
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		if (driver.findElement(By.id("next")).isDisplayed())
		{
			return "pass";		
		}
		else 
		{
			return "fail";

		}
		
		
	}
	public static String userLogin(String uid,String pwd)
	{
		driver.findElement(By.name("Email")).sendKeys(uid);
		driver.findElement(By.id("next")).click();
		driver.findElement(By.name("Passwd")).sendKeys(pwd);
		driver.findElement(By.id("signIn")).click();
		
		if (driver.findElement(By.partialLinkText("Inbox")).isDisplayed()) 
		{
			return "pass";
			
		}
		else
		{
			return "fail";

		}	
		
	}
	public static String userLogout()
	{
		driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		driver.findElement(By.id("gb_71")).click();
		if (driver.findElement(By.id("signIn")).isDisplayed())
		{
			return "pass";		
		}
		else 
		{
			return "fail";

		}
	}
	public static void closeApp()
	{
		driver.close();
	}
	

}
