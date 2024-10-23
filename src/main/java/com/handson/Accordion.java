package com.handson;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Accordion {
	
	WebDriver driver;
	
	@FindBy(linkText="Widgets")
	WebElement widgets;
	@FindBy(linkText="Accordion")
	WebElement accordion;
	@FindBy(linkText="Slider")
	WebElement slider;
	@FindBy(xpath="//*[text()='Collapsible Group 1 - Readability']")
	WebElement readability;
	@FindBy(id="collapse1")
	WebElement readabilityMsg;
	@FindBy(id="collapse2")
	WebElement slcMsg;
	@FindBy(id="collapse3")
	WebElement chainingMsg;
	@FindBy(id="collapse4")
	WebElement crossBrowserMsg;
	@FindBy(xpath="//*[text()='Collapsible Group 2 - Single Line Coding']")
	WebElement singleLineCoding;
	

	@FindBy(id="slider")
	WebElement slide;
	@FindBy(xpath="//*[@id='slider]/a")
	WebElement slideCursor;
	
	public Accordion(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void moveToAccordion() {
		Actions actions=new Actions(driver);
		actions.moveToElement(widgets).perform();
		actions.moveToElement(accordion).click().perform();
	}
	
	public void moveToSlider() {
		Actions actions=new Actions(driver);
		actions.moveToElement(widgets).perform();
		actions.moveToElement(slider).click().perform();
	}
	
	public void collapsible1() {
		readability.click();
	}
	
	public void collapsible2() {
		singleLineCoding.click();
	}
	
	public void Acc() {
		List<WebElement> li=driver.findElements(By.xpath("//*[@class='panel-group']/div"));
		for(WebElement col:li) {
			if(col.getText().contains("Methhod Chaining")) {
				col.click();
			}
		}
	}
	
	public String readabilityMessage() {
		return readabilityMsg.getText();
	}
	public String singleLineCodingMessage() {
		return slcMsg.getText();
	}
	public String methodChainingMessage() {
		return chainingMsg.getText();
	}
	public String crossBrowserTestingMessage() {
		return crossBrowserMsg.getText();
	}
	
	public void sliding() {		
		slide.click();
	}
	
//	public void returnPosition() {
//		Actions act=new Actions(driver);
//		act.clickAndHold(slide).moveToElement(slide,100, 50);
//	}
	
}
