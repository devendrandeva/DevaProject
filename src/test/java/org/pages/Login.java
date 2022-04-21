package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utiles.BaseClass;

public class Login extends BaseClass {
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement logincancel;

	public WebElement getLogincancel() {
		return logincancel;
	}
	

}
