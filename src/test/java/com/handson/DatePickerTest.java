package com.handson;

import org.testng.annotations.Test;

import com.baseclass.BaseCLass;

public class DatePickerTest extends BaseCLass{
	
	DatePicker obj;
	
	@Test
	public void test() {
		obj=new DatePicker(driver);
		obj.moveToDatePicker();
		obj.disabledDatePicker();
	}
	
	@Test
	public void test2() {
		obj=new DatePicker(driver);
		obj.moveToDatePicker();
		obj.enabledDatePicker();
	}

}
