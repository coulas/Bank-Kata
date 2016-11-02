package fr.arolla.katas.soge.account;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.arolla.katas.soge.account.application.AccountApplication;
import fr.arolla.katas.soge.account.application.AccountService;
import fr.arolla.katas.soge.account.application.TransactionResult;
import fr.arolla.katas.soge.account.application.TransactionStatus;
import fr.arolla.katas.soge.account.domain.*;
import fr.arolla.katas.soge.account.persistence.TransientAccountRepository;
import org.assertj.core.api.Assertions;

/**
 * Created by Nicolas Fédou on 26/10/2016.
 */
public class AccountSteps {
    private String name;
    private AccountRepository accountRepository = new TransientAccountRepository();
    private AccountService accountService = new AccountApplication(accountRepository);
    private TransactionResult checking;

    @Given("^an existing client named \"([^\"]*)\" with ([\\d\\.]+) EUR in his account$")
    public void an_existing_client_named_with_EUR_in_his_account(String name, double amountInEuro) throws Throwable {
        // name argument is a criteria to find or create something in an exernal persistence service
        Account account = accountRepository.createLightCheckingAccount(name, amountInEuro);
        this.name = name;
        // name field stored here shall be an id (account.getUniqueId()) to retrieve the stored, selected thing to use in our tests
    }

    @When("^he withdraws ([\\d\\.]+) EUR from his account$")
    public void he_withdraws_EUR_from_his_account(double amount) throws Throwable {
        checking = accountService.withdraw(this.name, "Checking", amount);
    }

    @Then("^the new balance is ([\\d\\.]+) EUR$")
    public void the_new_balance_is_EUR(double amount) throws Throwable {
        final Account actualAccount = accountRepository.findCheckingAccountForClientByName(this.name);
        final Account expectedAccount = new Account(new Client(this.name), Amount.getEuroAmountFromEuros(amount), AccountType.CHECKING);
        final TransactionResult expectedTransactionResult = new TransactionResult(TransactionStatus.SUCCESS, expectedAccount);

        Assertions.assertThat(actualAccount).isEqualToComparingFieldByFieldRecursively(expectedAccount);
        Assertions.assertThat(checking).isEqualToComparingFieldByFieldRecursively(expectedTransactionResult);
    }

}
