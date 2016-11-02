package fr.arolla.katas.soge.account;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static fr.arolla.katas.soge.account.AccountType.CHECKING;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class AccountServiceShould {

    @Test
    public void withdraw_when_enought_money() throws Exception {
        // This shall be mock config
        //   go find Account(new Client("name"), Amount.getEuroAmountFrom(123, 45), CHECKING);
        //   repo shall save Tx
        // TransactionResult result = accountService.withdraw("name", CHECKING, Amount.getEuroAmountFrom(100, 00));
        // shall assert Tx saved
    }
}
