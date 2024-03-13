package com.handson;

import org.testng.annotations.Test;

import com.baseclass.BaseCLass;

public class RegisterTest extends BaseCLass{
	
	Register obj;
	
	@Test
	public void test() {
		obj=new Register(driver);
		obj.setFirstName();
		obj.setLastName();
		obj.setAddress();
		obj.setEmail();
		obj.setPhone();
		obj.setGender();
		obj.setHobbies();
		obj.setLanguage();
		obj.setSkill();
		obj.setCountry();
		obj.setYear();
		obj.setMonth();
		obj.setDate();
		obj.setPassword();
		obj.setConfirmPwd();
		obj.submit();
	}

}
