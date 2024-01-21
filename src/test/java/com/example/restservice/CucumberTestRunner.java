package com.example.restservice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com.example.restservice",
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@your_tag",
        monochrome = true
)
public class CucumberTestRunner {
}