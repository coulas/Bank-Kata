package fr.arolla.katas.soge.persistence;

import fr.arolla.katas.soge.account.Account;
import fr.arolla.katas.soge.account.AccountRepository;
import fr.arolla.katas.soge.account.Client;
import org.assertj.core.api.Assertions;
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
        Account createdAccount = repo.createLightCheckingAccount(clientName, 123, 45);
        Client client = repo.findClientByName(clientName);
        Account retrievedAccount = repo.findCheckingAccountForClient(client);
        assertThat(retrievedAccount).isEqualToComparingFieldByFieldRecursively(createdAccount);
    }

    @Test
    public void should_retrieve_last_created_objects() throws Exception {
        String clientName = "name";
        Account createdAccount = repo.createLightCheckingAccount(clientName, 123, 45);
        Account lastCreatedAccount = repo.createLightCheckingAccount(clientName, 678, 90);
        Client client = repo.findClientByName(clientName);
        Account retrievedAccount = repo.findCheckingAccountForClient(client);
        assertThat(retrievedAccount).isEqualToComparingFieldByFieldRecursively(lastCreatedAccount);
    }

}
