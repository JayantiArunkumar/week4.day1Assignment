package week4.day1Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws IOException, InterruptedException {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("https://dev75371.service-now.com/navpage.do");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("gsft_main");
		//Enter userName and password and click Login
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Jayu@123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.switchTo().defaultContent();
		//Search “incident “ Filter Navigator
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		//Click “All”
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		//Click New button
		driver.findElement(By.id("sysverb_new")).click();
		driver.switchTo().defaultContent();
		//Select a value for Caller and Enter value for short_description
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']/span")).click();
		driver.switchTo().defaultContent();
		Set<String> w = driver.getWindowHandles();
		List<String>list=new ArrayList<String>(w);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.linkText("Abel Tuter")).click();
		driver.switchTo().window(list.get(0));
		
		
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//a[@id='lookup.incident.short_description']")).click();
		driver.switchTo().defaultContent();
		//driver.switchTo().parentFrame();
		Set<String> w1 = driver.getWindowHandles();
		List<String>list1=new ArrayList<String>(w1);
		driver.switchTo().window(list1.get(1));
		driver.findElement(By.linkText("Issue with email")).click();
		driver.switchTo().window(list1.get(0));
		Thread.sleep(5000);
		
		/*String ww = driver.getWindowHandle();
		driver.switchTo().window(ww);*/
		//Read the incident number and save it a variable
		driver.switchTo().frame("gsft_main");
		WebElement f = driver.findElement(By.id("incident.number"));
		String text = f.getAttribute("value");
		System.out.println(text);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[text()='Press Enter from within the input to submit the search.']/following::input[1]")).sendKeys(text,Keys.ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement f1 = driver.findElement(By.id("incident.number"));
		String text1 = f1.getAttribute("value");
		System.out.println(text1);
		driver.switchTo().defaultContent();
		
		
		//verification and snapshot
		if(text1.equals(text)) {
			System.out.println("Incident is verified");
			File source = driver.getScreenshotAs(OutputType.FILE);
			File destination=new File("./images/Incident.png");
			FileUtils.copyFile(source, destination);
			
		   
		
		}
		else
			System.out.println("Incident is unverified");
		
		
		
	}

}
