package com.handson;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseCLass;

public class AlertsTest extends BaseCLass{
	
	Alerts obj2;
	
	@Test(priority=0)
	public void testSimpleAlerts() {
		obj2=new Alerts(driver);
		obj2.swichToAlerts();
		obj2.clickonAlertBox();
	}
	
	@Test(priority=1)
	public void testConfirmAlerts() {
		obj2=new Alerts(driver);
		obj2.swichToAlerts();
		obj2.selectConfirmBox();
		obj2.clickOnConfirmBoxAccept();
		Assert.assertEquals("You pressed Ok",obj2.getAlertMsg());
	}
	
	@Test(priority=2)
	public void testConfirmAlertsDismiss() {
		obj2=new Alerts(driver);
		obj2.swichToAlerts();
		obj2.selectConfirmBox();
		obj2.clickOnconfimBoxCancel();
		Assert.assertEquals("You Pressed Cancel",obj2.getAlertMsg());

	}
	
	@Test(priority=3)
	public void testPromptBox() {
		obj2=new Alerts(driver);
		obj2.swichToAlerts();
		obj2.selectPomptBox();
		obj2.clickOnPropmtBoxAccept();
		Assert.assertEquals("Hello john How are you today",obj2.getPromptMsg());

	}
	
	
	
	

}
