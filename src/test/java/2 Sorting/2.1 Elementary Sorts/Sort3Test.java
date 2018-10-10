import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class Sort3Test extends SortNTest {

    @Test
    public void testCase() {
        Map<String[], String> map = SortNTest.testMap(3);
        map.forEach((array, str) -> {
            Sort3.main(array);
            Assert.assertEquals(outputStream.toString(), str);
            outputStream.reset();
        });
    }
}
