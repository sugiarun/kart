package kart;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class tvsN {
	static WebDriver driver;
	@BeforeClass
	public static void launch() {
		System.out.println("B.launch");
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
	}
	@AfterClass
	public static void quit() {
		System.out.println("Quit");
		driver.quit();
	}
	long StartTime;
	@Before
	public void bmethod() {
		System.out.println("Bmethod");
		StartTime=System.currentTimeMillis();
		
	}
	@After
	public void Amethod() {
		System.out.println("amethod");
		long EndTime=System.currentTimeMillis();
		System.out.println("Timetaken:"+(EndTime-StartTime));
	}
	@Test
	public void method1() {
		System.out.println("login");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}
	@Test
	public void method2() {
		System.out.println("samsaungtv");
		
	 driver.findElement( By.name("q")).sendKeys("samasung tv",Keys.ENTER);
	WebElement name=driver.findElement(By.xpath("(//div[@class='_4rR01T'])"));
	 String mob=name.getText();
	 System.out.println("tv name is:+fn");
	 
	}
	@Test
	public void method3() {
		System.out.println("whandle");
		Set<String> parent=driver.getWindowHandles();
		 List<String>child=new ArrayList(parent);
		 for(String x:child) {
			 if(!x.equals(parent)) {
				 driver.switchTo().window(x);
			 }
		 }
	}
	@Ignore
	public void method4() {
		System.out.println("kart");
	}

}



	



