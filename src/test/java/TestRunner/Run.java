package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = "Features" ,
		glue = "Org.OrangeHRM.StepDefnition",
		dryRun =  false ,
		monochrome = true ,
		
		plugin = { "html:target/CucumberReport/report.html"}
		
		)






public class Run extends AbstractTestNGCucumberTests {

}
