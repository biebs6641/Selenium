package com.utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.BaseClass;


public class ExtentReportUtils {

	/*
	 * ExtentTest Object is required to create a Test
	 */
	public static ExtentTest test;

	/*
	 * ExtentReport object is required to create a report.
	 */
	public static ExtentReports report;

	/*
	 * This method is invoked in @BeforeSuite annotation to initialize the report.
	 */
	public static void setUpReport() {
		report = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report/execution.html");
		report.attachReporter(spark);
	}

	/*
	 * Creates the test case, testName parameter accepts name of the @Test method
	 */
	public static void createTest(String testName) {
		test = report.createTest(testName);
	}

	/*
	 * This method adds the step in each test case. In the parameter you can specify
	 * the Message or step
	 */
	public static void addStep(String stepMessage) {
		
		
//		test.info("Some Test Name");
//		test.info("SC1", MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build());
//		test.info("SC2", MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build());
//		
		
		
		
//		String html = stepMessage 
//		        + "<br><b>Screenshot 1:</b><br><img src='data:image/png;base64," + MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build() + "' height='300' width='500'/>"
//		        + "<br><b>Screenshot 2:</b><br><img src='data:image/png;base64," +  MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build()+ "' height='300' width='500'/>";
//
//		    test.info(html);
		
		
//		 String ss1 = captureScreenshot();
//		    String ss2 = captureScreenshot();
//		    String ss3 = captureScreenshot();
//
//		    String html = stepMessage + "<br>"
//		        + "<table><tr>"
//		        + "<td><img src='data:image/png;base64," + ss1 + "' height='250' width='400'/></td>"
//		        + "<td><img src='data:image/png;base64," + ss2 + "' height='250' width='400'/></td>"
//		        + "<td><img src='data:image/png;base64," + ss3 + "' height='250' width='400'/></td>"
//		        + "</tr></table>";
//
//		    test.info(html);
		
		
		String ss1 = captureScreenshot();
	    String ss2 = captureScreenshot();

	    // Build clickable screenshot HTML links
	    String html = stepMessage + "<br>"
	        + "<a href='data:image/png;base64," + ss1 + "' target='_blank'>"
	        + "<img src='data:image/png;base64," + ss1 + "' height='200' width='350' style='margin:5px; border:1px solid #ccc;'/></a>"
	        + "<a href='data:image/png;base64," + ss2 + "' target='_blank'>"
	        + "<img src='data:image/png;base64," + ss2 + "' height='200' width='350' style='margin:5px; border:1px solid #ccc;'/></a>";

	    test.info(html);
		
	}

	

	/*
	 * This method captures the screenshot of application. It is invoked in addStep
	 * method of this class.
	 */
	public static String captureScreenshot() {

		TakesScreenshot screenshot = (TakesScreenshot) BaseClass.driver;

		File file = screenshot.getScreenshotAs(OutputType.FILE);

		byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(file);

		} catch (IOException e) {

		}

		String str = Base64.getEncoder().encodeToString(fileContent);
		System.out.println(str);

		return str;
	}
	
	/*
	 * This methods flushes the report. It is invoked at the end of execution.
	 */

	public static void flushReport() {
		report.flush();
	}

}