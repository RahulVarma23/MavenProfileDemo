package demoPackage;

import java.lang.reflect.Method;
import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LambdatestSetUp {
	
	public RemoteWebDriver driver;
	JavascriptExecutor js;
	public static final String USERNAME = "rahulvarma411";
	public static final String AUTOMATE_KEY = "oTVInU44yRi8Rg8GsLy9SkEW7K79TQgO4cMLWPFmfNVBQ1QyxI";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";
	
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method m) throws Exception {
		     DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platform", "Windows 11");
	        caps.setCapability("browserName", "Chrome");
	        caps.setCapability("version", "92.0");
	        caps.setCapability("resolution", "1024x768");
	        caps.setCapability("build", "Epam Training - Lambdatest");
	        caps.setCapability("name", m.getName() + this.getClass().getName());
	        caps.setCapability("plugin", "git-testng");
		driver = new RemoteWebDriver(new URL(URL), caps);
        js = (JavascriptExecutor)driver;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}

}
