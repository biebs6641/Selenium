package com.test;

import org.testng.annotations.Test;

import com.Pages.HomePage;

public class HomePageTest extends BaseClass{
	
	
	@Test
	public void logout()  {
		HomePage hmPage= new HomePage();
		
		hmPage.clickLogOut();
	}
	
	
	
	

}
