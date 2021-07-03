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

public class ToggleAll_Page extends Base_Page {

	WebDriver driver;

	public ToggleAll_Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input[value='Add']")WebElement addButton;
	@FindBy(how = How.CSS, using = "input[name='data']")WebElement addText;
	@FindBy(how = How.CSS, using = "input[name='allbox']")WebElement allToggle;
	@FindBys(@FindBy(how = How.XPATH, using = "//input[@type='checkbox']"))List<WebElement> allBoxes;

	public void addToDoList(String msg) {

		addText.sendKeys(msg + randomGenerator(999));
		addButton.click();
		addText.sendKeys(msg + randomGenerator(999));
		addButton.click();
		addText.sendKeys(msg + randomGenerator(999));
		addButton.click();
		addText.sendKeys(msg + randomGenerator(999));
		addButton.click();
	}

	public void userClicksOnToggle() throws IOException {

		addToDoList("One");
		allToggle.click();

	}

	public void validatingAllToggleBoxChecked() {

		boolean toggleBox = allToggle.isSelected();
		Assert.assertTrue("Toggle button is not checked", toggleBox);

	}

	public void validateAllTheBoxesChecked() throws IOException {
		
		for (int i=0; i<allBoxes.size(); i++) {
			
			boolean checkAllBoxes = allBoxes.get(i).isSelected();
			Assert.assertTrue("Not all boxes are checked", checkAllBoxes);
			
			takeScreenshotAtEndOfTest(driver);
		}

	}
	
}
