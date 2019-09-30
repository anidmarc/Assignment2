package com.assignment2.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.assignment2.base.Base;

public class SelectDropDown extends Base {

	public void SelectMethod(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
}
