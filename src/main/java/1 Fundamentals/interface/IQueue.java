public interface IQueue<Item> extends Iterable<Item> {

    boolean isEmpty();

    int size();

    void enqueue(Item item);

    Item dequeue();

    Item peek();
}
