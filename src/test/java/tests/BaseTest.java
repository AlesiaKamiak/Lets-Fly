package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import steps.Steps;

public class BaseTest {

	protected Steps steps;

	@BeforeTest(description = "Init browser")
	public void initDriver() {
		steps = new Steps();
		steps.initBrowser();
		System.out.println("Init browser");

	}

//	@AfterTest(description = "Stop browser")
//	public void stopDriver() {
//		steps.closeBrowser();
//		System.out.println("Quit browser");
//	}

}
