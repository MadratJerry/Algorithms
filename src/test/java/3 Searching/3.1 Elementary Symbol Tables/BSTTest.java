import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BSTTest extends OrderedSymbolTableTest {

    BSTTest() {
        setST(new BST<>());
    }

    @Test
    void height() {
        setST(new BST<>());
        String[] keyArray = map.keySet().toArray(String[]::new);
        Arrays.sort(keyArray);
        for (String key : keyArray)
            getST().put(key, map.get(key));
        assertEquals(map.size(), ((BST) getST()).height());
    }
}
