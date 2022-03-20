public enum CurrencyValue {
    DOLLAR(1),
    RUPEE(74.85);

    private final double currencyValue;

    CurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    public double convertDollarToRupee(double moneyValue){
        return moneyValue * this.currencyValue;

    }
}
