import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionTest {

    @RepeatedTest(16)
    void sort() {
        int       size = 100;
        Integer[] a    = new Integer[size];
        Integer[] b    = new Integer[size];
        for (int i = 0; i < size; i++) a[i] = StdRandom.uniform(size);
        System.arraycopy(a, 0, b, 0, size);
        Selection.sort(a);
        edu.princeton.cs.algs4.Selection.sort(b);
        assertArrayEquals(a, b);
    }
}