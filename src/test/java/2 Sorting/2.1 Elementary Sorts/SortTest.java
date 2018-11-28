import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

abstract class SortTest {

    @RepeatedTest(16)
    void sort() throws ClassNotFoundException, NoSuchMethodException,
                       InvocationTargetException,
                       IllegalAccessException {
        String   className   = this.getClass().getName().split("Test")[0];
        Class<?> classObject = Class.forName(className);
        Method   method      = classObject.getMethod("sort", Comparable[].class);

        int       size = StdRandom.uniform(10000);
        Integer[] a    = new Integer[size];
        Integer[] b    = new Integer[size];
        for (int i = 0; i < size; i++) a[i] = b[i] = StdRandom.uniform(Integer.MAX_VALUE);
        method.invoke(null, new Object[]{b});
        Arrays.sort(a);
        assertArrayEquals(a, b);
    }
}
