package fr.arolla.katas.soge.account;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class Amount {
    int amount;
    Devise devise;

    public Amount withdraw(Amount other) {
        if (!devise.equals(other.devise)) {
            throw new IllegalArgumentException("This devise is "+devise+" but other amount's devise is "+other.devise);
        }
        return new Amount(amount - other.amount, devise);
    }

    public enum Devise {
        EURO;
    }
    public static Amount getEuroAmountFrom(int euros, int cents) {
            return new Amount(euros*100+cents, Devise.EURO);
    }

    private Amount(int cents, Devise devise) {
        this.amount = cents;
        this.devise = devise;
    }
}
