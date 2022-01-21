package week4.day1Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		  
		 */
		
     WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Enter UserNAme
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
			//Enter Password
			
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
//click Login Button
			
			driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
			//click on CRM/SFA
            driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
            //click on contacts
            driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
            driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
            
            
            driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
            Set<String> w = driver.getWindowHandles();
            List<String>list=new ArrayList<String>(w);
            driver.switchTo().window(list.get(1));
            driver.findElement(By.xpath("//a[@class='linktext']")).click();
            driver.switchTo().window(list.get(0));
            
           
            
            driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
            Set<String> w1 = driver.getWindowHandles();
            List<String>list1=new ArrayList<String>(w1);
            driver.switchTo().window(list1.get(1));
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
            driver.switchTo().window(list1.get(0));
            
            driver.findElement(By.linkText("Merge")).click();
		    driver.switchTo().alert().accept();
		    String title=driver.getTitle();
		    System.out.println(title);
		    if(title.contains("Contact"))
		    	System.out.println("Title verified");
		    else
		    	System.out.println("Title unverified");
		
		
		
		
		
		
		
	}

}
