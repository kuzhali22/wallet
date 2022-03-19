public class Money {
    protected final double moneyAmount;

    public Money(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Money(double moneyAmount, Currency currencyType) {
        this.moneyAmount = moneyAmount;

    }

    public static Money rupee(double moneyAmount) {
        return new Money(moneyAmount,Currency.RUPEE);
    }

    public static Money dollar(double moneyAmount) {
        double dollar = Currency.RUPEE.convertCurrency(moneyAmount);
        return new Money(dollar,Currency.Dollar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return money.moneyAmount == moneyAmount;
    }


    @Override
    public String toString() {
        return "Money{" +
                "moneyAmount=" + moneyAmount +
                '}';
    }
}
