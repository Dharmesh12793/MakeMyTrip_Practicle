package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage extends BasePage {

	public BookingPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void addTravelerDetails() {
		
		try {
	    	 // Click "Add Traveller" button
	    	 //Thread.sleep(5000);  // Wait for the page to load
	    	WebElement addTraveller = wait.until(ExpectedConditions.elementToBeClickable(
                   By.xpath("//*[@class='bold font14 capText']")));
           addTraveller.click();
	    	 
	    	

	         Thread.sleep(2000);  // Wait for modal to appear

	         // Fill Traveller Name
	         WebElement nameInput = driver.findElement(By.xpath("//*[@class='font14 darkGreyText']"));
	         nameInput.sendKeys("John Doe");

	         // Fill Age
	         WebElement ageInput = driver.findElement(By.xpath("//input[@placeholder='Enter Age']"));
	         ageInput.sendKeys("28");

	         

	        
	      // Open the Gender dropdown
	         WebElement genderDropdown = driver.findElement(By.xpath("//div[contains(@class,'genderField')]//p"));
	         genderDropdown.click();
	         Thread.sleep(1000);  // Small wait to allow dropdown options to render

	         // Select 'Male' from the dropdown
	         List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'genderField')]//li"));
	         for (WebElement option : options) {
	             if (option.getText().equalsIgnoreCase("Male")) {
	                 option.click();
	                 break;
	             }
	         }
	         

	         // Click on ADD button
	         WebElement addButton = driver.findElement(By.xpath("//*[@class='bluePrimarybtn latoBold font16']"));
	         addButton.click();

	         System.out.println("Traveller added successfully.");

       } catch (Exception e) 
	    {
           System.out.println("Failed to add traveler details: " + e.getMessage());
           throw new RuntimeException("Traveler form not loaded or locators are incorrect.");
       }
}
		

    

    public void clickPayAndBook() {
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement payNowButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//span[text()='Pay & Book Now'])[1]")));
            payNowButton.click();
            System.out.println(" Clicked 'Pay & Book Now'");
 
           
        } catch (Exception e) {
            System.out.println(" Error clicking Pay and Book Now: " + e.getMessage());
            throw new RuntimeException("Booking button not clickable or missing.");
        }
    }

    public void captureAndPrintError() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    	try {
    		 WebElement irctcSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
    		            By.xpath("//*[contains(text(),'IRCTC') and contains(text(),'not linked')]")));
    	    System.out.println("IRCTC Section Found: " + irctcSection.getText());
    	} catch (TimeoutException e) {
    	    System.out.println("IRCTC element not found within timeout.");
    	    
    	}
    }

    public void printBookingSummary() {
    	try {
    		
    	        List<WebElement> summaryDetails = driver.findElements(
    	            By.xpath("//div[contains(@class,'fareSummary')]//p | //div[contains(@class,'booking-summary')]//p"));

    	        if (summaryDetails.isEmpty()) {
    	            System.out.println("No booking summary details found.");
    	            return;
    	        }

    	        System.out.println("Pay & Book Now Summary:");
    	        for (WebElement detail : summaryDetails) {
    	            System.out.println("• " + detail.getText());
    	        }
    	    } catch (Exception e) {
    	        System.err.println("Error reading booking summary: " + e.getMessage());
    	    }
    }
	
	
	
}
