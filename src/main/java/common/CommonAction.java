package common;

import org.openqa.selenium.WebElement;
import reporting.Logs;

public class CommonAction {
	public static void click(WebElement element) {
		element.click();
		Logs.log(element + "---------> has been clicked");
	}

}
