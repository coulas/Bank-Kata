package fr.arolla.katas.soge.account.domain;

import fr.arolla.katas.soge.account.domain.Account;
import fr.arolla.katas.soge.account.domain.AccountType;
import fr.arolla.katas.soge.account.domain.Amount;
import fr.arolla.katas.soge.account.domain.Client;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class AccountShould {

    @Test
    public void withdraw_when_enought_money() throws Exception {
        Account account = new Account(new Client("name"), Amount.getEuroAmountFromEuros(123.45), AccountType.CHECKING);

        account = account.withdraw(Amount.getEuroAmountFromEuros(100.00));

        Assertions.assertThat(account).isEqualToComparingFieldByFieldRecursively(
                new Account(new Client("name"), Amount.getEuroAmountFromEuros(23.45), AccountType.CHECKING)
        );
    }
}
