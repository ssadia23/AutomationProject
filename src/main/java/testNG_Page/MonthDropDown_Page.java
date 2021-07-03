package testNG_Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base_Page.Base_Page;

public class MonthDropDown_Page extends Base_Page {

	WebDriver driver;
	
	public MonthDropDown_Page(WebDriver driver) {
		this.driver = driver;	
	}
	
	@FindBy(how = How.CSS, using = "select[name = 'due_month']") WebElement MonthDropDown;

	public void validateMonth () {
		
		Select select = new Select(MonthDropDown);
		
		List actualMonthValue = new ArrayList();
		
		for (WebElement element: select.getOptions()) {
			actualMonthValue.add(element.getText());	
		}
		
		List expectedMonthValue = new ArrayList();
		expectedMonthValue.add("None");
		expectedMonthValue.add("Jan");
		expectedMonthValue.add("Feb");
		expectedMonthValue.add("Mar");
		expectedMonthValue.add("Apr");
		expectedMonthValue.add("May");
		expectedMonthValue.add("Jun");
		expectedMonthValue.add("Jul");
		expectedMonthValue.add("Aug");
		expectedMonthValue.add("Sep");
		expectedMonthValue.add("Oct");
		expectedMonthValue.add("Nov");
		expectedMonthValue.add("Dec");
	
		for (int i=0; i < actualMonthValue.size(); i++) {
		
			Assert.assertTrue(actualMonthValue.get(i).equals(expectedMonthValue.get(i)));
			
		}
		System.out.println(expectedMonthValue);
		System.out.println("Drop down has all the months");
		
	
	}


	
	






}
	
