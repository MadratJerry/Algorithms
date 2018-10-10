import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class Sort4Test extends SortNTest {

    @Test
    public void testCase() {
        Map<String[], String> map = SortNTest.testMap(4);
        map.forEach((array, str) -> {
            Sort4.main(array);
            Assert.assertEquals(outputStream.toString(), str);
            outputStream.reset();
        });
    }
}
