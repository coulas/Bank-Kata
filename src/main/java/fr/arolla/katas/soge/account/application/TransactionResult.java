package fr.arolla.katas.soge.account.application;

import fr.arolla.katas.soge.account.domain.Account;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class TransactionResult {
    private final TransactionStatus status;
    private final Account account;

    public TransactionResult(TransactionStatus status, Account account) {
        this.status = status;
        this.account = account;
    }
}
