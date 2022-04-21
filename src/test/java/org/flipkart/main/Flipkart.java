package org.flipkart.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pages.Login;
import org.pages.Search;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utiles.BaseClass;

public class Flipkart extends BaseClass {

	@BeforeClass
	private void beforeClass() {
		launchBrowser("ChromeBroswer");
}
	@BeforeMethod
	private void beforeMethod() {
		Date d = new Date();
		System.out.println("The start date is "+d);
	}

	@Test
	private void Test1() {
		launchUrl("https://www.flipkart.com/");
		bcwait(5);
		Login l= new Login();
		l.getLogincancel().click();
		Search s = new Search();
		sendKey(s.getSearchbox(), "iphone12");
		enter();
		bcwait(3);
	}
	
	@Test
	private void Test2() {
		List<WebElement> findElement = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for(WebElement x:findElement) {
			System.out.println(x.getText());
		}
	}
	
	@Test
	private void Test3() {
		
		List<Integer> l= new ArrayList<Integer>();
		List<WebElement> findElement = driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
		for(WebElement y:findElement) {
			String prices = y.getText();
			String prq= (prices.substring(1));
			String ps = prq.replaceAll(",", "");
			int p = Integer.parseInt(ps);
			l.add(p);
		}
	 
		int[] a = new int[l.size()];
		
		for(int i=0; i < l.size(); i++) {
			a[i] = l.get(i);
		}
		for(int i=0; i<l.size(); i++)
		{
			for (int j=i+1; j<l.size(); j++) {
				if(a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int i=0; i<l.size()-1; i++) {
			System.out.println(a[i]);
		}
		System.out.println(a[l.size()-1]);
		}
	
	
	@Test
	private void test4() {
		
		List<Integer> l= new ArrayList<Integer>();
		List<WebElement> findElement = driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
		for(WebElement y:findElement) {
			String prices = y.getText();
			String prq= (prices.substring(1));
			String ps = prq.replaceAll(",", "");
			int p = Integer.parseInt(ps);
			l.add(p);
		}
	 
		int[] a = new int[l.size()];
		
		for(int i=0; i < l.size(); i++) {
			a[i] = l.get(i);
		}
		for(int i=0; i<l.size(); i++)
		{
			for (int j=i+1; j<l.size(); j++) {
				if(a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
			System.out.println("The Minimum Number is "+a[0]);
		
			System.out.println("The Maximum Number is "+a[l.size()-1]);
		}
		

	
	
	
	@AfterMethod
	private void afterMethod() {
		Date d = new Date();
		System.out.println("The End date is "+d);
	}
	
	@AfterClass
	private void afterClass() {
		
	}
}