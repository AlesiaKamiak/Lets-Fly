package pages;


import java.util.Map;


import org.openqa.selenium.WebDriver;

public class InfoTicketPage extends AbstractPage {
	
public static float parsePrice(String cost){
		
		return Float.valueOf(cost.replaceAll(",",".").split(" BYN")[0]); 
				
	}
	
	
public static String writeAllElementsMapConsole(Map<Float, String> map){
		
		String s=null;
		String p=null;
		for(int i=0; i<map.values().toArray().length; i++) {
		s = map.values().toArray()[i]+" "+map.keySet().toArray()[i];
		p=p+" "+s;
		}
		
		return p;
	}
	


	public InfoTicketPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		
	}

}
