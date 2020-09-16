package AutomationTeam.AutomationFramework.webe;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeatLayoutWebE
{

	@FindBy(xpath = "//a[@class='_available']")
	public List<WebElement> lst_AvailableSeat;
	
	@FindBy(xpath = "//a[contains(@class,'_selected') and contains(@class,'_selected')]")
	public WebElement btn_Available_Selected;
	
	@FindBy (xpath = "//a[contains(@class,'_available') and contains(@class,'_selected')]/../following-sibling::div[1]/a")
	public WebElement btn_NextAfterSelected;
	
	static SeatLayoutWebE	INSTANCE	= null;

	public static SeatLayoutWebE getInstance(WebDriver driver)
	{
		if (INSTANCE == null)
		{
			INSTANCE = PageFactory.initElements(driver, SeatLayoutWebE.class);
		}
		return INSTANCE;
	}

}
