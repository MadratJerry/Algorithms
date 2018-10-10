import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class SortNTest {
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanStream() {
        System.setOut(null);
    }

    public static String[] getArray(int length) {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) array[i] = "0";
        return array;
    }

    public static HashMap<String[], String> testMap(int n) {
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
}
