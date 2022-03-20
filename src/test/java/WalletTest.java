import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class WalletTest {
    @Test
    void shouldEquateSeventyFourPointEightFiveRupeesToOneDollar() {
        Money seventyFourPointEightFive = Money.rupee(74.85);
        Money oneDollar = Money.dollar(1);

        assertEquals(seventyFourPointEightFive,oneDollar);

    }

    @Test
    void shouldPutMoneyIntoWallet() {
        Wallet wallet = new Wallet();
        Money oneDollar = Money.dollar(1);
        Money twoDollar = Money.dollar(2);
        Money threeDollar = Money.dollar(3);

        wallet.putMoney(oneDollar);
        wallet.putMoney(twoDollar);

        assertEquals(wallet.totalWalletMoney(),threeDollar);

    }

    @Test
    void shouldPutMoreMoneyIntoWallet() {
        Wallet wallet = new Wallet();
        Money tenRupee = Money.rupee(10);
        Money fiveRupee = Money.rupee(5);
        Money fifteenRupee = Money.rupee(15);

        wallet.putMoney(tenRupee);
        wallet.putMoney(fiveRupee);

        assertEquals(wallet.totalWalletMoney(), fifteenRupee);

    }

    @Test
    void shouldTakeMoneyFromWallet() throws NotEnoughMoneyInWalletException {
        Wallet wallet = new Wallet();
        Money tenRupee = Money.rupee(10);
        Money anotherTenRupee = Money.rupee(10);
        wallet.putMoney(tenRupee);
        wallet.putMoney(anotherTenRupee);

        wallet.takeMoney(anotherTenRupee);

        assertEquals(wallet.totalWalletMoney(),tenRupee);

    }

    @Test
    void shouldNotTakeMoneyFromWalletWhenWalletDoesNotHaveEnoughMoney() {
        Wallet wallet = new Wallet();
        Money tenRupee = Money.rupee(10);
        Money twentyRupee = Money.rupee(20);
        wallet.putMoney(tenRupee);

        assertThrows(NotEnoughMoneyInWalletException.class, ( ) ->wallet.takeMoney(twentyRupee));

    }

    @Test
    void shouldEquateTotalMoneyInWalletInRupeesEqualToHundredAndTwentyFourPointEightFive() {
        Wallet wallet = new Wallet();
        Money fiftyRupee = Money.rupee(50);
        Money oneDollar = Money.dollar(1);
        Money hundredAndTwentyFourPointEightFive = Money.rupee(124.85);

        wallet.putMoney(fiftyRupee);
        wallet.putMoney(oneDollar);

        assertEquals(wallet.totalWalletMoneyInPreferredCurrency(CurrencyValue.RUPEE),hundredAndTwentyFourPointEightFive);
    }

    @Test
    void shouldEquateTotalMoneyInWalletInDollarEqualToFour() {
        Wallet wallet = new Wallet();
        Money seventyFourPointEightFive = Money.rupee(74.85);
        Money oneDollar = Money.dollar(1);
        Money hundredAndFortyNinePointSeven = Money.rupee(149.7);
        Money fourDollar = Money.dollar(4);

        wallet.putMoney(seventyFourPointEightFive);
        wallet.putMoney(oneDollar);
        wallet.putMoney(hundredAndFortyNinePointSeven);

        assertEquals(wallet.totalWalletMoneyInPreferredCurrency(CurrencyValue.DOLLAR),fourDollar);
    }

}
