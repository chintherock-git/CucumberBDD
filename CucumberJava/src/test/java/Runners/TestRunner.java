package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Feature",
		glue={"StepDefination", "AppHooks"},
		tags=("@Functional  or @smoke and (not @sanity)"),
				monochrome = true,
				plugin= {"pretty", "junit:target/JUNITReports/report.xml",
				 "json:target/JSONResports/report.json",
				 "html:target/HTMLReports/report.html",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false
)
public class TestRunner {

}
//("@Functional or @Sanity")