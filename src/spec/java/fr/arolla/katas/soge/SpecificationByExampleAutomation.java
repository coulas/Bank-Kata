package fr.arolla.katas.soge;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Nicolas Fédou on 25/10/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "classpath:",
        plugin = {"pretty", "html:target/cucumber"})
public class SpecificationByExampleAutomation {
}
