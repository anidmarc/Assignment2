package com.assignment2.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.assignment2.base.Base;
import com.assignment2.util.SelectDropDown;

public class SwagLabsPage extends Base{

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
    
    @FindBy(xpath="//div[@id='shopping_cart_container']")
    WebElement ShoppingCart;
    
    @FindBy(xpath="//a[text()='CHECKOUT']")
    WebElement CheckOut;
    
    @FindBy(xpath="//input[@id='first-name']")
    WebElement FirstName;
    
    @FindBy(xpath="//input[@id='last-name']")
    WebElement LastName;
    
    @FindBy(xpath="//input[@id='postal-code']")
    WebElement PostalCode;
    
    @FindBy(xpath="//input[@value='CONTINUE']")
    WebElement ContinueButton;
    
    @FindBy(xpath="//a[text()='FINISH']")
    WebElement FinishButton;
    
    @FindBy(xpath="//h2[@class='complete-header']")
    WebElement Header;
    
	public SwagLabsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	 public void swaglabs(String un, String pass, WebElement element, String text) throws InterruptedException {
			
		 /**The below statements will verify the username and password is displaying if displaying then username and password is retrived 
		  * from the external testdata sheet*/
		 
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
	    	
	    	System.out.println("Page title "+driver.getTitle());
	    	
	    	Thread.sleep(5000);
	    	
	    	  
	    	/**The below statement will verify the sorting dropdown is displaying, then it will sort in low to high order*/
	    	
	    	if(Dropdownbox.isEnabled()) {
				System.out.println("Dropdown box is displaying");
				Dropdownbox.click();
			    SelectDropDown dp = new SelectDropDown();
				dp.SelectMethod(element, text);
			}
	    	
	    	Thread.sleep(10000);
            
	    	/**The below statements will print the number of prize list present and will print all the price list in low to high order*/
	    	
			System.out.println("The number of price list are " + ItemPrice.size());
			System.out.println("The price list in sorted order ");
			for(WebElement allprice : ItemPrice) {
			System.out.println(allprice.getText());	
			}
			
			/**The below statements will add the element in arraylist and will click the third highest price*/
			
			ArrayList<Double> li1 = new ArrayList<Double>();
			for (WebElement ele : ItemPrice) 
			{	
			String pricelisttext = ele.getText().replace("$", "");	
			double result = Double.parseDouble(pricelisttext);
			li1.add(result);
			
			if(ItemPrice.size()==li1.size())
			{
			double element1 = li1.get(2);
			for(int k=0; k<li1.size();k++) {
				if(element1==li1.get(k)){
					int position=k+1;
					driver.findElement(By.cssSelector(".inventory_item:nth-child("+position+") .btn_primary")).click();
			
		    }
		}
	}
}
		/**The below statements verify shopping cart button is diplaying if visible it will click the button*/
			
		if(ShoppingCart.isDisplayed()) {
			System.out.println("Shopping cart button is displaying");
			ShoppingCart.click();
		}else {
			System.out.println("The button is not diplaying");
		}
			
		/**The below statements verify checkout button is diplaying if visible it will click the button*/	
		
		if(CheckOut.isDisplayed()) {
			System.out.println("Checkout button is displaying");
			CheckOut.click();
		}else {
			System.out.println("The button is not diplaying");
		}
		
		/**The below statements verify first,last name and postal code field is enable if enable it will pass the value*/
		
	    if(FirstName.isEnabled() && LastName.isEnabled() && PostalCode.isEnabled()) {
	    System.out.println("The text box fields are visible");
		FirstName.sendKeys("FirstName");
	    LastName.sendKeys("LastName");
	    PostalCode.sendKeys("12345");
	    } else {
	    System.out.println("The fields are not visible");
	    }
	    
	    /**The below statements verify continue button is displaying if displaying it will click the button*/
	    
	    if(ContinueButton.isDisplayed()) {
	    	System.out.println("Continue button is displaying");
	    	ContinueButton.click();
	    } else {
	    	System.out.println("The button is not visible");
	    }
	    
	    /**The below statements verify finish button is displaying if displaying it will click the button*/
	   
	    if(FinishButton.isDisplayed()) {
	    System.out.println("Finish button is displaying");
	    FinishButton.click();
	    } else {
	    	System.out.println("The button is not visible");
	    }
	    
	    /**The below statements will assert the Thankyou heading*/
	    
	    WebElement header = Header;
	    String heading = header.getText();
	    String expectedText = "THANK YOU FOR YOUR ORDER";
	    Assert.assertEquals(heading, expectedText);
	   		
   } 
}
	 



