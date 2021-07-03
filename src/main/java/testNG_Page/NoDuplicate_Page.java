package testNG_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base_Page.Base_Page;

public class NoDuplicate_Page extends Base_Page {

	WebDriver driver;
	String category;
	public NoDuplicate_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "input[name='categorydata']")WebElement addTextBoxField;
	@FindBy(how = How.CSS, using = "input[value='Add category']")WebElement addCategory;
	
	public void userShouldNotBeAbleToAddDulicate() {
		
		category = "Important" + randomGenerator(999);
		addTextBoxField.sendKeys(category);
		addCategory.click();
		addTextBoxField.sendKeys(category);
		addCategory.click();
	
	}
		
	public void validateDuplicateNotCreated() {

		String actualMessage = driver.findElement(By.cssSelector("body")).getText();
		boolean duplicateMessage = actualMessage.contains("The category you want to add already exists");
		Assert.assertTrue(duplicateMessage, "It's not duplicate category");
		System.out.println("Duplicate was not created");
	}
}
