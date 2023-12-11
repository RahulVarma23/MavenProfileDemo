package demoPackage;

import org.testng.annotations.Test;

public class Demo extends LambdatestSetUp {

	@Test
	public void sanityTest() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("Google")) {
			driver.executeScript("lambda-status=passed");
		} else {
			driver.executeScript("lambda-status=failed");
		}
		System.out.println("--sanity test done---");
		driver.quit();
	}

	@Test
	public void regressionTest() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("BrowserStack - Google Search")) {
			driver.executeScript("lambda-status=passed");
		} else {
			driver.executeScript("lambda-status=failed");
		}
		System.out.println("--regression test done---");
		driver.quit();
	}

	@Test
	public void smokeTest() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		driver.get("https://www.browserstack.com");
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("BrowserStack")) {
			driver.executeScript("lambda-status=passed");
		} else {
			driver.executeScript("lambda-status=failed");
		}
		System.out.println("--smoke test done---");
		driver.quit();
	}
}
