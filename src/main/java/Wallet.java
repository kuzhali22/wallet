public class Wallet {

    private final double moneyAmount;

    public Wallet(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public static Wallet createRupee(double rupeeAmount) {

        return new Wallet(rupeeAmount);
    }

    public static Wallet createDollar(double dollarAmount) {

        double dollar = Currency.RUPEE.convertCurrency(dollarAmount);
        return new Wallet(dollar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet money = (Wallet) o;
        return Double.compare(money.moneyAmount, moneyAmount) == 0;
    }


    @Override
    public String toString() {
        return "Money{" +
                "moneyAmount=" + moneyAmount +
                '}';
    }
    /*@Override
    public int hashCode() {
        return Objects.hash(moneyAmount);
    }*/
}
