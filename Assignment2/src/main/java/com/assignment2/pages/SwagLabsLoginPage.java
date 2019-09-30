package com.assignment2.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.assignment2.base.Base;
import com.assignment2.util.SelectDropDown;

public class SwagLabsLoginPage extends Base{

	@FindBy(id="user-name")
    WebElement Username;
	
	@FindBy(id="password")
    WebElement Password;
	
	@FindBy(xpath="//input[@value='LOGIN']")
    WebElement Loginbutton;
	
    @FindBy(xpath="//select[@class='product_sort_container']")
	public WebElement Dropdownbox;
    
    @FindBys({@FindBy(xpath="//div[@class='inventory_item_price']")})
    List<WebElement> ItemPrice;
    
    @FindBy(xpath="//button[text()='ADD TO CART']")
    WebElement AddtoCart;
	
	public SwagLabsLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String LoginPageTitle() {
		return driver.getTitle();
	}
	
	 public void loginuser(String un, String pass, WebElement element, String text) {
			
	    	if(Username.isDisplayed() && Password.isDisplayed() && Loginbutton.isEnabled()) {
	    	System.out.println("The Username field is displaying ");
			Username.sendKeys(un);
			
			System.out.println("The Password field is displaying");
			Password.sendKeys(pass);
			
			System.out.println("The login button is displaying");
			Loginbutton.click();
			
	    	} else {
	    		System.out.println("The textbox fields and login button is not available");
	    	}
	    	
	    	if(Dropdownbox.isEnabled()) {
				System.out.println("Dropdown box is displaying");
				Dropdownbox.click();
			    SelectDropDown dp = new SelectDropDown();
				dp.SelectMethod(element, text);
			}
	    	
	    	for(WebElement ele :ItemPrice) {
	    		if(ele.getText().equals("$15.99")) {
	    			AddtoCart.click();
	    		}
	    	}
	    	
	
} 
	 }
	 



