package fr.arolla.katas.soge;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Nicolas Fédou on 26/10/2016.
 */
public class HelloWordSteps {
    private Skeleton skeleton;

    @Given("^a simple setup$")
    public void a_simple_setup() throws Throwable {
        skeleton = new Skeleton();
    }

    @When("^I maven verify$")
    public void i_maven_verify() throws Throwable {
        skeleton.sayHi("Specs");
    }

    @Then("^cucmber says \"([^\"]*)\"$")
    public void cucmber_says(String arg1) throws Throwable {
        System.out.println("Easy to understand, not so to setup");
    }

}
