package cucumber_Page;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Color_Page {

	WebDriver driver;

	public Color_Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "button[onclick='myFunctionSky()']")
	WebElement skyBlueButton;
	@FindBy(how = How.CSS, using = "button[onclick = 'myFunctionWhite()']")
	WebElement whiteButton;

	// @FindBy(how = How.CSS, using = "body[style='background-color: skyblue;']")WebElement blueBackground;
	@FindBy(how = How.CSS, using = "body[style='background-color: white;']")WebElement whiteBackground;
	@FindBy(how = How.XPATH, using = "//button[@type='button' and contains (text(),'Set SkyBlue Background')] ") WebElement blueBackground;
	//@FindBy(how = How.XPATH, using = "//button[@type='button' and contains (text(),'Set White Background')] ") WebElement whiteBackground;

	public String blueBackgroundButtonExists() {

		String blue = skyBlueButton.getText();
		return blue;
	}

	public String whiteBackgroundButtonExists() {

		String white = whiteButton.getText();
		return white;
	}

	public void clicksOnBlueBackgroundButton() {
	
		skyBlueButton.click();

	}

	public void clicksOnWhiteBackgroundButton() {
	
		whiteButton.click();
	}

	public String validatingBlueBackgroundColor() {

		String blueBackgroundColor = Color.fromString(blueBackground.getCssValue("background-color")).asHex();
		System.out.println(blueBackgroundColor);
		return blueBackgroundColor;

	}

	public String validatingWhiteBackgroundColor() {
		
		String whiteBackgroundColor = Color.fromString(whiteBackground.getCssValue("background-color")).asHex();
		System.out.println(whiteBackgroundColor);
		return whiteBackgroundColor;
		
	}
}
