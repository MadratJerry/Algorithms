import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciSearchTest {

    @RepeatedTest(16)
    void indexOf() {
        int[] array = new int[StdRandom.uniform(10000)];
        for (int i = 0; i < array.length; i++) array[i] = i;
        for (int i = 0; i < array.length; i++) assertEquals(i, FibonacciSearch.indexOf(array, i));
        for (int i = 0; i < array.length; i++) array[i] = StdRandom.uniform(10000);
    }
}
