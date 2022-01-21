package week4.day1Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("http://www.leafground.com/pages/Window.html");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("home")).click();
		Set<String> w = driver.getWindowHandles();
		List<String>list=new ArrayList<String>(w);
		driver.switchTo().window(list.get(1));
		driver.switchTo().window(list.get(0));
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> w1 = driver.getWindowHandles();
		List<String>list1=new ArrayList<String>(w1);
		driver.switchTo().window(list1.get(1));
		driver.switchTo().window(list1.get(0));
		
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> w2 = driver.getWindowHandles();
		List<String>list2=new ArrayList<String>(w2);
		driver.switchTo().window(list2.get(1));
		driver.close();
		driver.switchTo().window(list2.get(0));
		
		
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);
		Set<String> w3 = driver.getWindowHandles();
		List<String>list3=new ArrayList<String>(w3);
		driver.switchTo().window(list3.get(1));
		driver.switchTo().window(list3.get(2));
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
	}

}
