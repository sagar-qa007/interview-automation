package AutomationTeam.AutomationFramework.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AutomationTeam.AutomationFramework.CommonDriver.Base;
import AutomationTeam.AutomationFramework.lib.CommonLib;
import AutomationTeam.AutomationFramework.utils.ExcelUtils;
import AutomationTeam.AutomationFramework.webe.Home_WebE;
import AutomationTeam.AutomationFramework.webe.Movie_WebE;
import AutomationTeam.AutomationFramework.webe.SeatLayoutWebE;
import AutomationTeam.AutomationFramework.webe.Shows_WebE;

public class SeatLayoutPage {

	public static WebDriver driver = null;
	static WebDriverWait wait = null;
	static Home_WebE home_webe;
	static Movie_WebE movie_webe;
	static SeatLayoutWebE seatLayout_webe;
	static Shows_WebE shows_webe;

	ExtentTest logger;

	@BeforeClass
	public void beforeClass() {

		// Before Start Test
		wait = new WebDriverWait(Base.driver, 20);
		home_webe = Home_WebE.getInstance(Base.driver);
		movie_webe = Movie_WebE.getInstance(Base.driver);
		seatLayout_webe = SeatLayoutWebE.getInstance(Base.driver);
		shows_webe = Shows_WebE.getInstance(Base.driver);
	}

	@Test(dataProvider = "SeatLayoutPage")
	public void nextVacantSeat(String city, String movie) {

		try {

			logger = Base.extent.startTest("nextVacantSeat");
			logger.log(LogStatus.INFO, movie);
			WebElement webe = Base.driver.findElement(By.xpath("//a[contains(@onclick,'" + city + "')]/.."));
			if (CommonLib.checkElementPresent(webe)) {
				webe.click();
			}

			webe = home_webe.topRightPopUp;

			if (CommonLib.checkElementPresent(webe)) {
				webe.click();
			}

			Base.driver.switchTo().defaultContent();

			Base.driver.findElement(By.xpath("//img[@alt='" + movie + "']/..")).click();
			logger.log(LogStatus.INFO, "Movie Page Opened");
			movie_webe.lnk_bookTiket.click();
			
			logger.log(LogStatus.INFO, "Book Ticket Page Opened");
			shows_webe.btn_FirstShowTime.click();
			
			logger.log(LogStatus.INFO, "Show Page Opened");
			shows_webe.btn_AcceptPopUp.click();
			
			shows_webe.btn_SelectSeat.click();
			logger.log(LogStatus.INFO, "Select seat Page Opened");
			
			seatLayout_webe.lst_AvailableSeat.get(0).click();
			
			seatLayout_webe = SeatLayoutWebE.getInstance(Base.driver);
			
			wait.until(ExpectedConditions.visibilityOf(seatLayout_webe.btn_NextAfterSelected));
			
			String NextAvailableString = seatLayout_webe.btn_NextAfterSelected.getAttribute("class");
			System.out.println(NextAvailableString);
			boolean bst = (NextAvailableString.contains("_available"))  ? true : false;

			if (bst)
			{
				logger.log(LogStatus.PASS, "Test Case Passed ");
			}
			else
			{
				//logger.log(LogStatus.FAIL, "Test Case Failed ");
				 String screenshotPath = CommonLib.getScreenshot(Base.driver,"nextVacantSeat");
				 //To add it in the extent report 
				 logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			}
			Base.extent.endTest(logger);
			Assert.assertTrue(bst);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void AfterClass() {

		// Last setup
		wait = null;

	}

	@DataProvider(name = "SeatLayoutPage")
	public Object[][] nextVacantSeatData() {
		String sheetName = "vacant";
		ExcelUtils tData = new ExcelUtils("data/testdata.xlsx");

		int tcNum = tData.getRowCount(sheetName);

		Object[][] details = new Object[tcNum][2];

		for (int i = 0; i < tcNum; i++) {
			details[i][0] = tData.getRowData(sheetName, i, 1);
			details[i][1] = tData.getRowData(sheetName, i, 2);
		}
		return details;
	}

}
