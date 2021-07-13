package tests;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomeHotelsPage;
import utils.UtilMethods;

public class HomeHotelsTest extends TestBase {

	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	HomeHotelsPage homeHotel;
	UtilMethods util;
	TestBase b = new TestBase();

	public HomeHotelsTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {

		initialiseDriver();
		homeHotel = new HomeHotelsPage();
		util =new UtilMethods();
		log.info("Initialization of driver done");

	}

	@Test
	public void navigateHomeHotelUiTC1() {
		homeHotel.getHotelsHeaderButton().click();
		System.out.println("On Home hotels page ");
		util.printSample();
	}

	@Test
	public void fillDetailsTC2() throws InterruptedException {
		homeHotel.getHotelsDestination().click();
		homeHotel.getHotelsDestination().sendKeys("ind");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfAllElements(homeHotel.getDropElements()));
		homeHotel.getHotelsDestination().sendKeys(Keys.DOWN);
		// homeHotel.getHotelsDestination().sendKeys(Keys.DOWN);
		homeHotel.getHotelsDestination().sendKeys(Keys.ENTER);
		// Select check in date
		
		/*String date = "05/12/2021";
		// month[CLicking in center]
		WebElement center = driver.findElement(By.xpath("//*[@id='datepickers-container']//div[1]//nav//div[2]"));
		System.out.println(center.getText());
		String date_dd_MM_yyyy[] = dateTime.split("/");
		System.out.println(date_dd_MM_yyyy.length);
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(yearDiff);*/
		WebElement prev = driver.findElement(By.xpath("//*[@id='datepickers-container']/child::div[1]/nav/child::div[@data-action='prev']"));
		String date = "05/12/2021";
		Thread.sleep(5000);
		homeHotel.getHotelsCheckIn().click();
		WebElement next = driver.findElement(By.xpath("//*[@id='datepickers-container']/child::div[1]/nav/child::div[@data-action='next']"));
		WebElement middle = homeHotel.getMiddle();
		util.getDate(date, middle, next, prev);
		/*center.click();
		WebElement next = driver.findElement(By.xpath("//*[@id='datepickers-container']/child::div[1]/nav/child::div[@data-action='next']"));
		if (yearDiff != 0) {
			// if you have to move next year
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					System.out.println("Year Diff->" + i);
					next.click();
				}
			}
			// if you have to move previous year
			else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					System.out.println("Year Diff->" + i);
					prev.click();
				}
			}
		}
		// Get all months from calendar to select correct one
		List<WebElement> list_AllMonthToBook = driver
				.findElements(By.xpath("//*[starts-with(@class, 'datepicker--cell datepicker--cell-month')]"));
		System.out.println(list_AllMonthToBook.size());

		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();
		// List<WebElement> list_AllDateToBook =
		// driver.findElements(By.xpath("//*[starts-with(@class,
		// 'datepicker--cell datepicker--cell-day')]"));
		String xpath1 = "//*[(@class='datepicker--cell datepicker--cell-day' or @class='datepicker--cell datepicker--cell-day -weekend-') and @data-month='";
		String xpath2 = "']";
		int no = Integer.parseInt(date_dd_MM_yyyy[1]) - 1;
		String fin = xpath1 + no + xpath2;
		System.out.println(fin);
		List<WebElement> list_AllDateToBook = driver.findElements(By.xpath(fin));
		System.out.println(list_AllDateToBook.size());
		for (WebElement s : list_AllDateToBook) {
			System.out.println(s.getText());
		}
		list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();
*/		Thread.sleep(5000);
		//homeHotel.getHotelsCheckOut().click();		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		log.info("Broswer window is clode. Driver closed");
	}

}
