package VDM;



import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
			  System.out.println("i Can't Find!");
		  } 
		   
		  Thread.sleep(2000);
		  
		  open_writebook();
		  
	}
	public void open_writebook() throws InterruptedException
	{
		  WebDriverWait wait = new WebDriverWait(d, 10);
		  WebElement elem1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o_list_buttons']/child::button[1]")));
		  
		  if (elem1.isDisplayed())
		  {
			  Actions a = new Actions (d);
			  a.moveToElement(elem1).click(elem1).build().perform();
			  System.out.println("Writebook is opened");
		 }
		  else
		  {
			  System.out.println("Fail");  
		  }
		  
		  create_writebook();
   }
	
public void create_writebook() throws StaleElementReferenceException, InterruptedException
{
	WebDriverWait create = new WebDriverWait(d, 10);
	WebElement ele = create.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='o_address_format']/child::select[@name='car_type']")));
	
	Select s1 = new  Select(ele);
	
	if(ele.isDisplayed())
	{
		s1.selectByIndex(0);
	}
	
	d.findElement(By.name("fname")).sendKeys("MS");
	d.findElement(By.name("lname")).sendKeys("Dhoni");
	d.findElement(By.name("vin_number")).sendKeys("JTMDFREV1ED050527",Keys.ENTER);
	
	WebDriverWait create1 = new WebDriverWait(d, 10);
	WebElement ele1 = create1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='o_address_format']/child::select[@name='sale_person']")));
	
	Select s2 = new Select(ele1);
	
	if(ele1.isDisplayed())
	{
		s2.selectByIndex(0);
	}	
	
	JavascriptExecutor jse = (JavascriptExecutor)d;
	jse.executeScript("window.scrollBy(0,-500)");
	
	WebElement save = d.findElement(By.xpath("//div[@class='o_form_buttons_edit']/child::button[1]"));
	save.click();
	
	Thread.sleep(2000);
	
	WebElement alert = d.findElement(By.xpath("//span[@name='header_message1']"));
	String message = alert.getText();
	if(alert.isDisplayed())
	{
		Thread.sleep(4000);
		System.out.println(message);
	}	
	
	//changing the status---> locate
	
	 WebDriverWait wait = new WebDriverWait(d, 10);
     WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o_form_buttons_view']/child::button[@class='btn btn-primary o_form_button_edit']")));

    Actions b = new Actions (d);
    b.moveToElement(edit).click(edit).build().perform(); 
    
    WebDriverWait status = new WebDriverWait(d, 10);
	WebElement status1 = status.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='o_address_format']/child::select[@name='demo_stage']")));
	
    Select s3 = new Select(status1);
    if(status1.isDisplayed())
	{
		s3.selectByIndex(2);
	}	
    
	save.click();
	
	Thread.sleep(2000);
	
	WebElement alert1 = d.findElement(By.xpath("//span[@name='header_message1']"));
	String message1 = alert1.getText();
	if(alert1.isDisplayed())

	{
		Thread.sleep(4000);
		System.out.println(message1);
		
	}
	//changing the status---> incoming
	
	 WebDriverWait wait1 = new WebDriverWait(d, 10);
     WebElement edit1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o_form_buttons_view']/child::button[@class='btn btn-primary o_form_button_edit']")));

    Actions c = new Actions (d);
    c.moveToElement(edit1).click(edit1).build().perform(); 
    
    WebDriverWait status2 = new WebDriverWait(d, 10);
	WebElement status3 = status2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='o_address_format']/child::select[@name='demo_stage']")));
	
    Select s4 = new Select(status3);
    if(status3.isDisplayed())
	{
		s4.selectByIndex(3);
	}	
    
	save.click();
	
	Thread.sleep(2000);
	
	WebElement alert2 = d.findElement(By.xpath("//span[@name='header_message1']"));
	String message2 = alert2.getText();
	if(alert2.isDisplayed())

	{
		Thread.sleep(4000);
		System.out.println(message2);
		
	}
	//changing the status---> Factory order
	
	 WebDriverWait wait2 = new WebDriverWait(d, 10);
    WebElement edit2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o_form_buttons_view']/child::button[@class='btn btn-primary o_form_button_edit']")));

   Actions d1 = new Actions (d);
   d1.moveToElement(edit1).click(edit1).build().perform(); 
   
   WebDriverWait status4 = new WebDriverWait(d, 10);
	WebElement status5 = status4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='o_address_format']/child::select[@name='demo_stage']")));
	
   Select s5 = new Select(status5);
   if(status5.isDisplayed())
	{
		s5.selectByIndex(4);
	}	
   
	save.click();
	
	Thread.sleep(2000);
	
	WebElement alert3 = d.findElement(By.xpath("//span[@name='header_message1']"));
	String message3 = alert3.getText();
	if(alert3.isDisplayed())

	{
		Thread.sleep(4000);
		System.out.println(message3);
		
	}
	//changing the status---> locate secured  
	
	    WebDriverWait wait3 = new WebDriverWait(d, 10);
	    WebElement edit3 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o_form_buttons_view']/child::button[@class='btn btn-primary o_form_button_edit']")));

	   Actions e = new Actions (d);
	   e.moveToElement(edit1).click(edit1).build().perform(); 
	   
	   WebDriverWait status6 = new WebDriverWait(d, 10);
		WebElement status7 = status6.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='o_address_format']/child::select[@name='demo_stage']")));
		
	   Select s6 = new Select(status7);
	   if(status7.isDisplayed())
		{
			s6.selectByIndex(5);
		}	
	   
		
		Thread.sleep(2000);
		
		save.click();
		
		WebElement alert4 = d.findElement(By.xpath("//span[@name='header_message1']"));
		String message4 = alert4.getText();
		if(alert4.isDisplayed())

		{
			Thread.sleep(4000);
			System.out.println(message4);
		}   
		
		
		
}
}
