package fr.arolla.katas.soge.account.application;

import java.math.BigDecimal;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public interface AccountService {
    TransactionResult withdraw(String clientName, String accountType, double amount);
}
