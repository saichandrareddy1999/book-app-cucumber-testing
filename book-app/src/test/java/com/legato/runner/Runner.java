package com.legato.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/java/com/legato/features"}, 
								glue= {"com.legato.stepdefinitions"}, 
								plugin= {"pretty","html:target/cucumberTestReport.html","json:target/cucumberJsonReport.json"}, monochrome=true)
public class Runner extends AbstractTestNGCucumberTests{

}
