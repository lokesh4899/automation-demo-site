package com.handson;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selectable {
	
	WebDriver driver;
	
	@FindBy(linkText="Interactions")
	WebElement interactions;
	@FindBy(linkText="Selectable")
	WebElement selectable;
	@FindBy(linkText="Serialize")
	WebElement serialize;
	@FindBy(id="feedback")
	WebElement result;
	
	public Selectable(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void moveToSelectable() {
		Actions actions=new Actions(driver);
		actions.moveToElement(interactions).perform();
		actions.moveToElement(selectable).click().perform();
	}
	
	public void defaultSelection() {
		String str="Extent Reports";
		List<WebElement> li=driver.findElements(By.xpath("//*[@class='deaultFunc']/li"));
		System.out.println(li.size());
		for(WebElement concept: li) {
			if(concept.getText().contains(str)) {
				concept.click();
			}
		}
	}
	
	public void serializeSelection() {
		String str="Cross Browser Testing";
		serialize.click();
		List<WebElement> li=driver.findElements(By.xpath("//*[@class='SerializeFunc']/li"));
		System.out.println(li.size());
		for(WebElement concept: li) {
			if(concept.getText().contains(str)) {
				concept.click();
			}
		}
	}
	
	//9502221497

}
