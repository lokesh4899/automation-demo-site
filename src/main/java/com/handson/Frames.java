package com.handson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames {
	
	WebDriver driver;
	
	@FindBy(linkText="SwitchTo")
	WebElement switch_to;
	@FindBy(linkText="Frames")
	WebElement frames;
	@FindBy(id="singleframe")
	WebElement single_frame;
	@FindBy(linkText="Iframe with in an Iframe")
	WebElement multiple_frame_button;
	@FindBy(xpath="//*[@id='Multiple']/iframe")
	WebElement outerFrame;
	@FindBy(xpath="//*[@class='iframe-container']/iframe")
	WebElement innerFrame;
	@FindBy(xpath="//*[@type='text']")
	WebElement textbox;
	
	public Frames(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void switchtoFrames() {
		Actions actions=new Actions(driver);
		actions.moveToElement(switch_to).perform();
		actions.moveToElement(frames).click().perform();
	}
	
	public void singleFrame() {
		driver.switchTo().frame(single_frame);
		textbox.sendKeys("Hello Single frame");
	}
	public void nestedFrame() {
		multiple_frame_button.click();
		driver.switchTo().frame(outerFrame);
		driver.switchTo().frame(innerFrame);
		textbox.sendKeys("Hello nested frame");
	}

}
