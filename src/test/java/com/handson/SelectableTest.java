package com.handson;

import org.testng.annotations.Test;

import com.baseclass.BaseCLass;

public class SelectableTest extends BaseCLass{
	Selectable obj;
	
	@Test
	public void test1() {
		obj=new Selectable(driver);
		obj.moveToSelectable();
		obj.defaultSelection();
	}
	
	@Test
	public void test2() {
		obj=new Selectable(driver);
		obj.moveToSelectable();
		obj.serializeSelection();
		
	}

}
