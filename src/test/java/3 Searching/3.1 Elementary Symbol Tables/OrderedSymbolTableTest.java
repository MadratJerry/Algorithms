import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static interceptor.StdIO.captureOutput;
import static org.junit.jupiter.api.Assertions.*;

abstract class OrderedSymbolTableTest extends BasicSymbolTableTest {

    @Override
    OrderedSymbolTable<String, String> getST() {
        return (OrderedSymbolTable<String, String>) super.getST();
    }


    @Test
    void rank() {
        assertEquals(7, getST().rank("09:10:25"));
        assertThrows(IllegalArgumentException.class, () -> getST().rank(null));
    }

    @Test
    void keys() {
        assertEquals(
                "09:19:32" +
                "09:19:46" +
                "09:21:05" +
                "09:22:43" +
                "09:22:54",
                captureOutput(() -> {
                    for (String key : getST().keys("09:15:00", "09:25:00")) StdOut.print(key);
                })
        );
        super.keys();
    }

    @Test
    void size() {
        assertEquals(5, getST().size("09:15:00", "09:25:00"));
        super.size();
    }

    @Test
    void min() {
        assertEquals("09:00:00", getST().min());
    }

    @Test
    void max() {
        assertEquals("09:37:44", getST().max());
    }

    @Test
    void deleteMin() {
        for (int i = 0, size = getST().size(); i < size; i++)
            getST().deleteMin();
        assertEquals(0, getST().size());
    }

    @Test
    void deleteMax() {
        for (int i = 0, size = getST().size(); i < size; i++)
            getST().deleteMax();
        assertEquals(0, getST().size());
    }

    @Test
    void select() {
        assertEquals("09:10:25", getST().select(7));
    }

    @Test
    void floor() {
        assertEquals("09:03:13", getST().floor("09:05:00"));
        assertEquals("09:00:00", getST().floor("09:00:00"));
        assertEquals("09:37:44", getST().floor("10:00:00"));
        assertNull(getST().floor("05:58:59"));
    }

    @Test
    void ceiling() {
        assertEquals("09:35:21", getST().ceiling("09:35:00"));
        assertEquals("09:00:00", getST().ceiling("09:00:00"));
        assertEquals("09:00:03", getST().ceiling("09:00:01"));
        assertNull(getST().ceiling("09:37:45"));
    }
}
