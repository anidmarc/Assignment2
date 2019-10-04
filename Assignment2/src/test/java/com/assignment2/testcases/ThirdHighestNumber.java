package com.assignment2.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThirdHighestNumber {

	
		static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {
			
		
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();

			driver.get("https://www.saucedemo.com/inventory.html");
			
			
			
			Thread.sleep(10000);
			
			
			
			List<WebElement> pricelist = driver.findElements(By.xpath(".//div[@class='inventory_item_price']"));
			System.out.println("price list are :- " + pricelist.size());
			
			
		
			
			ArrayList<Double> li1 = new ArrayList<Double>();
			
			
			
			
			for (WebElement ImgItr : pricelist) {
				
				String pricelisttext = ImgItr.getText().replace("$", "");
				
				System.out.println("price list text are :"+pricelisttext);
				
				double result = Double.parseDouble(pricelisttext);
				System.out.println("result is :"+result);
				
				li1.add(result);
				Collections.sort(li1); 
				
				System.out.println("sorted list is :"+li1);
				
			
		
			
			
			
			if(pricelist.size()==li1.size())
			{
				double element = li1.get(li1.size()-3);  
				
				System.out.println("elements are :"+element);
				
				if(element==li1.get(li1.size()-3))
				{
					int pos1 =li1.indexOf(element);
				System.out.println("Test" + pos1);
				pos1= pos1+1;
					System.out.println("pass");
					//driver.findElement(By.cssSelector(".inventory_item:nth-child("+pos1+") .btn_primary")).click();
					//driver.findElement(By.xpath(".//div[contains(text(),'"+pos1+"')]//following-sibling::button[contains(text(),'ADD TO CART')]")).click();
					
				}
				
			}
//			System.out.println("Print size"+li1.size());
//			double element = li1.get(li1.size()-3);  
//			for(int k=1; k<li1.size();k++) {
//				if(element==li1.get(k)){
//					System.out.println(li1.get(k));
//				}
//			}
//			
		}
			System.out.println("Print size"+li1.size());
			double element = li1.get(li1.size()-3);  
			for(int k=0; k<li1.size();k++) {
				if(element==li1.get(k)){
					int p=k+1;
					System.out.println(p);
					driver.findElement(By.cssSelector(".inventory_item:nth-child("+p+") .btn_primary")).click();
			
		}

}
		}
}