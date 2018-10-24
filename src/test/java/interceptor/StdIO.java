package interceptor;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StdIO {
    private static Class<?> stdInClass  = StdIn.class;
    private static Class<?> stdOutClass = StdOut.class;
    private static Field    scanner, printer;

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

    private static void execute(Executable execute, Executable beforeExecute, Executable afterExecute) throws
                                                                                                       Throwable {
        beforeExecute.execute();
        execute.execute();
        afterExecute.execute();
    }

    public static void injectInput(String providedInput, Executable execute) {
        try {
            execute(execute,
                    () -> scanner.set(Scanner.class, new Scanner(
                            new ByteArrayInputStream(providedInput.getBytes()))),
                    () -> scanner.set(Scanner.class, new Scanner(
                            new java.io.BufferedInputStream(System.in), StandardCharsets.UTF_8))
            );
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static String captureOutput(Executable execute) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            execute(execute,
                    () -> printer.set(PrintWriter.class, new PrintWriter(outputStream)),
                    () -> new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true)
            );
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return outputStream.toString();
    }
}
