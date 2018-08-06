package pages;

import java.util.ArrayList;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	private final String BASE_URL = "https://belavia.by/";

	@FindBy(xpath = "//*[@id=\"OriginLocation_Combobox\"]")
	private WebElement from;

	@FindBy(xpath = "//*[@id=\"DestinationLocation_Combobox\"]")
	private WebElement destinationCity;

	@FindBy(xpath = "//*[@id=\"step-2\"]/div[1]/div/label[1]")
	private WebElement oneWay;

	@FindBy(xpath = "//*[@id=\"step-2\"]/div[1]/div/label[2]")
	private WebElement bothSides;

	@FindBy(xpath = "//*[@id=\"step-2\"]/div[2]/div[1]/div/a/i")
	private WebElement departureDateField;

	@FindBy(xpath = "//*[@id=\"calendar\"]/div/div[1]/table/tbody/tr[2]/td[3]/a")
	private WebElement departureDate7;

	@FindBy(xpath = "//*[@id=\"calendar\"]/div/div[1]/table/tbody/tr[2]/td[7]/a")
	private WebElement departureDate12;

	@FindBy(xpath = "")
	private WebElement returnDate20;

	@FindBy(xpath = "//*[@id=\"calendar\"]/div/div[1]/div/div/span[2]")
	private WebElement departureDateYear5;

	@FindBy(xpath = "//*[@id=\"calendar\"]/div/div[1]/div/div/span[1]")
	private WebElement departureDateMonth5;

	@FindBy(xpath = "//*[@id=\"step-2\"]/div[4]/div/button")
	private WebElement searchButton;

	@FindBy(css = "#matrix span.date")
	List<WebElement> Dates;

	@FindBy(xpath = "//*[@id=\"outbound\"]/div[1]/div/div[2]/a")
	private WebElement fareCalendar;

	String fromCity = "Minsk (MSQ), BY";
	String DestinationCity = "Riga (RIX), LV";

	@FindBy(css = "#matrix div.content")
	List<WebElement> Costs;

	@FindBy(xpath = "//*[@id=\"matrix\"]/div[1]/div[1]/div[2]/a")
	private WebElement next7Days;

	private ArrayList<Float> cost() {

		ArrayList<Float> cost = new ArrayList<Float>();

		int n = 0;

		for (WebElement element : Costs) {
			if (element.getText().trim().equals("--")) {
				if (n == 0) {
					n += 1;
				} else if (n == 1) {
					n = 0;
					cost.add(null);
				}
			} else {
				cost.add(InfoTicketPage.parsePrice(element.getText()));
			}

		}
		return cost;
	}

	public String costFlight() {

		return getStringOfCosts(datesOut(), cost());

	}

	private ArrayList<String> datesOut() {

		ArrayList<String> dateOut = new ArrayList<String>();

		int n = 1;

		for (WebElement element : Dates) {
			if (n <= 7) {
				n += 1;
				dateOut.add(element.getText());
			}

		}
		return dateOut;
	}

	private String getStringOfCosts(ArrayList<String> datesOut, ArrayList<Float> cost) {
		String result = "";
		for (int i = 0; i < datesOut.size(); i++) {
			if (cost.get(i) != null) {
				result += datesOut.get(i) + ": " + cost.get(i) + "; ";
			}
		}
		return result;
	}

	public void enterFromField(String fromCity) {
		from.sendKeys(fromCity);
		from.sendKeys(Keys.ENTER);
		System.out.println(fromCity + " chosen");
	}

	public void enterDestinationField(String DestinationCity) {
		destinationCity.sendKeys(DestinationCity);
		destinationCity.sendKeys(Keys.ENTER);

		System.out.println(DestinationCity + " chosen");
	}

	public void chooseOneWay() {
		oneWay.click();
		System.out.println("one way chosen");
	}

	public void chooseBothSides() {
		bothSides.click();
		System.out.println("both sides chosen");
	}

	public void choseDepartureDate() {
		departureDateField.click();
		departureDate7.click();

	}

	public void choseDepartureDate12() {
		departureDateField.click();
		departureDate12.click();

	}

	public void choseDepartureDate20() {

		returnDate20.click();

	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void clickFareCalendar() {
		fareCalendar.sendKeys(Keys.ENTER);

	}

	public void clickNext7Days() {
		next7Days.click();

	}

	public String allDaysTickets() {
		int n = 0;
		String all = null;
		String seven = null;
		{
			while (n < 12) {
				seven = costFlight();
				clickNext7Days();
				all = all + seven;
				n++;
			}
		}
		return all;
	}
	
	public void printAllDaysTickets() {
		System.out.println(allDaysTickets());
	}

	@Override
	public void openPage() {
		driver.get(BASE_URL);
		System.out.println("belavia.by opened");

	}

}
