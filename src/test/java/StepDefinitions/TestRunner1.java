package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",
glue={"StepDefinitions"},
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//plugin = {"html:target/Destination/test1.html"},
tags = "@seven",
monochrome = true)
public class TestRunner1 {

}
