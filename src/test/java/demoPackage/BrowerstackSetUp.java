package demoPackage;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BrowerstackSetUp {
	
	public WebDriver driver;
	JavascriptExecutor js;
	public static final String USERNAME = "rahulkanhaiyalal_PUogB3";
	public static final String AUTOMATE_KEY = "Wz8g3sCw5skcVXN9Pe3N";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		MutableCapabilities capabilities = new MutableCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");  
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability("browserName", "Firefox");
		capabilities.setCapability("browserVersion", "latest");
		capabilities.setCapability("browserstack.idleTimeout", "300");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("projectName", "Google Project");
		browserstackOptions.put("buildName", "epamTraining");
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "11");
		browserstackOptions.put("debug", "true"); 
		browserstackOptions.put("consoleLogs", "info");
		browserstackOptions.put("networkLogs", "true");
		capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        js = (JavascriptExecutor)driver;
        js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"<passed/failed>\", \"reason\": \"<reason>\"}}");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
