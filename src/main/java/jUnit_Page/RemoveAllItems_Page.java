package jUnit_Page;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import base_Page.Base_Page;

public class RemoveAllItems_Page extends Base_Page {

	WebDriver driver;

	public RemoveAllItems_Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input[name='allbox']") WebElement allToggle;
	@FindBy(how = How.CSS, using = "input[value='Remove']") WebElement removeButton;
	@FindBys(@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")) List<WebElement> allBoxes;

	public void userRemoveAllItems() {
		allToggle.click();
		removeButton.click();
	}

	public void validateAllItemsRemoved() throws IOException {

		boolean itemDoesNotExist;

		for (int i = 0; i < allBoxes.size(); i++) {

			try {
				itemDoesNotExist = allBoxes.get(i).isSelected();
			} catch (NoSuchElementException e) {
				itemDoesNotExist = false;
			}

			Assert.assertFalse("Selected boxes were not deleted", itemDoesNotExist);
		}
		
			takeScreenshotAtEndOfTest(driver);

	}
}
