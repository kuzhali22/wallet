import java.util.ArrayList;

public class Wallet {
    private ArrayList<Money> totalMoney = new  ArrayList<>();

    public void putMoney(Money moneyAmount) {
        totalMoney.add(moneyAmount);
    }

    public Money totalWalletMoney(){
        double newMoneyAmount = 0;
        for (Money money : totalMoney){
            newMoneyAmount += money.moneyAmount;
        }
        return new Money(newMoneyAmount,Currency.RUPEE);
    }

    public void takeMoney(Money money) throws NotEnoughMoneyInWalletException {
        if(this.totalWalletMoney().moneyAmount < money.moneyAmount){
            throw new NotEnoughMoneyInWalletException();
        }else {
            totalMoney.remove(money);
        }

    }

    public Money totalWalletMoneyInDollar() {
        double totalMoneyAmount = 0;
        for (Money money : totalMoney){
            totalMoneyAmount += money.moneyAmount;
        }
        return new Money(totalMoneyAmount,Currency.Dollar);
    }
}
