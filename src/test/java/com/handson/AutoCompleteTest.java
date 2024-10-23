package com.handson;

import org.testng.annotations.Test;

import com.baseclass.BaseCLass;

public class AutoCompleteTest extends BaseCLass{
	
	AutoComplete obj;
	
	@Test
	public void test2() {
		obj=new AutoComplete(driver);
		obj.moveToAutoComplete();
		obj.autoSuggest();
	}

}
