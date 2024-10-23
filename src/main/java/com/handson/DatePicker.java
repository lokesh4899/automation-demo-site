package com.handson;

import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {
	
	WebDriver driver;
	
	@FindBy(linkText="Widgets")
	WebElement widgets;
	@FindBy(linkText="Datepicker")
	WebElement datePicker;
	@FindBy(id="datepicker1")
	WebElement datePicker1;
	@FindBy(id="datepicker2")
	WebElement datePicker2;
	@FindBy(xpath="//select[@class='datepick-month-year'][1]")
	WebElement month2;
	@FindBy(xpath="//select[@class='datepick-month-year'][2]")
	WebElement year2;
	@FindBy(xpath="//*[text()=\"Today\"]")
	WebElement tod;
	@FindBy(xpath="//*[@class='ui-datepicker-title']/span[1]")
	WebElement month1;
	@FindBy(xpath="//*[@class='ui-datepicker-title']/span[2]")
	WebElement year1;
	@FindBy(xpath="//*[@data-handler='prev']")
	WebElement prev1;
	@FindBy(xpath="//*[@data-handler='next']")
	WebElement next1;
	
	public DatePicker(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	static Month convertMonth(String month) {
		
		HashMap<String,Month> hm=new HashMap<String,Month>();
		
		hm.put("January",Month.JANUARY);
		hm.put("February",Month.FEBRUARY);
		hm.put("March",Month.MARCH);
		hm.put("April",Month.APRIL);
		hm.put("May",Month.MAY);
		hm.put("June",Month.JUNE);
		hm.put("July",Month.JULY);
		hm.put("August",Month.AUGUST);
		hm.put("September",Month.SEPTEMBER);
		hm.put("October",Month.OCTOBER);
		hm.put("November",Month.NOVEMBER);
		hm.put("December",Month.DECEMBER);
		
		Month vmonth=hm.get(month);
		
		if(vmonth==null) {
			System.out.println("Invalid Month...");
		}
		return vmonth;
	}
	
	public void moveToDatePicker() {
		Actions actions=new Actions(driver);
		actions.moveToElement(widgets).perform();
		actions.moveToElement(datePicker).click().perform();
	}
	
	
	public void enabledDatePicker() {
		datePicker2.click();
		System.out.println(tod.getText());
		Select m=new Select(month2);
		m.selectByVisibleText("August");
		Select y=new Select(year2);
		y.selectByVisibleText("2014");
		List<WebElement> li=driver.findElements(By.xpath("//*[@class=\"datepick-month-header\"]/following::td/a"));
		for(WebElement date: li) {
			if(date.getText().equals("6")) {
				date.click();
			}
		}
	}
	
	public void disabledDatePicker(){
		int exp_year=2024;
		String exp_month="January";
		datePicker1.click();
		int curr_year=Integer.valueOf(year1.getText());
		if(curr_year==exp_year) {
			while(true) {
				String curr_month=month1.getText();
				
				Month display_month=convertMonth(curr_month);
				Month required_month=convertMonth(exp_month);
				
				int result=required_month.compareTo(display_month);
				if(result<0){
					prev1.click();
				}
				else if(result>0) {
					next1.click();
				}
				else {
					break;
				}
				
			}
		}
		List<WebElement> li =driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/descendant::td/a"));
		for(WebElement date: li) {
			if(date.getText().equals("10")) {
				date.click();
			}
		}
		
		
	}
	
	

}
