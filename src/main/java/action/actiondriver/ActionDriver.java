package action.actiondriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.actioninterface.ActionsInterface;

public class ActionDriver implements ActionsInterface{
	
	WebDriver driver;

	@Override
	public void click(WebElement ele) {
		Actions action=new Actions(driver);
		action.click().build().perform();
	}

	@Override
	public void mouseHover(WebElement ele) {
		Actions action=new Actions(driver);
		action.moveToElement(ele).build().perform();
	}

	@Override
	public void switchToAlerts() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	
	

}
