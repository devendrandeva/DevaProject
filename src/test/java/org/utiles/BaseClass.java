package org.utiles;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebElement element;
	
	
	//===================Browser Launch==========================
	public static WebDriver launchBrowser(String browsername) {
		
		if(browsername.equalsIgnoreCase("ChromeBroswer")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browsername.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browsername.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		return driver;
	}
	
	//===================WebDriver Methods==========================
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	//===================WebElement Methods==========================
	
	public static void sendKey(WebElement e, String value) {
		e.sendKeys(value);
	}
	public static void clear(WebElement e) {
		e.clear();
	}
	public static void click(WebElement e) {
		e.click();
	}
	
	//===================Action Class================================
	
	public static void dargandDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	public static void movetoElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}
	public static void doubleclick(WebElement target) {
		Actions a = new Actions(driver);
		a.doubleClick(target).perform();
	}
	public static void rightClick() {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}	
	public static void clickandHold(WebElement target) {
		Actions a = new Actions(driver);
		a.clickAndHold(target);
	}
	
	//===================Robot Class================================
	
	public static void enter() {
		Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void downkey(int how__many_times) throws AWTException {
		Robot r = new Robot();
		
		for(int i=0; i<how__many_times; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	}
	public static void upkey(int how__many_times) throws AWTException {
		Robot r = new Robot();
		
		for(int i=0; i<how__many_times; i++) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}
	}
	public static void selectandCopy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public static void pastetheSelected() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	
	//===================Javascript Executor================================
	
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollintoView(true)", e);
	}
	public static void scrollUp(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollintoView(false)", e);
	}
	public static void jsclick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);
	}
	public static void jsSendkey(WebElement e, String value1) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',"+value1+")", e);
	}
	
	//===================Take Screenshot================================
	
	public static void takesScreenshot(String filelocation) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File(filelocation);
		FileUtils.copyFile(temp, perm);
	}
	
	//===================Select Class================================
	
	public static void selectbyValue(WebElement e,String value) {
		Select s =  new Select(e);
		s.selectByValue(value);
	}
	public static void selectbyIndex(WebElement e,int index) {
		Select s =  new Select(e);
		s.selectByIndex(index);
	}
	public static void selectbyVisibleText(WebElement e,String text) {
		Select s =  new Select(e);
		s.selectByVisibleText(text);
	}
	public static void deselectbyValue(WebElement e,String value) {
		Select s =  new Select(e);
		s.deselectByValue(value);
	}
	public static void deselectbyIndex(WebElement e,int index) {
		Select s =  new Select(e);
		s.deselectByIndex(index);
	}
	public static void deselectbyVisibleText(WebElement e,String text) {
		Select s =  new Select(e);
		s.deselectByVisibleText(text);
	}
	public static List<WebElement> allSelectedOption(WebElement e) {
		Select s =  new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;	
	}
	public static void deSelectAll(WebElement e) {
		Select s =  new Select(e);
		s.deselectAll();	
	}
	
	//==========================================wait================================
	
	public void bcwait(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}