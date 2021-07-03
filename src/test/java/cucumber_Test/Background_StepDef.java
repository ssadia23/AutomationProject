package cucumber_Test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber_Page.Color_Page;
import util.BrowserFactory;


public class Background_StepDef {

	WebDriver driver;
	Color_Page colorPage;
	
	@Before
	public void beforeRun() {
		driver= BrowserFactory.inIt();
		colorPage= PageFactory.initElements(driver, Color_Page.class);
	}
	
	String blue = "Set SkyBlue Background";
	String white = "Set White Background";
	
	@Given("^\"([^\"]*)\" button exists$")
	public void button_Exists(String colorButton) {
		
		if(blue.contains(colorButton)) {
			colorButton = colorPage.blueBackgroundButtonExists();
			Assert.assertEquals(colorButton, "Set SkyBlue Background");
		} else if (white.contains(colorButton)) {
			colorButton = colorPage.whiteBackgroundButtonExists();
			Assert.assertEquals(colorButton, "Set White Background");
		} else {
			System.out.println("Either or both button does not exists");
		}
		
	}
	
	@When("^\"([^\"]*)\" I click on the button$")
	public void click_On_The_Button(String colorButton) {
		
		
		if(blue.contains(colorButton)) {
			colorPage.clicksOnBlueBackgroundButton();
		} else if (white.contains(colorButton)) {
			colorPage.clicksOnWhiteBackgroundButton();
		} else {
			System.out.println("Either or both button does not exists");
		}
		
	}
	
	@Then("^The background color will change to sky blue$")
	public void the_Background_Color_Will_Change_To_Sky_Blue() {
		
		String expectedColor = "#efefef";
	    String actualColor = colorPage.validatingBlueBackgroundColor();
	    Assert.assertEquals(expectedColor, actualColor);
			
	    BrowserFactory.tearDown();
	}
	
	@Then("^The background color will change to white$")
	public void the_Background_Color_Will_Change_To_White() {
		String expectedColor = "#ffffff";
	    String actualColor = colorPage.validatingWhiteBackgroundColor();
	    Assert.assertEquals(expectedColor, actualColor);
		
	    BrowserFactory.tearDown();
	    
	}
	
}
