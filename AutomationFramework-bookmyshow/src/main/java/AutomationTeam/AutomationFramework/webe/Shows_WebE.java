package AutomationTeam.AutomationFramework.webe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shows_WebE
{

	@FindBy(xpath="(//a[contains(@class,'showtime-link')])[1]")
	public WebElement btn_FirstShowTime;
	
	@FindBy(id="btnPopupAccept")
	public WebElement btn_AcceptPopUp;
	
	@FindBy(id="proceed-Qty")
	public WebElement btn_SelectSeat;
	
	static Shows_WebE	INSTANCE	= null;

	public static Shows_WebE getInstance(WebDriver driver)
	{
		if (INSTANCE == null)
		{
			INSTANCE = PageFactory.initElements(driver, Shows_WebE.class);
		}
		return INSTANCE;
	}

}
