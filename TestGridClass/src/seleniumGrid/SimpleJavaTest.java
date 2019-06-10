package seleniumGrid;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SimpleJavaTest {

	
	//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	public static WebDriver driver = new FirefoxDriver();
	public static String url = "file:///C:\\Users\\u48090\\Desktop\\HTML FILE/Test1.html";
//C:\Users\u48090\Desktop\HTML FILE
	static String maleRadioButton = "#male";
	static String promptAlertButton = "body > div > div:nth-child(27) > div > p:nth-child(1) > button";
	static String promptReply = "#demoPrompt";

	static Alert alert;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver.get(url);
		verifyRadioButtonChecked();
		verifyPromptMessage();
		verifySelectListType();
		driver.close();

	}




// TestCase1: to check whether radio button is selected or not, if not, then click
	public static void verifyRadioButtonChecked() {
		WebElement maleRadioButtonlocation = driver.findElement(By.cssSelector(maleRadioButton));
		
		Assert.assertTrue(maleRadioButtonlocation.isSelected());
	}

	// TestCase2: to test prompt alert
	public static void verifyPromptMessage() {
		 WebElement promptAlertButtonLocator = driver.findElement(By.cssSelector(promptAlertButton));
		 promptAlertButtonLocator.click();
		alert = driver.switchTo().alert();
		System.out.println("Simple Alert text: " + alert.getText());
		String promptAlertSendKeys = "Gaurav";
		alert.sendKeys(promptAlertSendKeys);
		alert.accept();
		WebElement promptReplyLocator = driver.findElement(By.cssSelector(promptReply));
		String promtAlertReply = promptReplyLocator.getText();
		System.out.println(promtAlertReply);
		Assert.assertEquals(promtAlertReply, "Hello " + promptAlertSendKeys + "! How are you today?");
	}





// TestCase3: Select dropdown option as Database testing
	public static void verifySelectListType() {
		// Select using selectByIndex, selectByValue, SelectByVisisbleText
		WebElement selectList = driver.findElement(By.cssSelector("#testingDropdown"));
		 Select select = new Select(selectList);		
		select.selectByValue("Database");
		// Check if select list is multi select or not
		System.out.println("Is select list is a multiple or not? " + select.isMultiple());
		Assert.assertEquals(false, select.isMultiple());
	}

}

