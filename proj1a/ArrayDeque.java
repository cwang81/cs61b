public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Resizes the item array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        size = capacity;
    }

    public void addLast(Item i) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = i;
        size++;
    }

    public Item removeLast() {
        Item i = items[size];
        items[size] = null;
        size--;
        return i;
    }

    public ArrayDeque(ArrayDeque other) {
        Item[] A = (Item[]) new Object[size];

        for(int i = 0; i < size; i++) {
            A[i] = items[i];
        }
    }

}
