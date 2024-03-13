package com.handson;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@ng-model='FirstName']")
	WebElement firstname;
	@FindBy(xpath="//*[@ng-model='LastName']")
	WebElement lastname;
	@FindBy(xpath="//*[@ng-model='Adress']")
	WebElement address;
	@FindBy(xpath="//*[@ng-model='EmailAdress']")
	WebElement email;
	@FindBy(xpath="//*[@ng-model='Phone']")
	WebElement phone;
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[5]/div/label")
	WebElement gender;
	@FindBy(xpath="//*[@class='checks']")
	WebElement hobbies;
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[7]/div/multi-select/div[2]/ul/li")
	WebElement language;
	@FindBy(id="Skills")
	WebElement skill;
	@FindBy(id="country")
	WebElement country;
	@FindBy(id="yearbox")
	WebElement year;
	@FindBy(id="daybox")
	WebElement day;
	@FindBy(id="firstpassword")
	WebElement password;
	@FindBy(id="secondpassword")
	WebElement confirmpwd;
	@FindBy(id="submitbtn")
	WebElement submit;
	
	@FindBy(xpath="//select[@placeholder='Month']")
	WebElement month;
	
	public Register(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setFirstName() {
		firstname.sendKeys("mahesh");
	}
	public void setLastName() {
		lastname.sendKeys("babu");
	}
	public void setAddress() {
		address.sendKeys("AndhraPradesh");
	}
	public void setEmail() {
		email.sendKeys("abc@gmail.com");
	}
	public void setPhone() {
		phone.sendKeys("12345567");
	}
	public void setGender() {
		List<WebElement> list=driver.findElements(By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label"));
		for(WebElement a:list) {
			if(a.getText().equals("Male")) {
				a.click();
			}
		}
	}
	public void setHobbies() {
		List<WebElement> list=driver.findElements(By.xpath("//label[@class='checks']"));
		for(WebElement a:list) {
			if(a.getText().equals("Cricket")) {
				a.click();
			}
		}
	}
	public void setLanguage() {
		driver.findElement(By.id("msdd")).click();
		List<WebElement> list=driver.findElements(By.xpath("//*[@id='basicBootstrapForm']/div[7]/div/multi-select/div[2]/ul/li"));
		for(WebElement a:list) {
			if(a.getText().equals("English")) {
				a.click();
			}
		}
	}
	public void setSkill() {
		Select skillset=new Select(skill);
		skillset.selectByVisibleText("Java");
	}
	public void setCountry() {
		Select coun=new Select(country);
		coun.selectByVisibleText("India");
	}
	public void setYear() {
		Select newyear=new Select(year);
		newyear.selectByVisibleText("1970");
	}
	public void setMonth() {
		Select newmonth=new Select(month);
		newmonth.selectByVisibleText("December");
	}
	public void setDate() {
		Select newdate=new Select(day);
		newdate.selectByVisibleText("11");
	}
	public void setPassword() {
		password.sendKeys("Lokesh99@");
	}
	public void setConfirmPwd() {
		confirmpwd.sendKeys("Lokesh99@");
	}
	public void submit() {
		submit.click();
	}
	

}
