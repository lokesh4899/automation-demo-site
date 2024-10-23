package com.handson;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Windows {
	
	WebDriver driver;
	
	@FindBy(linkText="SwitchTo")
	WebElement switch_to;
	@FindBy(linkText="Windows")
	WebElement windows;
	@FindBy(xpath="//*[@id='Tabbed']/a/button")
	WebElement new_tab_button;
	@FindBy(xpath="//*[text()='Documentation']")
	WebElement documentation;
	@FindBy(linkText="Open New Seperate Windows")
	WebElement seperate_window;
	@FindBy(xpath="//*[@id='Seperate']/button")
	WebElement seperate_window_button;
	@FindBy(linkText="Open Seperate Multiple Windows")
	WebElement seperate_multiple_window;
	@FindBy(xpath="//*[@id='Multiple']/button")
	WebElement multiple_window_button;
	@FindBy(id="btn1")
	WebElement signin;
	
	public Windows(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void switchToWindows() {
		Actions actions=new Actions(driver);
		actions.moveToElement(switch_to).perform();
		actions.moveToElement(windows).click().perform();
	}
	
	public void newTab() {
		new_tab_button.click();
		String parent=driver.getWindowHandle();
		Set<String> wi=driver.getWindowHandles();
		System.out.println("new tab windows:"+wi.size());
		Iterator<String> it=wi.iterator();
		while(it.hasNext()) {
			if(parent!=it.next()) {
				driver.switchTo().window(it.next());
				documentation.click();
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		}
	public void newWindow() {
		seperate_window.click();
		String parent=driver.getWindowHandle();
		seperate_window_button.click();
		Set<String> wi=driver.getWindowHandles();
		System.out.println("new tab windows:"+wi.size());
		Iterator<String> it=wi.iterator();
		while(it.hasNext()) {
			if(parent!=it.next()) {
				driver.switchTo().window(it.next());
				documentation.click();
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}
	public void multipleWindow() {
		seperate_multiple_window.click();
		String parent=driver.getWindowHandle();
		multiple_window_button.click();
		driver.switchTo().window(parent);
		Set<String> wi=driver.getWindowHandles();
		System.out.println("new tab windows:"+wi.size());
		Iterator<String> it=wi.iterator();
		while(it.hasNext()) {
			if(!parent.equals(it.next())) {
				driver.switchTo().window(it.next());
			}
		}
		driver.switchTo().window(parent);
	}

}
