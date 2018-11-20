import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchDuplicatedTest {

    @Test
    void indexOfMin() {
        int[] array = new int[]{0, 0, 0, 1, 1, 1, 1};
        assertEquals(3, BinarySearchDuplicated.indexOfMin(array, 1));
    }

    @RepeatedTest(16)
    void indexOfMinRandomTest() {
        int[] array = new int[StdRandom.uniform(10000)];
        for (int i = 0; i < array.length; i++) array[i] = StdRandom.uniform(Integer.MAX_VALUE);
        Arrays.sort(array);
        int[] duplicated = new int[array.length];
        duplicated[0] = 0;
        for (int i = 1; i < array.length; i++) duplicated[i] = array[i] == array[i - 1] ? duplicated[i - 1] : i;
        for (int i = 0; i < array.length; i++)
            assertEquals(duplicated[i], BinarySearchDuplicated.indexOfMin(array, array[i]));
    }

    @Test
    void indexOfMax() {
        int[] array = new int[]{1, 1, 1, 1, 2, 2, 2};
        assertEquals(3, BinarySearchDuplicated.indexOfMax(array, 1));
    }

    @RepeatedTest(16)
    void indexOfMaxRandom() {
        int[] array = new int[StdRandom.uniform(10000)];
        for (int i = 0; i < array.length; i++) array[i] = StdRandom.uniform(Integer.MAX_VALUE);
        Arrays.sort(array);
        int[] duplicated = new int[array.length];
        duplicated[array.length - 1] = array.length - 1;
        for (int i = array.length - 2; i >= 0; i--) duplicated[i] = array[i] == array[i + 1] ? duplicated[i + 1] : i;
        for (int i = 0; i < array.length; i++)
            assertEquals(duplicated[i], BinarySearchDuplicated.indexOfMax(array, array[i]));
    }
}