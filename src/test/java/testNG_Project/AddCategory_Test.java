package testNG_Project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import testNG_Page.AddCategory_Page;
import testNG_Page.MonthDropDown_Page;
import testNG_Page.NoDuplicate_Page;
import util.BrowserFactory;

public class AddCategory_Test {

	WebDriver driver;

	@Test
	public void userAddCategory() throws IOException  {
		driver = BrowserFactory.inIt();

		AddCategory_Page addCategory = PageFactory.initElements(driver, AddCategory_Page.class);
			addCategory.userShouldBeAbleToAddCategory();
			addCategory.validateCategoryAdded();
			
			
		NoDuplicate_Page noDuplicate = PageFactory.initElements(driver, NoDuplicate_Page.class);	
			noDuplicate.userShouldNotBeAbleToAddDulicate();
			noDuplicate.validateDuplicateNotCreated();
		
		MonthDropDown_Page monthDropDown = PageFactory.initElements(driver, MonthDropDown_Page.class);
			monthDropDown.validateMonth();
			BrowserFactory.tearDown();
	}
	
}
