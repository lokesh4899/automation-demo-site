package com.handson;

import org.testng.annotations.Test;

import com.baseclass.BaseCLass;

public class FramesTest extends BaseCLass{
	
	Frames obj2;
	
	@Test()
	public void singleIframesTest() {
		obj2=new Frames(driver);
		obj2.switchtoFrames();
		obj2.singleFrame();
	}
	
	@Test
	public void nestedIframesTest() {
		obj2=new Frames(driver);
		obj2.switchtoFrames();
		obj2.nestedFrame();
	}

}
