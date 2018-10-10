import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class Sort5Test extends SortNTest {

    @Test
    public void testCase() {
        Map<String[], String> map = SortNTest.testMap(5);
        map.forEach((array, str) -> {
            Sort5.main(array);
            Assert.assertEquals(outputStream.toString(), str);
            outputStream.reset();
        });
    }
}
