package fr.arolla.katas.soge.account.domain;

import fr.arolla.katas.soge.account.domain.Account;
import fr.arolla.katas.soge.account.domain.Amount;
import fr.arolla.katas.soge.account.domain.Client;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public interface AccountRepository {
    Account createLightCheckingAccount(String name, double euros);

    Account createLightCheckingAccount(Client client, Amount amount);

    Account findCheckingAccountForClientByName(String name);

    Client createLightClient(String name);

    Client findClientByName(String name);

    void saveTransactionResult(Account account);
}
