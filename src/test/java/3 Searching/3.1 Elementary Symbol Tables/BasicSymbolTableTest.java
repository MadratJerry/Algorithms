import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static interceptor.StdIO.captureOutput;
import static org.junit.jupiter.api.Assertions.*;

abstract class BasicSymbolTableTest {
    private BasicSymbolTable<String, String> st;

    BasicSymbolTable<String, String> getST() {
        return st;
    }

    void setST(BasicSymbolTable<String, String> st) {
        this.st = st;
    }

    @BeforeEach
    void setUp() {
        getST().put("09:00:00", "Chicago");
        getST().put("09:00:03", "Phoenix");
        getST().put("09:00:13", "Houston");
        getST().put("09:00:59", "Chicago");
        getST().put("09:01:10", "Houston");
        getST().put("09:03:13", "Chicago");
        getST().put("09:10:11", "Seattle");
        getST().put("09:10:25", "Seattle");
        getST().put("09:14:25", "Phoenix");
        getST().put("09:19:32", "Chicago");
        getST().put("09:19:46", "Chicago");
        getST().put("09:21:05", "Chicago");
        getST().put("09:22:43", "Seattle");
        getST().put("09:22:54", "Seattle");
        getST().put("09:25:52", "Chicago");
        getST().put("09:35:21", "Chicago");
        getST().put("09:36:14", "Seattle");
        getST().put("09:37:44", "Phoenix");
    }

    @Test
    void put() {
        assertEquals("Phoenix", getST().get("09:00:03"));
        assertEquals("Phoenix", getST().get("09:37:44"));
    }

    @Test
    void get() {
        put();
        assertNull(getST().get("10:00:00"));
    }

    @Test
    void contains() {
        assertTrue(getST().contains("09:19:46"));
        assertFalse(getST().contains("09:19:47"));
    }

    @Test
    void isEmpty() {
        assertFalse(getST().isEmpty());
        for (String key : getST().keys())
            getST().delete(key);
        assertTrue(getST().isEmpty());
    }

    @Test
    void delete() {
        getST().delete("09:01:10");
        assertNull(getST().get("09:01:10"));
    }

    @Test
    void size() {
        assertEquals(18, getST().size());
        for (String key : getST().keys())
            getST().delete(key);
        assertEquals(0, getST().size());
    }

    @Test
    void keys() {
        assertEquals(
                "09:00:0009:00:0309:00:1309:00:5909:01:1009:03:1309:10:1109:10:2509:14:2509:19:3209:19:4609:21:0509:22:4309:22:5409:25:5209:35:2109:36:1409:37:44",
                captureOutput(() -> {
                    for (String key : st.keys()) StdOut.print(key);
                })
        );
    }
}
