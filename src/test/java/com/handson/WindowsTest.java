package com.handson;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseCLass;

public class WindowsTest extends BaseCLass{
	
	Windows obj2;
	
	@Test(priority=4)
	public void newTabTest() {
		obj2=new Windows(driver);
		obj2.switchToWindows();
		obj2.newTab();
		Assert.assertEquals("Frames & Windows",driver.getTitle());
	}
	
	@Test
	public void sepearateWindow() {
		obj2=new Windows(driver);
		obj2.switchToWindows();
		obj2.newWindow();
		Assert.assertEquals("Frames & Windows",driver.getTitle());

	}

	@Test
	public void multipleWindows() {
		obj2=new Windows(driver);
		obj2.switchToWindows();
		obj2.multipleWindow();
		Assert.assertEquals("Frames & Windows",driver.getTitle());

	}

}
