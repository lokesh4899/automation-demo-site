package com.handson;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoComplete {
	
	WebDriver driver;
	
	@FindBy(linkText="Widgets")
	WebElement widgets;
	@FindBy(linkText="AutoComplete")
	WebElement autoComplete;
	@FindBy(id="searchbox")
	WebElement searchBox;
	
	public AutoComplete(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void moveToAutoComplete() {
		Actions actions=new Actions(driver);
		actions.moveToElement(widgets).perform();
		actions.moveToElement(autoComplete).click().perform();
	}
	
	public void autoSuggest() {
		searchBox.sendKeys("In");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='ui-id-1']/li")));
		List<WebElement> li=driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
		for(WebElement city: li) {
			if(city.getText().equals("India")) {
				city.click();
			}
		}
		
	}

}
