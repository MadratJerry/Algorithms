import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InversionsTest {
    static <Key extends Comparable<Key>> long brute(Key[] a) {
        long inversions = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[j].compareTo(a[i]) < 0) inversions++;
        return inversions;
    }

    @RepeatedTest(16)
    void count() {
        int       size = StdRandom.uniform(10000);
        Integer[] a    = new Integer[size];
        Integer[] b    = new Integer[size];
        for (int i = 0; i < size; i++) a[i] = b[i] = StdRandom.uniform(Integer.MAX_VALUE);
        assertEquals(brute(a), Inversions.count(b));
    }
}