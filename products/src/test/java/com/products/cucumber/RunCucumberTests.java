package com.products.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "I:/Spring boot application/products/src/main/resources", // Location of your feature files
        glue = "com.products.cucumber",  // Package containing your step definitions
        plugin = {"pretty", "html:target/cucumber-reports"} // Plugins for reporting  Configuration
                // for Cucumber plugins, such as specifying "pretty" for human-readable reports
                // and "html:target/cucumber-reports" for HTML reports.
)
public class RunCucumberTests {
}
