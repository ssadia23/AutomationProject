package jUnit_Page;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import base_Page.Base_Page;


public class RemoveOneItem_Page extends Base_Page {

	WebDriver driver;

	public RemoveOneItem_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "input[name='allbox']")WebElement allToggle;
	@FindBy(how = How.CSS, using = "input[name='todo[2]']")WebElement oneItem;
	@FindBy(how = How.CSS, using = "input[value='Remove']")WebElement removeButton;
	
	public void userClickOnOneItem() {
		allToggle.click();
		oneItem.click();
	
		boolean item = oneItem.isSelected();
		
		Assert.assertTrue("Single box was not clicked", item);
		
	}
	
	public void userRemoveOneItem() {
		removeButton.click();
		
	}
	
	public void validateOneItemRemoved() throws IOException {
		
		boolean itemDoesNotExist;
		
		try {
			itemDoesNotExist = oneItem.isDisplayed();
			} catch (NoSuchElementException e) {
				itemDoesNotExist = false;
			}
		
		Assert.assertFalse("Single selected box was not deleted", itemDoesNotExist);
		
		takeScreenshotAtEndOfTest(driver);
		
	}
	
}
