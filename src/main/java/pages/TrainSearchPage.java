package pages;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainSearchPage extends BasePage {

    public TrainSearchPage(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);

    public void searchTrainForUpcomingFriday() {
        try {
        	/*
        	
            // From Station (use actual visible input or placeholder)
            WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@placeholder,'From')]")));
            fromInput.clear();
            fromInput.sendKeys("Vadodara");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(.,'Vadodara')]"))).click();

            // To Station
            WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@placeholder,'To')]")));
            toInput.clear();
            toInput.sendKeys("Surat");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(.,'Surat')]"))).click();
            
            
            

            // Journey Date: Upcoming Friday
            WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@placeholder,'Travel Date')]")));
            dateInput.click();
            
            LocalDate today = LocalDate.now();
            LocalDate friday = today.plusDays(7);
            while (friday.getDayOfWeek().getValue() != 5) { // 5 = Friday
                friday = friday.plusDays(1);
            }

            // Format it to 'yyyy-MM-dd' (assumes this is what the calendar uses)
            String formattedDate = friday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Wait and click the date cell
            WebElement dateCell = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//td[@data-date='" + formattedDate + "']")));
            dateCell.click();
            
            


            // Class: First AC
            WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Class')]")));
            classDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'First AC')]"))).click();

            // Click Search
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Search')]")));
            searchButton.click();
            
           */ 

        } catch (Exception e) {
            System.out.println("Error during train search input: " + e.getMessage());
        }
    }

    private LocalDate getUpcomingFriday() {
		return null;
    	
	}

	public void selectFirstTrainAfter9PM() {
        try {
            List<WebElement> trainCards = wait.until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(By.cssSelector("div[data-testid='listing-card']")));

            for (WebElement card : trainCards) {
                try {
                    String timeRaw = card.findElement(By.cssSelector("span[class*='ListingCard_timeText']")).getText().trim();
                    String time = timeRaw.replaceAll("[^0-9a-zA-Z: ]", "").trim();
                    LocalTime departure = LocalTime.parse(time, timeFormatter);

                    if (departure.isAfter(LocalTime.of(21, 0))) {
                        String trainName = card.findElement(By.cssSelector("p[data-testid='train-name']")).getText();
                        System.out.println("Selected Train: " + trainName + " | Departure: " + time);

                        // safer: click entire card
                        wait.until(ExpectedConditions.elementToBeClickable(card)).click();

                        // optionally wait for the traveler form
                        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passengerName")));
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Skipped train card: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Failed filtering trains: " + e.getMessage());
        }
    }
	
}


