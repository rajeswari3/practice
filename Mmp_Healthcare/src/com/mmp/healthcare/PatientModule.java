package com.mmp.healthcare;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PatientModule {      
	public WebDriver driver;
	LoginPage lPage;
	Schedule sPage ;
	  
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		lPage = new LoginPage(driver);
		sPage= new Schedule(driver);
		}
	@Test
	public void scheduleAppt() throws InterruptedException{
		lPage.patientLogin();
	    sPage.navigateToTab("Schedule Appointment");
	    sPage.createAppointment();
	    sPage.appointment("Dr.Beth","08/09/2017","12Pm", "general checkup");
	   
	}
	
	}
	
		

	
        
	




	
	
		
	
