package fr.arolla.katas.soge.account;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Nicolas Fédou on 26/10/2016.
 */
public class AccountSteps {

    @Given("^an existing client named \"([^\"]*)\" with (\\d+)\\.(\\d+) EUR in his account$")
    public void an_existing_client_named_with_EUR_in_his_account(String arg1, int arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^he withdraws (\\d+)\\.(\\d+) EUR from his account$")
    public void he_withdraws_EUR_from_his_account(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the new balance is (\\d+)\\.(\\d+) EUR$")
    public void the_new_balance_is_EUR(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
