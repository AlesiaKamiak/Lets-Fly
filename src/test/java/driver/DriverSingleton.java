package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "C:\\driver\\chromedriver.exe";

	public static WebDriver driver;

	private DriverSingleton() {
	}

	public static WebDriver getDriver() {
		
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
	}

}
