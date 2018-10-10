import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class Sort6Test extends SortNTest {

    @Test
    public void testCase() {
        Map<String[], String> map = SortNTest.testMap(6);
        map.forEach((array, str) -> {
            Sort6.main(array);
            Assert.assertEquals(outputStream.toString(), str);
            outputStream.reset();
        });
    }
}
