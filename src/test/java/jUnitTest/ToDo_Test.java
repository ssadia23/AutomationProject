package jUnitTest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import jUnit_Page.RemoveAllItems_Page;
import jUnit_Page.RemoveOneItem_Page;
import jUnit_Page.ToggleAll_Page;
import util.BrowserFactory;

public class ToDo_Test {

	WebDriver driver;

	@Test
	public void toDoTasks() throws IOException, InterruptedException {
		driver = BrowserFactory.inIt();

		ToggleAll_Page toggle_Page = PageFactory.initElements(driver, ToggleAll_Page.class);
			toggle_Page.userClicksOnToggle();
			toggle_Page.validatingAllToggleBoxChecked();
			toggle_Page.validateAllTheBoxesChecked();
		
		RemoveOneItem_Page oneItem_Page = PageFactory.initElements(driver, RemoveOneItem_Page.class);
			oneItem_Page.userClickOnOneItem();
			oneItem_Page.userRemoveOneItem();
			oneItem_Page.validateOneItemRemoved();
			

		RemoveAllItems_Page allItem_Page = PageFactory.initElements(driver, RemoveAllItems_Page.class);
			allItem_Page.userRemoveAllItems();
			allItem_Page.validateAllItemsRemoved();
			BrowserFactory.tearDown();
	}
	

}
