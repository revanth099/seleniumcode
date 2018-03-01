package seleniumTests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownFunc{
	WebDriver driver;
	
	public void LaunchBrowser(String url) {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		}
	public void Navigation(String strtplace, String dest) {
		try {
			LaunchBrowser("https://www.cleartrip.com");
			driver.findElement(By.xpath(".//*[@id='Home']/div/div/ul/li/div/div[2]/aside[1]/nav/ul[1]/li[4]/a")).click();
			/*WebElement enb = driver.findElement(By.id("OneWay"));
			if (enb.isSelected()) {
				System.out.println("Oneway button is selected");
					
			}
			else {
				driver.findElement(By.id("OneWay")).click();
			}*/
			driver.findElement(By.id("from_station")).sendKeys(strtplace);
			Thread.sleep(2000);
			driver.findElement(By.id("to_station")).sendKeys(dest);
			Thread.sleep(2000);
			WebElement classlist = driver.findElement(By.id("trainClass"));
			Select clist = new Select(classlist);
			clist.selectByVisibleText("AC 3 Tier (3A)");
			driver.findElement(By.xpath("//div[@id='datePickerContainer']/div[3]/table[2]/tbody/tr[2]/td[2]/a")).click();
			WebElement count= driver.findElement(By.id("train_adults"));
			Select adult=new Select(count);
			adult.selectByIndex(3);
			WebElement child=driver.findElement(By.id("train_children"));
			Select kids=new Select(child);
			kids.selectByIndex(2);
			driver.findElement(By.id("trainFormButton")).submit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
	}
	public void TrainList() {
		driver.findElement(By.id("calendarLink")).click();
		//WebElement table= driver.findElement(By.xpath(".//*[@id='ContentFrame']/div[2]/table/tbody/tr"));
		List<WebElement> rows=driver.findElements(By.tagName(".//*[@id='ContentFrame']/div[2]/table/tbody/tr"));
		for(int i=1;i<=rows.size();i++) {
			List<WebElement> cells= rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<=cells.size();j++) {
				System.out.println(cells.get(j));
				
			}
			
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DropdownFunc obj=new DropdownFunc();
		obj.Navigation("Sec", "tpty");
		obj.TrainList();

	}

}
