package tests;

import org.testng.annotations.Test;

public class BelaviaTest extends BaseTest {

	@Test
	public void oneWayTicket()  {
		steps.findTickets("Minsk (MSQ), BY", "Riga (RIX), LV");
	
	}

}
