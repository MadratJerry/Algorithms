import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class InsertionXTest {

    @RepeatedTest(16)
    void testSort() {
        int size = 100;
        Integer[] a = new Integer[size];
        Integer[] b = new Integer[size];
        for (int i = 0; i < size; i++) a[i] = StdRandom.uniform(size);
        System.arraycopy(a, 0, b, 0, size);
        InsertionX.sort(a);
        edu.princeton.cs.algs4.InsertionX.sort(b);
        Assertions.assertArrayEquals(a, b);
    }
}
