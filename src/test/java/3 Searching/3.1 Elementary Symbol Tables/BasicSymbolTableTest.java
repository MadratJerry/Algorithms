import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static interceptor.StdIO.captureOutput;
import static org.junit.jupiter.api.Assertions.*;

abstract class BasicSymbolTableTest {
    private BasicSymbolTable<String, Integer> st;

    BasicSymbolTable<String, Integer> getST() {
        return st;
    }

    void setST(BasicSymbolTable<String, Integer> st) {
        this.st = st;
    }

    @Test
    void putAndGet() {
        getST().put("First", 1);
        getST().put("Second", 2);
        assertEquals(1, (int) getST().get("First"));
        assertEquals(2, (int) getST().get("Second"));
        assertNull(getST().get("Third"));
        assertTrue(getST().contains("Second"));
    }

    @Test
    void putManyAndGet() {
        int maxSize = 1024;
        for (int i = 0; i < maxSize; i++) getST().put(i + "", i);
        assertEquals(maxSize - 1, (int) getST().get((maxSize - 1) + ""));
    }

    @Test
    void isEmpty() {
        assertTrue(getST().isEmpty());
        getST().put("First", 1);
        getST().delete("First");
        assertTrue(getST().isEmpty());
    }

    @Test
    void delete() {
        getST().put("First", 1);
        getST().put("Second", 2);
        getST().delete("Second");
        assertNull(getST().get("Second"));
    }

    @Test
    void size() {
        getST().put("First", 1);
        assertEquals(1, getST().size());
        getST().put("First", 0);
        assertEquals(1, getST().size());
        getST().put("Second", 2);
        assertEquals(2, getST().size());
    }

    @Test
    void keys() {
        getST().put("First", 1);
        getST().put("Second", 2);
        getST().put("Third", 3);
        assertEquals(
                "FirstSecondThird",
                captureOutput(() -> {
                    for (String key : st.keys()) StdOut.print(key);
                })
        );
    }
}
