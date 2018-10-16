import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static interceptor.StdIO.captureOutput;
import static org.junit.jupiter.api.Assertions.*;

abstract class SymbolTableTest {
    SymbolTable<String, Integer> st;

    @Test
    void putAndGet() {
        st.put("First", 1);
        st.put("Second", 2);
        assertEquals(1, (int) st.get("First"));
        assertEquals(2, (int) st.get("Second"));
        assertNull(st.get("Third"));
        assertTrue(st.contains("Second"));
    }

    @Test
    void isEmpty() {
        assertTrue(st.isEmpty());
        st.put("First", 1);
        st.delete("First");
        assertTrue(st.isEmpty());
    }

    @Test
    void delete() {
        st.put("First", 1);
        st.put("Second", 2);
        st.delete("Second");
        assertNull(st.get("Second"));
    }

    @Test
    void size() {
        st.put("First", 1);
        assertEquals(st.size(), 1);
        st.put("First", 0);
        assertEquals(st.size(), 1);
        st.put("Second", 2);
        assertEquals(st.size(), 2);
    }

    @Test
    void keys() {
        st.put("First", 1);
        st.put("Second", 2);
        st.put("Third", 3);
        assertEquals(
                "FirstSecondThird",
                captureOutput(() -> {
                    for (String key : st.keys()) StdOut.print(key);
                })
        );
    }
}
