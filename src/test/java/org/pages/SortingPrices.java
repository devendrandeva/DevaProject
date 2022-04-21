package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utiles.BaseClass;

public class SortingPrices extends BaseClass{
	
	public SortingPrices() {
		PageFactory.initElements(driver, this);	
	}

	@FindBy(xpath="(//div[@class=\"_10UF8M\"])[2]")
	private WebElement lowtohigh;

	public WebElement getLowtohigh() {
		return lowtohigh;
	}
	
}
