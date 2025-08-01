package pages;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
		}
	
	//Close the Login pop-up
	
	public void closeLoginPopup() {
		try {
			Thread.sleep(3000); // wait for modal to load
	        Actions actions = new Actions(driver);
	        actions.moveByOffset(10, 10).click().build().perform();
		}
		catch (Exception e) {
            System.out.println("Login popup not shown.");
        }
	}
	
	// Click on Trains Tab
	public void trainSections()
	{
		driver.findElement(By.xpath("(//span[text()='Trains'])[1]")).click();
		
	}
	
	// Train search section -From and To stations or locations
	
	public void searchStations(String from, String to) throws InterruptedException
	{
		 new Actions(driver).moveByOffset(10, 10).click().perform();
		 
		 //From Field
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		Thread.sleep(2000);
		
		//Input  in search 
		WebElement fromInput =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/input[@placeholder='From']")));
		fromInput.clear();
		fromInput.sendKeys(from);
		
		Thread.sleep(2000);
		//select from locations
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='autoSuggestPlugin hsw_autocomplePopup']//li[1]"))).click();
		Thread.sleep(2000);
		
		//To field 
		
		WebElement toInput =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
		toInput.clear();
		toInput.sendKeys(to);
		
		Thread.sleep(4000);
		//select to locations
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role=\"listbox\"]/li[1]"))).click();
		
	}
	
	public void selectUpcomingFriday() throws InterruptedException {
		
		
		
		driver.findElement(By.xpath("//p[@data-cy='departureDate']"));
		Thread.sleep(2000);
		WebElement fridayDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label][contains(@aria-label, 'Fri')]")));
		Thread.sleep(1000);
		fridayDate.click();	
		
	
		
	}
	
	public void selectClass(String trainClass) {
       // driver.findElement(By.xpath("//span[text()='Class']/parent::div")).click();
       // driver.findElement(By.xpath("//li[text()='" + trainClass + "']")).click();
		try {
	        // Wait for dropdown to be visible
	        WebElement classDropdown = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='appendBottom5 downArrow']"))
	        );
	        classDropdown.click();

	        // Wait for dropdown options and select
	        WebElement classOption = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='travelForPopup']/li[5]"))
	        );
	        classOption.click();

	    } catch (TimeoutException e) {
	        System.out.println("Train class dropdown or option not found. XPath might be incorrect.");
	    }
	}
    

    public void clickSearch() {
        driver.findElement(By.xpath("//a[text()='Search']")).click();
    }
	
	
	
	


}
