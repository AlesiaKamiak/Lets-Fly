package steps;

import org.openqa.selenium.WebDriver;

import driver.DriverSingleton;
import pages.MainPage;

public class Steps {

	private WebDriver driver;
	
	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}
	
	public void closeBrowser() {
		DriverSingleton.closeDriver();
	}
	
	public void findTickets(String fromCity, String destinationCity) {
		MainPage mp = new MainPage(driver);
		
		mp.openPage();
		
		mp.enterFromField(fromCity);
	}
	
}
