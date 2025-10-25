package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseClass;
import com.utility.ExtentReportUtils;

public class HomePage {

	@FindBy(xpath = "//a[@href='#/Patient']")
	WebElement PatientButton;

	@FindBy(xpath = "//span[normalize-space(.)='admin']")
	WebElement adminIcon;

	@FindBy(xpath = "//a[normalize-space(.)='Log Out']")
	WebElement logOut;

	public HomePage() {

		
		PageFactory.initElements(BaseClass.driver, this);

	}

	
	public void clickLogOut()  {
		
		adminIcon.click();
		ExtentReportUtils.addStep("ADMIN ICON IS CLICKED");
		
		logOut.click();
		ExtentReportUtils.addStep("LOG OUT IS CLICKED");

	}

}
