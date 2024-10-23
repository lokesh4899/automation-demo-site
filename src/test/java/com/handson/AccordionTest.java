package com.handson;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseCLass;

public class AccordionTest extends BaseCLass{
	
	Accordion obj;
	
	
	@Test
	public void ClosingAccordion() {
		obj=new Accordion(driver);
		obj.moveToAccordion();
		obj.collapsible1();
		String str=obj.readabilityMsg.getAttribute("aria-expanded");
		Assert.assertEquals(str,"false");
	}
	
	@Test
	public void test2() {
		obj=new Accordion(driver);
		obj.moveToAccordion();
		obj.collapsible2();
		String str=obj.slcMsg.getAttribute("aria-expanded");
		Assert.assertEquals(str,"true");
	}
	
	@Test
	public void Test3() {
		obj=new Accordion(driver);
		obj.moveToAccordion();
		obj.collapsible1();
		obj.Acc();
		if(obj.readabilityMsg.isDisplayed()) {
			Assert.assertEquals("This Automation Testing API is very simple to read and understand. Every method in this is self explanatory. If a layman looks into this code/script can understand what is happening. You can read the automation script like manual test case.",obj.readabilityMessage());
		}
		if(obj.slcMsg.isDisplayed()) {
			Assert.assertEquals("In this Automation tool, each and every functionality will be achieved by Single line code. i.e. Selecting a Value from dropdown, Switching between windows and Drag and Drop functionality etc...",obj.singleLineCodingMessage());
		}
		if(obj.chainingMsg.isDisplayed()) {
			Assert.assertEquals("As the name indicates, you can chain the methods without breaking the code i.e. you can write the code for each element continuously.",obj.methodChainingMessage());
		}
		if(obj.crossBrowserMsg.isDisplayed()) {
			Assert.assertEquals("NTest your web application across the most popular browsers including Firefox,Chrome and Internet Explorer to validate the functionality. You can easily switch between the browsers without changing the code.",obj.crossBrowserTestingMessage());
		}
	}
	

}
