public class Money {
    protected final double moneyAmount;
    protected final Currency currencyType;

    public Money(double moneyAmount, Currency currencyType) {
        this.moneyAmount = moneyAmount;
        this.currencyType = currencyType;
    }

    public static Money rupee(double moneyAmount) {
        return new Money(moneyAmount,Currency.RUPEE);
    }

    public static Money dollar(double moneyAmount) {
        double dollar = Currency.RUPEE.convertDollarToRupee(moneyAmount);
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
