package utils;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class UtilMethods extends TestBase {

	WebElement next;

	public WebDriverWait getExplicitelyWait() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait;

	}

	public void printSample() {
		System.out.println("Hi");
	}

	public void getDate(String date, WebElement middle, WebElement next, WebElement prev) {

		System.out.println(middle.getText());
		String date_dd_MM_yyyy[] = date.split("/");
		System.out.println(date_dd_MM_yyyy.length);
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(yearDiff);
		middle.click();

		retryingFindClick(next);

		if (yearDiff != 0) {
			// if you have to move next year
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					System.out.println("Year Diff->" + i);
					retryingFindClick(next);
				}
			}
			// if you have to move previous year
			else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					System.out.println("Year Diff->" + i);
					retryingFindClick(prev);
				}
			}
		}
		// Get all months from calendar to select correct one
		List<WebElement> list_AllMonthToBook = driver
				.findElements(By.xpath("//*[starts-with(@class, 'datepicker--cell datepicker--cell-month')]"));
		System.out.println(list_AllMonthToBook.size());

		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();
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
	}

	public boolean retryingFindClick(WebElement element) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				element.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}
}
