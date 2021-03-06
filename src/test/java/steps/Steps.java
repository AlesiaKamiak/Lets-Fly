package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
		MainPage mp = PageFactory.initElements(driver, MainPage.class);
		mp.openPage();
		mp.enterFromField(fromCity);
		mp.enterDestinationField(destinationCity);
		mp.chooseOneWay();
		mp.choseDepartureDate();
		mp.clickSearchButton();
		mp.clickFareCalendar();
		mp.printAllDaysTickets();
	


	}
	public void findRoundTripTickets(String fromCity, String destinationCity) {
		MainPage mp = PageFactory.initElements(driver, MainPage.class);
		mp.openPage();
		mp.enterFromField(fromCity);
		mp.enterDestinationField(destinationCity);
		mp.chooseBothSides();
		mp.choseDepartureDate12();
		
	}
}
