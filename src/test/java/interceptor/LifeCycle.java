package interceptor;

public interface LifeCycle<T> {

    default void before() throws IllegalAccessException {
        // default do nothing
    }

    default void after() throws IllegalAccessException {
        // default do nothing
    }
}
