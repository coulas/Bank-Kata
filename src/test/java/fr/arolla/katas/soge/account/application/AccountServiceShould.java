package fr.arolla.katas.soge.account.application;

import fr.arolla.katas.soge.account.domain.Account;
import fr.arolla.katas.soge.account.domain.Amount;
import fr.arolla.katas.soge.account.domain.Client;
import fr.arolla.katas.soge.account.domain.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import static fr.arolla.katas.soge.account.domain.AccountType.CHECKING;
import static org.mockito.BDDMockito.*;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class AccountServiceShould {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private AccountRepository repo;

    @InjectMocks
    private AccountApplication accountService;

    @Test
    public void withdraw_when_enought_money() throws Exception {
        final String clientName = "name";
        willReturn(new Account(
                                new Client(clientName),
                                Amount.getEuroAmountFromEuros(123.45),
                                CHECKING))
                .given(repo).findCheckingAccountForClientByName(clientName);

        ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);
        willDoNothing().given(repo).saveTransactionResult(captor.capture());

        TransactionResult result = accountService.withdraw(clientName, "Checking", 23.45);

        verify(repo).saveTransactionResult(any(Account.class));
        Assertions.assertThat(captor.getValue())
                .isEqualToComparingFieldByFieldRecursively(new Account(
                        new Client(clientName),
                        Amount.getEuroAmountFromEuros(100.00),
                        CHECKING));
    }
}
