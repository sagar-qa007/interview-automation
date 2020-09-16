package AutomationTeam.AutomationFramework.lib;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AutomationTeam.AutomationFramework.CommonDriver.Base;

public class CommonLib {

	public static boolean checkElementPresent(WebElement webe)
	{
		try
		{
			Base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			webe.getTagName();
			Base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
}
