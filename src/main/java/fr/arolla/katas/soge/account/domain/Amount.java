package fr.arolla.katas.soge.account.domain;

/**
 * Created by Nicolas Fédou on 02/11/2016.
 */
public class Amount {
    private final int amount;
    private final Devise devise;

    public enum Devise {
        EURO;
    }

    public static Amount getEuroAmountFromCents(int amountInCents) {
        return new Amount(amountInCents, Devise.EURO);
    }

    public static Amount getEuroAmountFromEuros(double amountInEuros) {
        // may need a look at (int)(amount*100), it may be more efficient and harder to debug.
        return new Amount(new Double(amountInEuros*100).intValue(), Devise.EURO);
    }

    private Amount(int cents, Devise devise) {
        this.amount = cents;
        this.devise = devise;
    }

    public Amount withdraw(Amount other) {
/*        if (!devise.equals(other.devise)) {
            throw new IllegalArgumentException("This devise is "+devise+" but other amount's devise is "+other.devise);
        }*/
        return new Amount(amount - other.amount, devise);
    }
}
