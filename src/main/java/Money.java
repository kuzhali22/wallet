public class Money {
    protected final double moneyAmount;
    protected final CurrencyValue currencyType;

    public Money(double moneyAmount, CurrencyValue currencyType) {
        this.moneyAmount = moneyAmount;
        this.currencyType = currencyType;
    }

    public static Money rupee(double moneyAmount) {
        return new Money(moneyAmount, CurrencyValue.RUPEE);
    }

    public static Money dollar(double moneyAmount) {
        double dollar = CurrencyValue.RUPEE.convertDollarToRupee(moneyAmount);
        return new Money(dollar, CurrencyValue.DOLLAR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return money.moneyAmount == moneyAmount;
    }

}
