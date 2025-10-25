package com.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.Pages.Login;

public class LoginTest extends  BaseClass{

	@Test
	public void loginwith() throws InvalidFormatException, IOException {
		Login logApp = new Login();
		logApp.login();
		
	}
	
	
	
}
