package com.handson;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alerts {
	
	WebDriver driver;
	
	@FindBy(linkText="SwitchTo")
	WebElement switch_to;
	@FindBy(linkText="Alerts")
	WebElement alerts;
	@FindBy(xpath="//div[@id='OKTab']/button")
	WebElement alert_box_button;
	@FindBy(linkText="Alert with OK & Cancel")
	WebElement Alert_with_confirm_box;
	@FindBy(xpath="//div[@id='CancelTab']/button")
	WebElement confirm_box_button;
	@FindBy(id="demo")
	WebElement alert_msg;
	@FindBy(linkText="Alert with Textbox")
	WebElement alet_with_textbox;
	@FindBy(xpath="//div[@id='Textbox']/button")
	WebElement text_box_button;
	@FindBy(id="demo1")
	WebElement promptbox_msg;
	
	
	
	
	public Alerts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void swichToAlerts() {
		Actions actions=new Actions(driver);
		actions.moveToElement(switch_to).perform();
		actions.moveToElement(alerts).click().perform();
	}
	
	
	public void clickonAlertBox() {
		alert_box_button.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void selectConfirmBox() {
		Alert_with_confirm_box.click();
	}
	public void clickOnConfirmBoxAccept() {
		confirm_box_button.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public String getAlertMsg() {
		return alert_msg.getText();
	}
	public void clickOnconfimBoxCancel() {
		confirm_box_button.click();
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public void selectPomptBox() {
		alet_with_textbox.click();
	}
	public void clickOnPropmtBoxAccept() {
		text_box_button.click();
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("john");
		alert.accept();
	}
	public String getPromptMsg() {
		return promptbox_msg.getText();
	}
	
	
	

}
