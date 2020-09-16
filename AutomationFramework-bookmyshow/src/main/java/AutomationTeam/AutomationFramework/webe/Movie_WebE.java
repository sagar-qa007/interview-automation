package AutomationTeam.AutomationFramework.webe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Movie_WebE
{

	@FindBy(linkText = "BOOK TICKETS")
	public WebElement	lnk_bookTiket;
	
	static Movie_WebE	INSTANCE	= null;

	public static Movie_WebE getInstance(WebDriver driver)
	{
		if (INSTANCE == null)
		{
			INSTANCE = PageFactory.initElements(driver, Movie_WebE.class);
		}
		return INSTANCE;
	}

}
