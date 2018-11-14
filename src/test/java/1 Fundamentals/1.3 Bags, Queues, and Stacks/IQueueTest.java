import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static interceptor.StdIO.captureOutput;
import static org.junit.jupiter.api.Assertions.*;

abstract class IQueueTest {
    private IQueue<String> queue;

    IQueue<String> getQueue()           { return queue; }

    void setQueue(IQueue<String> queue) { this.queue = queue; }

    @Test
    void isEmpty() {
        assertTrue(getQueue().isEmpty());
        getQueue().enqueue("1");
        assertFalse(getQueue().isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, getQueue().size());
        getQueue().enqueue("1");
        assertEquals(1, getQueue().size());
        getQueue().enqueue("1");
        assertEquals(2, getQueue().size());
        getQueue().dequeue();
        assertEquals(1, getQueue().size());
    }

    @Test
    void enqueue() {
        getQueue().enqueue("1");
        getQueue().enqueue("2");
        getQueue().enqueue("3");
        assertEquals("123",
                     captureOutput(() -> { for (String item : getQueue()) StdOut.print(item); }));
    }

    @Test
    void dequeue() {
        getQueue().enqueue("1");
        getQueue().enqueue("2");
        getQueue().enqueue("3");
        assertEquals("123",
                     captureOutput(() -> {
                         StdOut.print(getQueue().dequeue());
                         StdOut.print(getQueue().dequeue());
                         StdOut.print(getQueue().dequeue());
                     }));
    }

    @Test
    void peek() {
        getQueue().enqueue("1");
        getQueue().enqueue("2");
        getQueue().enqueue("3");
        assertEquals("1", getQueue().peek());
    }

    @Test
    void iterator() {
        getQueue().enqueue("1");
        getQueue().enqueue("2");
        getQueue().enqueue("3");
        getQueue().dequeue();
        assertEquals("23",
                     captureOutput(() -> { for (String item : getQueue()) StdOut.print(item); }));
        getQueue().dequeue();
        assertEquals("3",
                     captureOutput(() -> { for (String item : getQueue()) StdOut.print(item); }));
    }
}
