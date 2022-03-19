import java.util.ArrayList;

public class Wallet {
    public ArrayList<Money> totalMoney = new  ArrayList<>();

    public void putMoney(Money moneyAmount) {
        totalMoney.add(moneyAmount);
    }

    public Money totalWalletMoney(){
        double newMoneyAmount = 0;
        for (Money money : totalMoney){
            newMoneyAmount += money.moneyAmount;
        }
        return new Money(newMoneyAmount);
    }

    public void takeMoney(Money money) {
        totalMoney.remove(money);

    }

}
