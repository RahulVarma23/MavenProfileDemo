package demoPackage;

import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SaucelabSetUp {
	
	public RemoteWebDriver driver;
	JavascriptExecutor js;
	public static final String USERNAME = "oauth-rahulvarma411-68452";
	public static final String AUTOMATE_KEY = "b07572be-91b9-411b-804c-3f469e815603";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability("platformName","Windows 10");
		browserOptions.setCapability("browserVersion","latest");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("build", "selenium-build-II8BY");
		sauceOptions.setCapability("name", "Selenium Tests");
		sauceOptions.setCapability("extendedDebugging", "true");
		sauceOptions.setCapability("capturePerformance", "true");
		browserOptions.setCapability("sauce:options", sauceOptions);
		driver = new RemoteWebDriver(new URL(URL), browserOptions);
        js = (JavascriptExecutor)driver;
        //js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"<passed/failed>\", \"reason\": \"<reason>\"}}");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}

}
