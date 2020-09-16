package AutomationTeam.AutomationFramework.CommonDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

public class Base {

	public static WebDriver driver = null;
	public static ExtentReports extent;
	@Parameters({ "browser" })
	@BeforeSuite
	public void beforeSuite(String browser) {

		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		
		
		
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-geolocation");
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			driver = new ChromeDriver(options);
		} else {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://in.bookmyshow.com");
		driver.navigate().to("https://in.bookmyshow.com");

	}

	@AfterSuite
	public void afterSuite() {

		driver.quit();
		extent.flush();
		extent.close();
		
	}

	
	
}
