public enum Currency {
    Dollar(1),
    RUPEE(74.85);

    private double currencyValue;

    Currency(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    public double convertDollarToRupee(double moneyValue){
        return moneyValue * this.currencyValue;

    }
}
