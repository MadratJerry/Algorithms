package base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Scanner;

public class StdIOAssertion {
    private static Class<?> stdInClass = StdIn.class;
    private static Class<?> stdOutClass = StdOut.class;
    private static Field scanner, printer;

    static {
        try {
            scanner = stdInClass.getDeclaredField("scanner");
            printer = stdOutClass.getDeclaredField("out");
            scanner.setAccessible(true);
            printer.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void assetIOEquals(String providedInput, Executable executable, String expectedOutput) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            scanner.set(Scanner.class, new Scanner(new ByteArrayInputStream(providedInput.getBytes())));
            printer.set(PrintWriter.class, new PrintWriter(outputStream));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assertions.fail();
        }
        executable.execute();
        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }
}
