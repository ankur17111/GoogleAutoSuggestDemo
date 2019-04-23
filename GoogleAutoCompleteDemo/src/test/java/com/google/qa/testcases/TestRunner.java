package com.google.qa.testcases;
import org.testng.TestNG;
import com.qa.ExtentReportListener.ExtentReportListener;

public class TestRunner {
	
	static TestNG testNg;
	static ExtentReportListener ext;

	public static void main(String[] args) {
		 
		testNg = new TestNG();
		ext = new ExtentReportListener();
		testNg.setTestClasses(new Class[] {HomePageTest.class});
		testNg.addListener(ext);
		testNg.run();
	}

}
