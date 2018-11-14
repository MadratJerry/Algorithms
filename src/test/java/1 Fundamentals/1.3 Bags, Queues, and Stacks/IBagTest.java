import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static interceptor.StdIO.captureOutput;
import static org.junit.jupiter.api.Assertions.*;

abstract class IBagTest {
    private IBag<String> bag;

    IBag<String> getBag()         { return bag; }

    void setBag(IBag<String> bag) { this.bag = bag; }

    @Test
    void isEmpty() {
        assertTrue(getBag().isEmpty());
        getBag().add("1");
        assertFalse(getBag().isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, getBag().size());
        getBag().add("1");
        assertEquals(1, getBag().size());
        getBag().add("1");
        assertEquals(2, getBag().size());
    }

    @Test
    void add() {
        getBag().add("1");
        getBag().add("2");
        getBag().add("3");
        assertEquals("123",
                     Arrays.stream(captureOutput(() -> { for (String item : getBag()) StdOut.print(item); }).split(""))
                           .sorted()
                           .collect(Collectors.joining()));
    }

    @Test
    void iterator() { add(); }
}
