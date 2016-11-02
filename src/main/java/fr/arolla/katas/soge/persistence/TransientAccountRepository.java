package fr.arolla.katas.soge.persistence;

import fr.arolla.katas.soge.account.*;

import java.util.HashMap;
import java.util.Map;

import static fr.arolla.katas.soge.account.AccountType.CHECKING;
import static fr.arolla.katas.soge.account.Amount.Devise.EURO;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class TransientAccountRepository implements AccountRepository {
    private Map<String, Client> clients = new HashMap();
    // deserves an internal AccountCache class
    private Map<Client, Map<AccountType, Account>> accounts = new HashMap();

    public Account createLightCheckingAccount(String name, int euros, int cents) {
        Client client = findClientByName(name);
        if (client == null) {
            client = createLightClient(name);
        }
        return createLightCheckingAccount(client, createAmount(euros, cents));
    }

    public Client createLightClient(String name) {
        Client client = new Client(name);
        clients.put(name, client);
        return client;
    }

    public Amount createAmount(int euros, int cents) {
        return new Amount(euros, cents, EURO);
    }

    public Account createLightCheckingAccount(Client client, Amount amount) {
        Account account = new Account(client, amount, AccountType.CHECKING);
        // acc.get is null, then create, else add
        Map<AccountType, Account> accountsForClient = accounts.get(client);
        if (accountsForClient == null) {
            accountsForClient = new HashMap<AccountType, Account>();
            accounts.put(client, accountsForClient);
        }
        accountsForClient.put(account.type(), account);
        return account;
    }

    public Client findClientByName(String name) {
        return clients.get(name);
    }

    public Account findCheckingAccountForClient(Client client) {
        // that is why we need a class (cf demeter)
        Map<AccountType, Account> accountTypeAccountMap = accounts.get(client);
        Account account = accountTypeAccountMap.get(CHECKING);
        return account;
    }

}
