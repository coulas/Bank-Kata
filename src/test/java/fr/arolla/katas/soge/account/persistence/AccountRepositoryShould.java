package fr.arolla.katas.soge.account.persistence;

import fr.arolla.katas.soge.account.domain.Account;
import fr.arolla.katas.soge.account.domain.AccountRepository;
import fr.arolla.katas.soge.account.domain.Client;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class AccountRepositoryShould {
    static AccountRepository repo = new TransientAccountRepository();

    @Test
    public void should_retrieve_created_objects() throws Exception {
        String clientName = "name";
        Account createdAccount = repo.createLightCheckingAccount(clientName, 12345);
        Account retrievedAccount = repo.findCheckingAccountForClientByName(clientName);
        assertThat(retrievedAccount).isEqualToComparingFieldByFieldRecursively(createdAccount);
    }

    @Test
    public void should_retrieve_last_created_objects() throws Exception {
        String clientName = "name";
        Account createdAccount = repo.createLightCheckingAccount(clientName, 12345);
        Account lastCreatedAccount = repo.createLightCheckingAccount(clientName, 67890);
        Account retrievedAccount = repo.findCheckingAccountForClientByName(clientName);
        assertThat(retrievedAccount).isEqualToComparingFieldByFieldRecursively(lastCreatedAccount);
    }

}
