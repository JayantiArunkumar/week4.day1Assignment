package week4.day1Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("http://www.leafground.com/pages/Alert.html");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        String text=alert.getText();
        System.out.println(text);
        alert.accept();
        
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
        String text1=alert.getText();
        System.out.println(text1);
        alert1.accept();
        
        
        driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
        org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
        String text2=alert.getText();
        System.out.println(text2);
        alert2.sendKeys("abc");
        alert2.accept();
        
        driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
        org.openqa.selenium.Alert alert3 = driver.switchTo().alert();
        String text3=alert3.getText();
        System.out.println(text3);
        alert2.accept();
		
        driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        
        //driver.close();
		
	}

}
