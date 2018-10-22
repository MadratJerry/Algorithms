import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

abstract class BasicSymbolTableTest {
    private BasicSymbolTable<String, String> st;
    private final static Map<String, String> map = new HashMap<>();

    BasicSymbolTable<String, String> getST() {
        return st;
    }

    void setST(BasicSymbolTable<String, String> st) {
        this.st = st;
    }

    @BeforeAll
    static void setUpAll() {
        map.put("09:00:00", "Chicago");
        map.put("09:00:03", "Phoenix");
        map.put("09:00:13", "Houston");
        map.put("09:00:59", "Chicago");
        map.put("09:01:10", "Houston");
        map.put("09:03:13", "Chicago");
        map.put("09:10:11", "Seattle");
        map.put("09:10:25", "Seattle");
        map.put("09:14:25", "Phoenix");
        map.put("09:19:32", "Chicago");
        map.put("09:19:46", "Chicago");
        map.put("09:21:05", "Chicago");
        map.put("09:22:43", "Seattle");
        map.put("09:22:54", "Seattle");
        map.put("09:25:52", "Chicago");
        map.put("09:35:21", "Chicago");
        map.put("09:36:14", "Seattle");
        map.put("09:37:44", "Phoenix");
    }

    @BeforeEach
    void setUp() {
        String[] keyArray = map.keySet().toArray(String[]::new);
        StdRandom.shuffle(keyArray);

        for (String key : keyArray) getST().put(key, map.get(key));
    }

    @Test
    void put() {
        assertEquals("Phoenix", getST().get("09:00:03"));
        assertEquals("Phoenix", getST().get("09:37:44"));
        assertThrows(IllegalArgumentException.class, () -> getST().put(null, "Whatever"));
    }

    @Test
    void get() {
        put();
        assertNull(getST().get("10:00:00"));
        assertThrows(IllegalArgumentException.class, () -> getST().get(null));
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
        assertThrows(IllegalArgumentException.class, () -> getST().delete(null));
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
        Set<String> set = map.keySet();
        for (String key : getST().keys())
            assertTrue(set.contains(key));
    }
}
