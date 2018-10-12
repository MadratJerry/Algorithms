import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class Sort5Test extends SortNTest {

    @Test
    public void testCase() {
        Map<String[], String> map = SortNTest.testMap(5);
        map.forEach((array, str) -> {
            Sort5.main(array);
            Assertions.assertEquals(outputStream.toString(), str);
            outputStream.reset();
        });
    }
}
