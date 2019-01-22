package VDM;



import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class login{
	
	WebDriver d;
	
	public static void main(String[] args) throws InterruptedException 
	{
		login obj = new login();
		obj.Run();
		
	}
	

	public void Run() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Chrome driver\\chromedriver.exe");
        d = new ChromeDriver();
        d.get("http://dev.dlrflow.io/web/login");
        d.manage().window().maximize();
        Thread.sleep(2000);
        Get_Login();
        
	}
	
	public void Get_Login() throws InterruptedException
	{
		   Thread.sleep(2000);
	       d.findElement(By.name("login")).sendKeys("sales@dlrflow.io");
		   Thread.sleep(2000);
		   d.findElement(By.id("password")).sendKeys("admin");
		   Thread.sleep(2000);
		   d.findElement(By.xpath("//button[@type='submit']")).click();
		   Open_VDM();

	} 
	
	public void Open_VDM() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(d, 10);
		  WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='dropdown-item o_app active']/child::img"))) ;
		  
		  if(elem.isDisplayed())
		  {
			  Actions a = new Actions (d);
			  a.moveToElement(elem).click(elem).build().perform();
			  System.out.println("Sucessfull!");
			 
		  }	  
		  else
		  {
			  System.out.println("Can't Find!");
		  } 
		  
		  Thread.sleep(2000);
		  
		  open_writebook();
		  
	}
	public void open_writebook()
	{
		  WebDriverWait wait = new WebDriverWait(d, 10);
		  WebElement elem1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o_list_buttons']/child::button[1]")));
		  
		  if (elem1.isDisplayed())
		  {
			  Actions a = new Actions (d);
			  a.moveToElement(elem1).click(elem1).build().perform();
			  System.out.println("Writebook is created");
		 }
		  else
		  {
			  System.out.println("Fail");  
		  }
   }
	
}
