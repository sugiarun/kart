package kart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class realmeeee {
	public static void main(String[]args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Users\\5767\\eclipse-workspace\\ModelProject1\\Driver\\chromedriver.exe");
		         WebDriver driver=new ChromeDriver();
		         driver.get("http://www.flipkart.com");
		         driver.manage().window().maximize();

		         driver.findElement(By.xpath("//button[text()='✕']")).click();
				 driver.findElement( By.name("q")).sendKeys("realme mobiles",Keys.ENTER);
				 
				   File f=new File("E:\\Users\\5767\\eclipse-workspace\\kart\\src\\test\\resources\\output.xlsx");
				 
				 HSSFWorkbook w=new HSSFWorkbook();
				HSSFSheet s=w.createSheet("output");
				
				
				 List<WebElement> l=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
				 for(int i=0;i< l.size();i++) {
				 WebElement name=l.get(i);
				 String mob=name.getText();
				 HSSFRow r=s.createRow(i);
				 HSSFCell c=r.createCell(0);
				 c.setCellValue(mob);
				 FileOutputStream f1=new FileOutputStream(f);
				 w.write(f1);
				 }
				 
				 driver.findElement(By.xpath("(//div[@class='_4rR01T'])[4]")).click();
				 Set<String> parent=driver.getWindowHandles();
				 List<String>child=new ArrayList(parent);
				 driver.switchTo().window(child.get(1));
				 String realme=driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
				 s=w.createSheet("new");
				 HSSFRow r=s.createRow(0);
				 HSSFCell c=r.createCell(0);
				 c.setCellValue(realme);
				 FileOutputStream f1=new FileOutputStream(f);
				 w.write(f1);
				
				JavascriptExecutor js=(JavascriptExecutor) driver;
				WebElement krt=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww _2Fj61M']"));
				js.executeScript("arguments[0].scrollIntoView(true)", krt);
				
				
				TakesScreenshot ts=(TakesScreenshot) driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File dest=new File("E:\\Users\\5767\\eclipse-workspace\\kart\\io");
				FileUtils.copyFile(src,dest);
				Thread.sleep(2000);
				                                   
				
				 FileInputStream f2=new FileInputStream(f); 
				 HSSFWorkbook w2=new HSSFWorkbook(f2);
			     HSSFSheet s2=w.getSheet("output");
				 HSSFRow r2=s2.getRow(3);	
				 HSSFCell c2=r2.getCell(0);
				 
				 String tex=c2.getStringCellValue();
				 System.out.println(tex);
				 
				 s=w.getSheet("new");
				 HSSFRow r3=s.getRow(0);	
				 HSSFCell c3=r3.getCell(0);
				 
				 String tex1=c3.getStringCellValue();
				 System.out.println(tex1);
				 
				 if(tex.equals(tex1)) {
					 System.out.println("matched");
					 
				 }
				 else {
					 System.out.println("unmatched");
				 }
				 
				 
				 }		
				 
		}	 
				

		



