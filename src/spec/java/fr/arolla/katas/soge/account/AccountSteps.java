package fr.arolla.katas.soge.account;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.arolla.katas.soge.persistence.TransientAccountRepository;

/**
 * Created by Nicolas Fédou on 26/10/2016.
 */
public class AccountSteps {
    private String name;
    private AccountRepository accountRepository = new TransientAccountRepository();

    @Given("^an existing client named \"([^\"]*)\" with (\\d+)\\.(\\d+) EUR in his account$")
    public void an_existing_client_named_with_EUR_in_his_account(String name, int euros, int cents) throws Throwable {
        // name argument is a criteria to find or create something in an exernal persistence service
        Account account = accountRepository.createLightCheckingAccount(name, euros, cents);
        this.name = name;
        // name field stored here shall be an id (account.getUniqueId()) to retrieve the stored, selected thing to use in our tests
    }

    @When("^he withdraws (\\d+)\\.(\\d+) EUR from his account$")
    public void he_withdraws_EUR_from_his_account(int euros, int cents) throws Throwable {
        // All this algo is a service/application layer algorithm
        Amount amount = accountRepository.createEuroAmount(euros, cents);
        Account account = accountRepository.findCheckingAccountForClient(accountRepository.findClientByName(name));
        Account accountResult = account.withdraw(amount);
        accountRepository.saveTransactionResult(accountResult);
    }

    @Then("^the new balance is (\\d+)\\.(\\d+) EUR$")
    public void the_new_balance_is_EUR(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
