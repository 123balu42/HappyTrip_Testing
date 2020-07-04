package com.skillassure.happytrip.base;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	// Logger
	private static Logger log = LogManager.getLogger(BaseClass.class);

	public WebDriver driver;

	@BeforeClass
	public void setupApplication() {
		BasicConfigurator.configure();
		// Browser on which we are Testing the Application
		String driverPath = "drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Pass the url that need to be tested
		driver.get("http://43.254.161.195:8085/happytripcrclean1/");
		log.info("Opening the HappyTrip WebAppllication in Browser");

		Reporter.log("************Application Session Started************", true);

	}

	// On completion of testing
	@AfterClass
	public void closeApplication() {

		driver.quit();
		log.info("Exiting the Browser");

		Reporter.log("************Browser Session Ended************", true);
	}

}
