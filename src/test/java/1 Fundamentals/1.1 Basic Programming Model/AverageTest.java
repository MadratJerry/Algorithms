import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static interceptor.StdIO.captureOutput;
import static interceptor.StdIO.injectInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageTest {

    @RepeatedTest(16)
    void main() {
        int size = StdRandom.uniform(1024) + 1;
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            list.add((StdRandom.uniform(Integer.MIN_VALUE / 4, Integer.MAX_VALUE / 4)));
        assertEquals(
                captureOutput(() -> injectInput(
                        list.stream().map(Object::toString).collect(Collectors.joining(" ")),
                        Average::main)),
                captureOutput(() -> injectInput(
                        list.stream().map(Object::toString).collect(Collectors.joining(" ")),
                        () -> edu.princeton.cs.algs4.Average.main(null)
                ))
        );
    }
}