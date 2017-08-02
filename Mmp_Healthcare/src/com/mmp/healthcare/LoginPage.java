package com.mmp.healthcare;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void patientLogin() throws InterruptedException{
		
		verifyTitle("NAMTG");
		clickElement(".//*[@id='navigation']//*[text()='Patient Login']");
		clickElement(".//*[@id='testimonials']//*[text()='Login']");
		verifyTitle("Login");
		typeText(".//*[@id='username']", "TomBrady_123");
		typeText(".//*[@id='password']","TomBrady@123");
		clickBtn("//*[@id='login']//*[@name='submit']");
		
	}
	
	public void navigateToTab(String tabname)
	{
		WebDriverWait wait = new WebDriverWait(driver,120);
		WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+tabname+"')]")));
		System.out.println("//span[contains(text(),'"+tabname+"')]");
		e.click();
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
	
	
	public void clickElementText(String linkText,int mSeconds) throws InterruptedException{
		driver.findElement(By.linkText(linkText)).click();
		Thread.sleep(mSeconds);
	}
	 
	public void clearText(String xPath){
		driver.findElement(By.xpath(xPath)).clear();
	}
	
	public void typeText(String xPath, String text){
		driver.findElement(By.xpath(xPath)).sendKeys(text);
	}
	
	public void clickElement(String xPath) throws InterruptedException{
		driver.findElement(By.xpath(xPath)).click();
		Thread.sleep(3000);
	}
	public void clickBtn(String xPath) throws InterruptedException{
		WebElement ele = driver.findElement(By.xpath(xPath));
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
 
	
	public void closeBrowser(){
		driver.quit();
	}
	
	public String verifyText(String xp, String text){
		String fAppText;
		
		fAppText = driver.findElement(By.xpath(xp)).getText();
		
		if (fAppText.equals(text)){
			return "Pass";
		} else {
			return "Fail";
		}
	}
	
	public String verifyValue(String xp, String text){
		String fAppText;
		
		fAppText = driver.findElement(By.xpath(xp)).getAttribute("value");
		
		if (fAppText.equals(text)){
			return "Pass";
		} else {
			return "Fail";
		}
	}
}
