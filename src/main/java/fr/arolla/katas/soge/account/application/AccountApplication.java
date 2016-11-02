package fr.arolla.katas.soge.account.application;

import fr.arolla.katas.soge.account.domain.Account;
import fr.arolla.katas.soge.account.domain.Amount;
import fr.arolla.katas.soge.account.domain.AccountRepository;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class AccountApplication implements AccountService {
    private AccountRepository accountRepository;

    public AccountApplication(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public TransactionResult withdraw(String clientName, String accountType, double amount) {
        // try {
        Amount currentAmount = Amount.getEuroAmountFromEuros(amount);
        Account account = accountRepository.findCheckingAccountForClientByName(clientName);

        Account accountResult = account.withdraw(currentAmount);

        accountRepository.saveTransactionResult(accountResult);

        return new TransactionResult(TransactionStatus.SUCCESS, accountResult);
        // commit; } catch(Ex) { rollback(); return new TR(FAILURE, "Message", null) } finally { close(); }
    }
}
