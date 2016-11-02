package fr.arolla.katas.soge.account.domain;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class Account {

    private final Client client;
    private final Amount balance;
    private final AccountType type;

    public Account(Client client, Amount amount, AccountType checking) {
        this.client = client;
        this.balance = amount;
        type = AccountType.CHECKING;
    }

    public AccountType type() {
        return type;
    }

    public Account withdraw(Amount amount) {
        Amount newAmount = balance.withdraw(amount);
        return new Account(client, newAmount, type);
    }

    public Client client() {
        return client;
    }
}