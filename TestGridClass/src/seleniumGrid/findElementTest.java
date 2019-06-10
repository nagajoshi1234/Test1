package seleniumGrid;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElementTest {

	public static void main(String[] args) throws Exception {

		// Start browser
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				
			WebDriver driver = new ChromeDriver();
			

			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(200);

		driver.findElement(By.name("button")).click();
		// Navigate to the URL---body > div > div > form > table.m_tbl > tbody > tr > td > table.table-upper > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(1) > input.btn
		//	driver.findElement(By.linkText("Deprecated")).click();
		driver.get("https://www.techbeamers.com");
		//driver.get("https://stackoverflow.com/");

		// Sleep for 5 seconds

		Thread.sleep(5000);

		// Here, see how the XPath will select unique Element.
		WebElement link = driver
				.findElement(By.xpath("'//table/tr[1]/td[1]/a"));

		// click on the link
		link.click();
	}
}