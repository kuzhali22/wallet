import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WalletTest {
    @Test
    void shouldEquateSeventyFourPointEightFiveRupeesToOneDollar() {
        Money seventyFourPointEightFive = Money.rupee(149.7);
        Money oneDollar = Money.dollar(2);

        assertEquals(seventyFourPointEightFive,oneDollar);

    }

    @Test
    void putMoneyIntoWallet() {
        Wallet wallet = new Wallet();
        Money oneDollar = Money.dollar(1);

        wallet.putMoney(oneDollar);

        assertEquals(wallet.totalWalletMoney(),oneDollar);

    }

    @Test
    void putMoreMoneyIntoWallet() {
        Wallet wallet = new Wallet();
        Money tenRupee = Money.rupee(10);
        Money fiveRupee = Money.rupee(5);
        Money fifteenRupee = Money.rupee(15);

        wallet.putMoney(tenRupee);
        wallet.putMoney(fiveRupee);

        assertEquals(wallet.totalWalletMoney(), fifteenRupee);

    }

    @Test
    void takeMoneyFromWallet() {
        Wallet wallet = new Wallet();
        Money tenRupee = Money.rupee(10);
        Money anotherTenRupee = Money.rupee(10);
        wallet.putMoney(tenRupee);
        wallet.putMoney(anotherTenRupee);

        wallet.takeMoney(anotherTenRupee);

        assertEquals(wallet.totalWalletMoney(),tenRupee);

    }
}
