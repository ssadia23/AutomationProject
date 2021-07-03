package testNG_Page;


import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base_Page.Base_Page;


public class AddCategory_Page extends Base_Page {

	WebDriver driver;
	String category;
	public AddCategory_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "input[name='categorydata']")WebElement addTextBoxField;
	@FindBy(how = How.CSS, using = "input[value='Add category']")WebElement addCategory;
	@FindBys(@FindBy(how = How.CSS, using = "a[title]"))List<WebElement> categoryList;
		
	@FindBy(how = How.CSS, using = "select[name = 'category']") WebElement categoryDropdown;
	@FindBy(how = How.CSS, using = "select[name = 'color']") WebElement categoryColorDropdown;
		
	public void userShouldBeAbleToWriteMsg(String value) {
		
		category = value + randomGenerator(999);
		addTextBoxField.sendKeys(category);
		
	}
	
	public void userShouldBeAbleToAddCategory() {
		
		userShouldBeAbleToWriteMsg("Important");
		addCategory.click();
	}
	
	public void validateCategoryAdded() throws IOException {
		
		int count = categoryList.size();
		WebElement recentCategoryAdded = categoryList.get(count-1);
		String expectedName = recentCategoryAdded.getText();
		System.out.println(expectedName);
		takeScreenshotAtEndOfTest(driver);
		Assert.assertEquals(category, expectedName);

	}
	
}
