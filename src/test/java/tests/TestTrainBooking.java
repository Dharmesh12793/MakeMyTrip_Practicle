package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BookingPage;
import pages.HomePage;
import pages.TrainSearchPage;
import utils.DriverFactory;

public class TestTrainBooking {

	WebDriver driver;
    HomePage homePage;
    TrainSearchPage trainPage;
    BookingPage bookingPage;
    

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.BASE_URL);
    }

    @Test
    public void trainBookingFlow() throws InterruptedException {
        homePage = new HomePage(driver);
        trainPage = new TrainSearchPage(driver);
        bookingPage = new BookingPage(driver);

        homePage.closeLoginPopup();
        homePage.trainSections();
        homePage.searchStations(ConfigReader.FROM, ConfigReader.TO);
        homePage.selectUpcomingFriday();
        homePage.selectClass(ConfigReader.CLASS);
        homePage.clickSearch();
       //trainPage.printTrainOptions();
        trainPage.selectFirstTrainAfter9PM();
      
        

        bookingPage.addTravelerDetails();
        bookingPage.clickPayAndBook();
        bookingPage.captureAndPrintError();
        bookingPage.printBookingSummary();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
	

}
