package pages;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoTicketPage extends AbstractPage {
	
public static float parsePrice(String cost){
		
		return Float.valueOf(cost.replaceAll(",",".").split(" BYN")[0]); 
				
	}
	
	public static String writeFirstElementMapConsole(Map<Float, String> map){
		
		String s;
		return s = map.values().toArray()[0]+" "+map.keySet().toArray()[0];
	
	}
	

	public void getDateTicket() {
		
	}

	public InfoTicketPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		
	}

}
