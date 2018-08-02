package pages;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
	
	private final String BASE_URL = "https://belavia.by/";
	
	@FindBy(xpath="//*[@id=\"OriginLocation_Combobox\"]")
	private WebElement from;
	
	@FindBy(xpath="//*[@id=\"DestinationLocation_Combobox\"]")
	private WebElement destinationCity;
	
	@FindBy(xpath="//*[@id=\"step-2\"]/div[1]/div/label[1]")
	private WebElement oneWay;
	
	@FindBy(xpath="//*[@id=\"step-2\"]/div[2]/div[1]/div/a/i")
	private WebElement departureDateField;
	
	@FindBy(xpath="//*[@id=\"calendar\"]/div/div[1]/table/tbody/tr[2]/td[1]/a")
	private WebElement departureDate;
	
	@FindBy(xpath="//*[@id=\"step-2\"]/div[4]/div/button")
	private WebElement searchButton;
	
	
	
	
	public void enterFromField(String fromCity) { 
		from.sendKeys(fromCity);
		from.sendKeys(Keys.ENTER);
		System.out.println(fromCity +" chosen");
	}
	
	public void enterDestinationField(String DestinationCity) { 
		destinationCity.sendKeys(DestinationCity);
		destinationCity.sendKeys(Keys.ENTER);
		
		System.out.println(DestinationCity +" chosen");
	}
	
	public void chooseOneWay() {
		oneWay.click();
		System.out.println("one way chosen");
	}
	
	public void choseDepartureDate() {
		departureDateField.click();
		departureDate.click();

	}
	
	public void clickSearchButton() {
		searchButton.click();
		
		
	}
		
	public MainPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		driver.get(BASE_URL);
		System.out.println("belavia.by opened");
		
	}
	

	

}
