package AutomationTeam.AutomationFramework.webe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_WebE
{

	@FindBy(id = "wzrk-cancel")
	public WebElement	topRightPopUp;

	
	static Home_WebE	INSTANCE	= null;

	public static Home_WebE getInstance(WebDriver driver)
	{
		if (INSTANCE == null)
		{
			INSTANCE = PageFactory.initElements(driver, Home_WebE.class);
		}
		return INSTANCE;
	}

}
