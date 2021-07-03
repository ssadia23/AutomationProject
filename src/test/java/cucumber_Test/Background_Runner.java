package cucumber_Test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="./src/test/java/cucumber_Test/ToDo.feature", 
		glue="cucumber_Test", 
		tags ="@Color",
		monochrome=true, 
		dryRun=false, 
		plugin= { "pretty", "html:target/cucumber", "json:target/cucumber.json" } 
		
		)

public class Background_Runner {

}
