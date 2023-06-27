package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CrossBrowserTest {
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void initialize(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
			System.out.println("Chrome is launched");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
			System.out.println("Fire fox is launched");
		}
	}
	
	@Test
	public void googleTest() {
		driver.get("https://www.google.com/");
		driver.getTitle();
	}

}
