package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
	
	private final String BASE_URL = "https://belavia.by/";
	
	@FindBy(xpath="//*[@id=\"ibe\"]/form/div[1]/div[1]/div/label")
	private WebElement from;
	
	@FindBy(xpath="//*[@id=\"ibe\"]/form/div[1]/div[2]/div/label")
	private WebElement destinationCity;
	
	
	public void enterFromField(String fromCity) { //?
		from.sendKeys(fromCity);
		from.sendKeys(Keys.ENTER);
		System.out.println(fromCity +"chosen");
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
