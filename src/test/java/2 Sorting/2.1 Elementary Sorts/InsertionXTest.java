import edu.princeton.cs.algs4.InsertionX;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertionXTest {

    @Test
    public void testSort() {
        int size = 100;
        Integer[] a = new Integer[size];
        Integer[] b = new Integer[size];
        for (int i = 0; i < size; i++) a[i] = StdRandom.uniform(size);
        System.arraycopy(a, 0, b, 0, size);
        InsertionX.sort(a);
        Arrays.sort(b);
        Assert.assertArrayEquals(a, b);
    }
}
