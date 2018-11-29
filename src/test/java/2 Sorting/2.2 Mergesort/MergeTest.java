import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeTest extends SortTest {

    @RepeatedTest(16)
    void indexSort() {
        int       size  = StdRandom.uniform(10000);
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++)
            array[i] = StdRandom.uniform(Integer.MAX_VALUE);

        assertArrayEquals(
                edu.princeton.cs.algs4.Merge.indexSort(array),
                Merge.indexSort(array)
        );
    }
}