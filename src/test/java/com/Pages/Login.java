package com.Pages;

import java.io.IOException;
import java.time.Duration;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.BaseClass;
import com.utility.ExcelUtility;
import com.utility.ExtentReportUtils;
import com.utility.propertiesUtility;

public class Login {
	
	//user Name
	@FindBy(id ="username_id") WebElement username;
	
	@FindBy(id="password") WebElement password;

	@FindBy(id="login") WebElement loginButton;
	

	public Login() {
		
		PageFactory.initElements(BaseClass.driver, this);
		
	}
	 
	
	Logger log = LogManager.getLogger(Login.class);
	
	public void login() throws InvalidFormatException, IOException {
//		
//		username.sendKeys(ExcelUtility.getData(1, 0));
//		password.sendKeys(ExcelUtility.getData(1, 1));
		
		

		username.sendKeys(propertiesUtility.getdata("user"));
		log.info("UserName is entered in the field");
		ExtentReportUtils.addStep("UserName is entered in the field");
		
		password.sendKeys(propertiesUtility.getdata("pass"));
		log.info("PassWord is entered in the field");
		ExtentReportUtils.addStep("PassWord is entered in the field");
		
		
		loginButton.click();
		ExtentReportUtils.addStep("Login Button is clicked");
		
		
		
		try {
	        WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
	        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Cancel']")));
	        elem.click();
	    } catch (TimeoutException e) {
	        System.out.println("Cancel button not found or not clickable within 10 seconds.");
	    }
		
		

		
		
	}
}
