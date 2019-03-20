package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {

		String exePath = "C:\\first\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com");

		WebElement search = driver.findElement(By.xpath(".//input[@type=\"search\"]"));
		search.sendKeys("Москва");
		search.submit();

		Thread.sleep(1000);

		WebElement date1 = driver.findElement(By.xpath("(.//td[@data-id=\"1552694400000\"])[1]"));
		date1.click();

		WebElement date2 = driver.findElement(By.xpath(".//td[@data-id=\"1553299200000\"]"));
		date2.click();

		WebElement window = driver
				.findElement(By.xpath("(.//i[@class=\"sb-date-field__chevron bicon-downchevron\"])[1]"));
		window.click();

		WebElement hotel = driver.findElement(By.xpath("(.//span[text()=\"Найти\"])[2]"));
		hotel.click();

		Thread.sleep(5000);

		try {
			Assert.assertFalse((driver.findElements(By.className("sr-hotel__name")).isEmpty()));
		} catch (AssertionError e) {
			System.out.println("Hotels are out");
		} finally {
			driver.close();
		}
	}
}
