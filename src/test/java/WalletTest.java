import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WalletTest {
    @Test
    void shouldEquateSeventyFourPointEightFiveRupeesToOneDollar() {
        Wallet seventyFourPointEightFive = Wallet.createRupee(149.7);
        Wallet oneDollar = Wallet.createDollar(2);

        assertEquals(seventyFourPointEightFive,oneDollar);

    }
}
