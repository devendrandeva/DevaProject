package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utiles.BaseClass;

public class Search extends BaseClass{

	public Search() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	private WebElement searchbox;

	public WebElement getSearchbox() {
		return searchbox;
	}
	
	
}
