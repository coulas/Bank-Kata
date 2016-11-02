package fr.arolla.katas.soge.account;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class Amount {
    public enum Devise {
        EURO;
    }
    int amount;
    Devise devise;
    public Amount(int units, int cents, Amount.Devise devise) {
        this.amount = units*100+cents;
        this.devise = devise;
    }
}
