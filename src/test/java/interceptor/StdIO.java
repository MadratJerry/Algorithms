package interceptor;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StdIO {
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

    private static void excute(Executable executable, LifeCycle lifeCycle) throws IllegalAccessException {
        lifeCycle.before();
        executable.execute();
        lifeCycle.after();
    }

    public static void injectInput(String providedInput, Executable executable) {
        try {
            excute(executable, new LifeCycle() {
                @Override
                public void before() throws IllegalAccessException {
                    scanner.set(Scanner.class, new Scanner(new ByteArrayInputStream(providedInput.getBytes())));
                }

                @Override
                public void after() throws IllegalAccessException {
                    scanner.set(Scanner.class, new Scanner(new java.io.BufferedInputStream(System.in), StandardCharsets.UTF_8));
                }
            });
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static String captureOutput(Executable executable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            excute(executable, new LifeCycle() {
                @Override
                public void before() throws IllegalAccessException {
                    printer.set(PrintWriter.class, new PrintWriter(outputStream));
                }

                @Override
                public void after() throws IllegalAccessException {
                    printer.set(PrintWriter.class,
                            new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true));
                }
            });
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return outputStream.toString();
    }
}
