import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static interceptor.StdIO.captureOutput;
import static org.junit.jupiter.api.Assertions.*;

abstract class IStackTest {
    private IStack<String> stack;

    IStack<String> getStack()          { return stack; }

    void setStack(IStack<String> stack) { this.stack = stack; }

    @Test
    void isEmpty() {
        assertTrue(getStack().isEmpty());
        getStack().push("1");
        assertFalse(getStack().isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, getStack().size());
        getStack().push("1");
        assertEquals(1, getStack().size());
        getStack().push("1");
        assertEquals(2, getStack().size());
        getStack().pop();
        assertEquals(1, getStack().size());
    }

    @Test
    void push() {
        getStack().push("1");
        getStack().push("2");
        getStack().push("3");
        assertEquals("321",
                     captureOutput(() -> { for (String item : getStack()) StdOut.print(item); }));
    }

    @Test
    void pop() {
        getStack().push("1");
        getStack().push("2");
        getStack().push("3");
        assertEquals("321",
                     captureOutput(() -> {
                         StdOut.print(getStack().pop());
                         StdOut.print(getStack().pop());
                         StdOut.print(getStack().pop());
                     }));
    }

    @Test
    void peek() {
        getStack().push("1");
        getStack().push("2");
        getStack().push("3");
        assertEquals("3", getStack().peek());
    }

    @Test
    void iterator() {
        getStack().push("1");
        getStack().push("2");
        getStack().push("3");
        getStack().pop();
        assertEquals("21",
                     captureOutput(() -> { for (String item : getStack()) StdOut.print(item); }));
        getStack().pop();
        assertEquals("1",
                     captureOutput(() -> { for (String item : getStack()) StdOut.print(item); }));
    }
}
