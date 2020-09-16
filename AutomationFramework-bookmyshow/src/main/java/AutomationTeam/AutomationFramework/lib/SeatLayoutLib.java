package AutomationTeam.AutomationFramework.lib;

import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationTeam.AutomationFramework.CommonDriver.Base;
import AutomationTeam.AutomationFramework.webe.SeatLayoutWebE;

public class SeatLayoutLib {

	static SeatLayoutWebE			seatLayout_webe;
	static WebDriverWait wait  = null;
	/**
	 * To verify login with uname and pass
	 * 
	 * @author sagar.nk
	 *
	 */
	public static boolean verifyCases(String uname, String pass) {
		try {
			wait = new WebDriverWait(Base.driver,20);
			seatLayout_webe = SeatLayoutWebE.getInstance(Base.driver);
			
			
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
