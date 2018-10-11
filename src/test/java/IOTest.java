import edu.princeton.cs.algs4.StdIn;
import org.junit.AfterClass;
import org.junit.Before;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public abstract class IOTest {
    private static Class<?> stdInClass = StdIn.class;
    private static Method setScannerMethod, resyncMethod;

    static PipedOutputStream stdInOutputStream;

    static {
        try {
            setScannerMethod = stdInClass.getDeclaredMethod("setScanner", Scanner.class);
            resyncMethod = stdInClass.getDeclaredMethod("resync");
            setScannerMethod.setAccessible(true);
            resyncMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void setScanner(Scanner scanner) throws InvocationTargetException, IllegalAccessException {
        setScannerMethod.invoke(stdInClass, scanner);
    }

    private static void resync() throws InvocationTargetException, IllegalAccessException {
        resyncMethod.invoke(stdInClass);
    }

    @Before
    public void init() throws IOException, InvocationTargetException, IllegalAccessException {
        stdInOutputStream = new PipedOutputStream();
        setScanner(new Scanner(new PipedInputStream(stdInOutputStream)));
    }

    @AfterClass
    public static void tearDownAll() throws InvocationTargetException, IllegalAccessException {
        resync();
    }
}
