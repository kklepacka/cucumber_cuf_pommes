package com.example;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = {"com.example"}, // Package with your step definitions and hooks
        plugin = {"pretty", "html:target/cucumber-reports"}, // Generates reports
        monochrome = true // More readable console output
)
public class TestRunner {
}