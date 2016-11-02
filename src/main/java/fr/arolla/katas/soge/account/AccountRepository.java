package fr.arolla.katas.soge.account;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public interface AccountRepository {
    Account createLightCheckingAccount(String name, int euros, int cents);

    Account createLightCheckingAccount(Client client, Amount amount);

    Account findCheckingAccountForClient(Client client);

    Client createLightClient(String name);

    Client findClientByName(String name);

    Amount createAmount(int euros, int cents);
}
