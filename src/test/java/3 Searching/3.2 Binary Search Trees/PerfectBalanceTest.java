import org.junit.jupiter.api.Test;

import static interceptor.StdIO.captureOutput;
import static interceptor.StdIO.injectInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PerfectBalanceTest {
    private final static String testWords = "P E R F C T B I N A R Y S R H";

    @Test
    void main() {
        assertEquals(
                "N E B A C H F I R R P R T S Y ",
                captureOutput(() -> injectInput(testWords, PerfectBalance::main))
        );
    }

    @Test
    void perfect() {
        String[]             words = testWords.split(" ");
        BST<String, Integer> bst   = new BST<>();
        captureOutput(() -> PerfectBalance.perfect(bst, words));
        assertEquals(Math.log(words.length + 1) / Math.log(2), bst.height());
    }
}