package seleniumTests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedmiNt5Notify {
	WebDriver driver;
	
	void LaunchBrowser(String Url){
		try {
			System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(Url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void ClosePopUp() {
		try {
			LaunchBrowser("https://www.flipkart.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//body[@class='fk-modal-visible']/div[2]/div/div/button")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void MiNote5Pro(String data, String email) {
		try {
			ClosePopUp();
			driver.findElement(By.name("q")).sendKeys(data);
			driver.findElement(By.xpath("//div[@id='container']/div/header/div[1]/div/div/div/div[1]/form/div/div[2]/button")).submit();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Redmi Note 5 Pro (Black, 64 GB)")).click();
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		    //newTab.remove(oldTab);
		    // change focus to new tab
		    driver.switchTo().window(newTab.get(1));
		    Thread.sleep(2000);
			if (driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div/div/div/div[1]/div/div[2]/div[3]/div")).isDisplayed()) {
				driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div/div/div/div[1]/div/div[2]/div[4]/div/div[1]/div/input")).sendKeys(email);
				driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div/div/div/div[1]/div/div[2]/div[4]/div/div[2]/button")).click();
				if (driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div/div/div[2]")).isDisplayed()) {
					System.out.println("You ll be notified when product is avialible");
				}
				else {
					System.out.println("We cannot find the email so please re enter the correct email");
					
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		RedmiNt5Notify notify=new RedmiNt5Notify();
		notify.MiNote5Pro("Red mi note 5 pro", "revanth@test.com");
		

	}

}
