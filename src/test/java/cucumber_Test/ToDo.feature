@Color
Feature: Validate Background scenario 

@Scenario1 	
Scenario: Sky Blue Background
	Given "Set SkyBlue Background" button exists  
	When "Set SkyBlue Background" I click on the button  
	Then The background color will change to sky blue
	
@Scenario2 
Scenario: White Background Change 
	Given "Set White Background" button exists 
	When "Set White Background" I click on the button 
	Then The background color will change to white