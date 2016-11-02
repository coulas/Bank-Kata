package fr.arolla.katas.soge.account.persistence;

import fr.arolla.katas.soge.account.domain.Account;
import fr.arolla.katas.soge.account.domain.AccountType;
import fr.arolla.katas.soge.account.domain.Amount;
import fr.arolla.katas.soge.account.domain.Client;
import fr.arolla.katas.soge.account.domain.AccountRepository;

import java.util.HashMap;
import java.util.Map;

import static fr.arolla.katas.soge.account.domain.AccountType.CHECKING;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class TransientAccountRepository implements AccountRepository {
    private Map<String, Client> clients = new HashMap();
    // deserves an internal AccountCache class
    private Map<Client, Map<AccountType, Account>> accounts = new HashMap();

    public Account createLightCheckingAccount(String name, double euros) {
        Client client = findClientByName(name);
        if (client == null) {
            client = createLightClient(name);
        }
        return createLightCheckingAccount(client, Amount.getEuroAmountFromEuros(euros));
    }

    public Client createLightClient(String name) {
        Client client = new Client(name);
        clients.put(name, client);
        return client;
    }

    public void saveTransactionResult(Account account) {
        Map<AccountType, Account> accountsForClient = accounts.get(account.client());
        accountsForClient.put(account.type(), account);
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

    public Account findCheckingAccountForClientByName(String name) {
        Map<AccountType, Account> accountTypeAccountMap = accounts.get(findClientByName(name));
        // that is why we need a class (cf demeter)
        Account account = accountTypeAccountMap.get(CHECKING);
        return account;
    }

}
