package fr.arolla.katas.soge.account;

import fr.arolla.katas.soge.persistence.TransientAccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class AccountShould {

    @Test
    public void withdraw_when_enought_money() throws Exception {
        // This shall be mock config
        Account account = new Account(new Client("name"), Amount.getEuroAmountFrom(123, 45), AccountType.CHECKING);
        // repo shall save Tx
        // this shall be accountService.withdraw
        account = account.withdraw(Amount.getEuroAmountFrom(100, 00));
        // shall assert Tx saved
        Assertions.assertThat(account).isEqualToComparingFieldByFieldRecursively(
                new Account(new Client("name"), Amount.getEuroAmountFrom(23, 45), AccountType.CHECKING)
        );
    }
}
