import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @RepeatedTest(16)
    void indexOf() {
        int[] array = new int[StdRandom.uniform(10000)];
        for (int i = 0; i < array.length; i++) array[i] = i;
        for (int i = 0; i < array.length; i++) assertEquals(i, BinarySearch.indexOf(array, i));
    }
}
