import java.util.ArrayList;

public class Wallet {
    private final ArrayList<Money> totalMoney = new  ArrayList<>();

    public void putMoney(Money moneyAmount) {
        totalMoney.add(moneyAmount);
    }

    public Money totalWalletMoney(){
        double totalAmount = 0;
        for (Money money : totalMoney){
            totalAmount += money.moneyAmount;
        }
        return new Money(totalAmount, CurrencyValue.RUPEE);
    }

    public void takeMoney(Money money) throws NotEnoughMoneyInWalletException {
        if(this.totalWalletMoney().moneyAmount < money.moneyAmount){
            throw new NotEnoughMoneyInWalletException();
        }else {
            totalMoney.remove(money);
        }

    }

    public Money totalWalletMoneyInPreferredCurrency(CurrencyValue currencyValue) {
        Money money;
        if(CurrencyValue.DOLLAR == currencyValue) {
             money = new Money(totalWalletMoney().moneyAmount, currencyValue);
        } else{
             money = totalWalletMoney();
        }

        return money;
    }
}
