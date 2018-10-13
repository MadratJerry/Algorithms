import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static interceptor.StdIO.captureOutput;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class SortNTest {

    private static String[] getArray(int length) {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) array[i] = "0";
        return array;
    }

    private static HashMap<String[], String> testMap(int n) {
        HashMap<String[], String> map = new HashMap<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            int num = i, index = 0;
            String[] array = SortNTest.getArray(n);
            while (num != 0) {
                array[index++] = num % 2 + "";
                num /= 2;
            }
            map.put(array, Arrays.stream(array.clone()).sorted().collect(Collectors.joining(" ")).concat("\n"));
        }
        return map;
    }

    @TestFactory
    Stream<DynamicTest> dynamicSortNTest() {
        return Stream.of(3, 4, 5, 6)
                .map(index -> dynamicTest(String.format("Sort%dTest", index), () -> {
                    Map<String[], String> map = SortNTest.testMap(index);
                    map.forEach((array, result) ->
                            assertEquals(
                                    captureOutput(
                                            () -> {
                                                try {
                                                    Class sortClass = Class.forName("Sort" + index);
                                                    @SuppressWarnings("unchecked")
                                                    Method mainMethod = sortClass.getMethod("main", String[].class);
                                                    mainMethod.invoke(sortClass, new Object[]{array});
                                                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                    ),
                                    result
                            ));
                }));
    }

}
