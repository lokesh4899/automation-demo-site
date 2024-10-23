package com.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCLass {
	public static WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		WebDriverManager.edgedriver().setup();
//		EdgeOptions edgeOptions = new EdgeOptions();
//		edgeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		ChromeOptions chropmeoptions=new ChromeOptions();
		chropmeoptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		chropmeoptions.addArguments("--incognito");
		driver=new ChromeDriver(chropmeoptions);
		driver.manage().window().maximize();
		/*ChromeOptions chropmeoptions=new ChromeOptions();
		chropmeoptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		driver=new ChromeDriver(chropmeoptions);
		driver.manage().window().maximize();*/
		driver.get("https://demo.automationtesting.in/Register.html");
	}
	
	@AfterSuite
	public void TearUp() {
		//driver.close();
	}
	

}
