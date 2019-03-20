package automationFramework;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Task2 {

	public static void main(String[] args) throws InterruptedException, ParseException {
		
		
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

			
		
		WebElement sortirovka = driver.findElement(By.xpath(".//button[@id=\"sortbar_dropdown_button\"]"));
		sortirovka.click();

		WebElement raiting = driver.findElement(By.xpath("(.//a[@class=\"sort_option \"])[7]"));
		raiting.click();
		
		
		
		Thread.sleep(3000);

		
		
		
		String rank = driver.findElement(By.xpath("(.//div[@class=\"bui-review-score__badge\"])[1]")).getText();
		NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
		double rankDouble = nf.parse(rank).doubleValue();

		try {
			Assert.assertTrue(rankDouble > 9.0);
		} catch (AssertionError e) {
			System.out.println("noooo");
		} finally {
			driver.close();
		}
	}
}
