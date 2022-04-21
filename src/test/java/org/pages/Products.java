package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utiles.BaseClass;

public class Products extends BaseClass{

	
	
	
	public Products() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	private WebElement productnames;
	

	public WebElement getProductnames() {
		return productnames;
	}
	
	
	
}
