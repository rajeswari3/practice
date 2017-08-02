package com.mmp.healthcare;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Schedule {
	WebDriver driver;
	
	public Schedule(WebDriver driver){
		this.driver = driver;
	}


	public void navigateToTab(String tabname)
	{
		WebDriverWait wait = new WebDriverWait(driver,120);
		WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+tabname+"')]")));
		e.click();
	}
	
public void createAppointment(){
	driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
}
public String verifyTitle(String text){
	String AppTitle;
	
	AppTitle = driver.findElement(By.xpath("html/head/title")).getText();
	
	if (AppTitle.equals(text)){
		return "Pass";
	} else {
		return "Fail";
	}
}

public void appointment(String sDoctorName,String sDate,String sTime,String sSymptom) throws InterruptedException{
    	driver.findElement(By.xpath("//h4[contains(text(),'"+sDoctorName+ "')]/ancestor::ul/following-sibling::button")).click();
    	Thread.sleep(3000);
    	WebElement frameId = driver.findElement(By.id("myframe"));
    	driver.switchTo().frame(frameId);
    	
			WebElement e = driver.findElement(By.cssSelector("#datepicker"));
			e.click();
			e.sendKeys(sDate);
			e.sendKeys(Keys.TAB);
			e.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		WebElement timeDropdown = driver.findElement(By.id("time"));
        timeDropdown.click();
        new Select(timeDropdown).selectByVisibleText(sTime);
     	driver.findElement(By.id("ChangeHeatName")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement symp = driver.findElement(By.xpath(".//*[@id='sym']"));
		symp.click();
        symp.sendKeys(sSymptom);
        driver.findElement(By.cssSelector(".panel.panel-cascade>div>input")).click(); //Submit button
        

    }
}




		
    
 